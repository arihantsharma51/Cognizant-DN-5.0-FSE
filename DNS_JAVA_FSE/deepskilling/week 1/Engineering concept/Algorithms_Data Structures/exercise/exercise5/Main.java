package exercise5;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        Task t1 = new Task(101, "Design UI", "Pending");
        Task t2 = new Task(102, "Write Backend", "Pending");
        Task t3 = new Task(103, "Testing", "Completed");

        // Add Tasks

        manager.addTask(t1);
        manager.addTask(t2);
        manager.addTask(t3);

        // Display Tasks

        System.out.println("\n===== All Tasks =====");

        manager.displayTasks();

        // Search Task

        System.out.println("\n===== Search Task =====");

        Task result = manager.searchTask(102);

        if (result != null) {

            System.out.println(result);

        } else {

            System.out.println("Task Not Found.");

        }

        // Delete Task

        System.out.println("\n===== Delete Task =====");

        manager.deleteTask(102);

        // Display Again

        System.out.println("\n===== Updated Task List =====");

        manager.displayTasks();

    }

}