import java.util.Scanner;

class Employee {
    int empNo;
    String name;
    double salary;

    Employee(int empNo, String name, double salary) {
        this.empNo = empNo;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee Number: " + empNo);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Employee Number: ");
            int empNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            employees[i] = new Employee(empNo, name, salary);
        }

        System.out.print("Enter Employee Number to search: ");
        int searchNo = scanner.nextInt();
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.empNo == searchNo) {
                System.out.println("Employee Found:");
                emp.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }
}
