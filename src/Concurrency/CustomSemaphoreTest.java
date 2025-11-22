package Concurrency;

class MySimpleSemaphore {
    private int tokens;

    public MySimpleSemaphore(int initialPermits) {
        this.tokens = initialPermits;
    }

    // Wait / P / Acquire
    public synchronized void acquire() throws InterruptedException {
        // If no tokens, we sleep.
        // CRITICAL: Use 'while', not 'if', to handle spurious wakeups.
        while (tokens == 0) {
            wait(); // Releases lock and sleeps
        }

        // If we pass the loop, it means tokens > 0.
        tokens--; // Take one
    }

    // Signal / V / Release
    public synchronized void release() {
        tokens++; // Return one
        notify(); // Wake up a thread stuck in the 'wait' loop above
    }
}

public class CustomSemaphoreTest {
    public static void main(String[] args) {
        // Start with 1 token (Mutex behavior)
        MySimpleSemaphore sem = new MySimpleSemaphore(1);

        Runnable task = new Runnable() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " trying...");
                    sem.acquire();
                    System.out.println(Thread.currentThread().getName() + " GOT IT!");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                finally {
                    System.out.println(Thread.currentThread().getName() + " releasing.");
                    sem.release();
                }
            }
        };

        new Thread(task, "Thread A").start();
        new Thread(task, "Thread B").start();
    }
}