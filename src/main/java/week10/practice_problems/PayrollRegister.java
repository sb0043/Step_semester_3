
package week10.practice_problems;

import java.util.Scanner;

class Employee {
    String name;
    String type;

    Employee(String name, String type) {
        this.name = name;
        this.type = type;
    }

    int calculatePay() {
        return 0;
    }
}

class FullTimeEmployee extends Employee {
    int salary;

    FullTimeEmployee(String name, int salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    @Override
    int calculatePay() {
        return salary;
    }
}

class PartTimeEmployee extends Employee {
    int hours;
    int rate;

    PartTimeEmployee(String name, int hours, int rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    int calculatePay() {
        return hours * rate;
    }
}

class InternEmployee extends Employee {
    int stipend;

    InternEmployee(String name, int stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    @Override
    int calculatePay() {
        return stipend;
    }
}

class Payslip {
    String name;
    String type;
    int pay;

    Payslip(Employee employee) {
        name = employee.name;
        type = employee.type;
        pay = employee.calculatePay();
    }

    @Override
    public String toString() {
        return "Payslip[name=" + name + ", type=" + type
                + ", pay=" + pay + "]";
    }
}

public class PayrollRegister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[3];

        for (int i = 0; i < employees.length; i++) {
            String type = sc.next();

            if (type.equalsIgnoreCase("FullTime")) {
                String name = sc.next();
                int salary = sc.nextInt();
                employees[i] = new FullTimeEmployee(name, salary);
            } else if (type.equalsIgnoreCase("PartTime")) {
                String name = sc.next();
                int hours = sc.nextInt();
                int rate = sc.nextInt();
                employees[i] = new PartTimeEmployee(name, hours, rate);
            } else if (type.equalsIgnoreCase("Intern")) {
                String name = sc.next();
                int stipend = sc.nextInt();
                employees[i] = new InternEmployee(name, stipend);
            }
        }

        Payslip[] payslips = new Payslip[employees.length];
        int total = 0;
        Payslip topEarner = null;

        for (int i = 0; i < employees.length; i++) {
            payslips[i] = new Payslip(employees[i]);
            System.out.println(payslips[i]);

            total += payslips[i].pay;

            if (topEarner == null || payslips[i].pay > topEarner.pay) {
                topEarner = payslips[i];
            }
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + topEarner.name);

        sc.close();
    }
}
