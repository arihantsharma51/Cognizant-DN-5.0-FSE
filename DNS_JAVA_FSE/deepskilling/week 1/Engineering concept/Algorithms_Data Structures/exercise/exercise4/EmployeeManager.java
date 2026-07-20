package exercise4;

public class EmployeeManager {

    private Employee[] employees;
    private int count;

    public EmployeeManager() {
        employees = new Employee[5];
        count = 0;
    }

    // Add 
    public void addEmployee(Employee employee) {

        if (count < employees.length) {

            employees[count] = employee;
            count++;

            System.out.println("Employee Added Successfully.");

        } else {

            System.out.println("Employee Array is Full.");

        }

    }

    // Search 
    public Employee searchEmployee(int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == employeeId) {

                return employees[i];

            }

        }

        return null;

    }

    // Display 
    public void displayEmployees() {

        if (count == 0) {

            System.out.println("No Employees Found.");
            return;

        }

        for (int i = 0; i < count; i++) {

            System.out.println(employees[i]);
            System.out.println("-------------------------");

        }

    }

    // Delete 
    public void deleteEmployee(int employeeId) {

        int index = -1;

        // Search 
        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == employeeId) {

                index = i;
                break;

            }

        }

        if (index == -1) {

            System.out.println("Employee Not Found.");
            return;

        }

        // Shift 
        for (int i = index; i < count - 1; i++) {

            employees[i] = employees[i + 1];

        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted Successfully.");

    }

}