package Concurrency;

// 1. Define the task (The Recipe)
class TaskPrinter implements Runnable {
    private String name;

    public TaskPrinter(String name){
        this.name = name;
    }

    // The run method contains the code, the thread will actually execute
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(name + " is working: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 2. Create the tasks (Recipes)
        TaskPrinter recipeA = new TaskPrinter("Thread A");
        TaskPrinter recipeB = new TaskPrinter("Thread B");

        // 3. Hire the Chefs (Threads) and hand them the recipes
        Thread chef1 = new Thread(recipeA);
        Thread chef2 = new Thread(recipeB);

        // 4. Start the work
        System.out.println("--- Starting Threads ----");
        chef1.start();
        chef2.start();

        chef1.join();
        chef2.join();

        System.out.println("--- Main Method Finished ---");
    }
}