package oop.assignment_problems;

public class EmployeeSalary {

    String name;
    double salary;

    static String companyName = "SRM Institute of Science and Technology";
    static int employeeCount = 0;

    public EmployeeSalary(String name, double salary) {
        this.name = name;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Students created: " + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeSalary employee1 =
                new EmployeeSalary("Ravi", 50000);

        EmployeeSalary employee2 =
                new EmployeeSalary("Priya", 60000);

        EmployeeSalary.printCompanyInfo();
    }
}