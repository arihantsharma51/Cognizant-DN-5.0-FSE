package exercise4;

public class Main {

    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager();

        Employee e1 = new Employee(101, "Rahul", "Developer", 50000);
        Employee e2 = new Employee(102, "Aman", "Tester", 40000);
        Employee e3 = new Employee(103, "Priya", "Manager", 70000);

        // Add 
        manager.addEmployee(e1);
        manager.addEmployee(e2);
        manager.addEmployee(e3);

        System.out.println("\n===== All Employees =====");
        manager.displayEmployees();

        System.out.println("\n===== Search Employee =====");

        Employee result = manager.searchEmployee(102);

        if (result != null) {

            System.out.println(result);

        } else {

            System.out.println("Employee Not Found.");

        }

        System.out.println("\n===== Delete Employee =====");

        manager.deleteEmployee(102);

        System.out.println("\n===== Updated Employee List =====");

        manager.displayEmployees();

    }

}