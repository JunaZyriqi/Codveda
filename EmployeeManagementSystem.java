import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(id, name, salary);
        employees.add(emp);

        System.out.println("Employee added successfully.");
    }

    public static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee e : employees) {
            e.display();
        }
    }

    public static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee e : employees) {
            if (e.getId() == id) {

                System.out.print("Enter new name: ");
                String name = scanner.nextLine();

                System.out.print("Enter new salary: ");
                double salary = scanner.nextDouble();

                e.setName(name);
                e.setSalary(salary);

                System.out.println("Employee updated.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    public static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();

        for (Employee e : employees) {
            if (e.getId() == id) {
                employees.remove(e);
                System.out.println("Employee deleted.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    updateEmployee();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
