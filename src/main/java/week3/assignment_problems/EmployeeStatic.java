package week3.assignment_problems;

public class EmployeeStatic {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeStatic employee1 =
                new EmployeeStatic("Divya", 65000);

        EmployeeStatic employee2 =
                new EmployeeStatic("Arjun", 40000);

        EmployeeStatic employee3 =
                new EmployeeStatic("Karthik", 50000);

        EmployeeStatic.printCompanyInfo();
    }
}