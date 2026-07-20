package exercise5;

public class TaskManager {

    private Task head;

    public TaskManager() {
        head = null;
    }

    // Add Task
    public void addTask(Task task) {

        if (head == null) {

            head = task;

        } else {

            Task current = head;

            while (current.next != null) {

                current = current.next;

            }

            current.next = task;

        }

        System.out.println("Task Added Successfully.");

    }

    // Display Tasks
    public void displayTasks() {

        if (head == null) {

            System.out.println("No Tasks Available.");
            return;

        }

        Task current = head;

        while (current != null) {

            System.out.println(current);
            System.out.println("-----------------------");

            current = current.next;

        }

    }

    // Search Task
    public Task searchTask(int taskId) {

        Task current = head;

        while (current != null) {

            if (current.getTaskId() == taskId) {

                return current;

            }

            current = current.next;

        }

        return null;

    }

    // Delete Task
    public void deleteTask(int taskId) {

        if (head == null) {

            System.out.println("Task List is Empty.");
            return;

        }

        // Delete First Node

        if (head.getTaskId() == taskId) {

            head = head.next;

            System.out.println("Task Deleted Successfully.");
            return;

        }

        Task current = head;
        Task previous = null;

        while (current != null && current.getTaskId() != taskId) {

            previous = current;
            current = current.next;

        }

        if (current == null) {

            System.out.println("Task Not Found.");
            return;

        }

        previous.next = current.next;

        System.out.println("Task Deleted Successfully.");

    }

}