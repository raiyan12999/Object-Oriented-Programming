package Concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SushiBarDemo {

    // THE SHARED BUFFER (The Counter)
    // It's just a list of Strings (Sushi names)
    static Queue<String> sushiCounter = new LinkedList<>();

    // SEMAPHORE 1: Controls "Is there space to put food?"
    // Starts with 3, because we have 3 empty spots.
    static Semaphore emptySlots = new Semaphore(3);

    // SEMAPHORE 2: Controls "Is there food to eat?"
    // Starts with 0, because we have 0 sushi initially.
    static Semaphore fullSlots = new Semaphore(0);

    // SEMAPHORE 3: The Mutex (The Lock)
    // Starts with 1, because only 1 person touches the counter at a time.
    static Semaphore mutex = new Semaphore(1);

    // --- THE CHEF (Producer) ---
    static class Chef implements Runnable {
        public void run() {
            try {
                while (true) {
                    // 1. Make the food (takes time)
                    Thread.sleep(1000);
                    String sushi = "Salmon Roll";

                    // 2. Check: Are there empty slots?
                    // If count is 0, Chef SLEEPS here until Customer eats something.
                    emptySlots.acquire();

                    // 3. Lock the counter (Mutual Exclusion)
                    mutex.acquire();

                    // --- CRITICAL SECTION (Touching the shared list) ---
                    sushiCounter.add(sushi);
                    System.out.println("Chef made " + sushi + ". [Counter: " + sushiCounter.size() + "/3]");
                    // ---------------------------------------------------

                    // 4. Unlock the counter
                    mutex.release();

                    // 5. Signal the Customer: "Hey, there is 1 more full plate!"
                    fullSlots.release();
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    // --- THE CUSTOMER (Consumer) ---
    static class Customer implements Runnable {
        public void run() {
            try {
                while (true) {
                    // 1. Check: Is there food?
                    // If count is 0, Customer SLEEPS here until Chef makes something.
                    fullSlots.acquire();


                    // 2. Lock the counter
                    mutex.acquire();

                    // --- CRITICAL SECTION ---
                    String food = sushiCounter.poll(); // Take from list
                    System.out.println("Customer ate " + food + ". [Counter: " + sushiCounter.size() + "/3]");
                    // ------------------------

                    // 3. Unlock the counter
                    mutex.release();

                    // 4. Signal the Chef: "Hey, I made an empty space!"
                    emptySlots.release();

                    // 5. Eat the food (takes time)
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Opening Sushi Bar ---");

        // Create threads
        Thread chef = new Thread(new Chef());
        Thread customer = new Thread(new Customer());

        // Start them
        chef.start();
        customer.start();
    }
}
