import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateSalary();

    void displayDetails() {
        System.out.println("\nName: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

interface Benefits {
    double calculateBenefits();
}

class Manager extends Employee implements Benefits {
    double bonus;

    Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    double calculateSalary() {
        return salary + bonus;
    }

    public double calculateBenefits() {
        return 5000; // Fixed insurance benefit
    }

    void assignProject(String projectName) {
        System.out.println(name + " assigned to project: " + projectName);
    }

    void assignProject(String projectName, int teamSize) {
        System.out.println(name + " assigned to project: " + projectName + " with team size: " + teamSize);
    }
}

class Developer extends Employee implements Benefits {
    int experience;

    Developer(String name, double salary, int experience) {
        super(name, salary);
        this.experience = experience;
    }

    double calculateSalary() {
        return salary + (experience * 1000);
    }

    public double calculateBenefits() {
        return experience * 500; // Allowance based on experience
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter type (Manager/Developer): ");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("Manager")) {
                System.out.print("Enter bonus amount: ");
                double bonus = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                employees.add(new Manager(name, salary, bonus));
            } else if (type.equalsIgnoreCase("Developer")) {
                System.out.print("Enter experience (years): ");
                int experience = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                employees.add(new Developer(name, salary, experience));
            } else {
                System.out.println("Invalid entry.");
            }
        }

        System.out.println("\nEmployee Details");
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Benefits) {
                System.out.println("Benefits: " + ((Benefits) emp).calculateBenefits());
            }
        }

        scanner.close();
    }
}
