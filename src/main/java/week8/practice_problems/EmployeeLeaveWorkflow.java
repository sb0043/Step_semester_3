package week8.practice_problems;

abstract class Employee {
    private String name;

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean canTakeLeave(int days);
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }

    @Override
    public boolean canTakeLeave(int days) {
        return days > 0 && days <= 30;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }

    @Override
    public boolean canTakeLeave(int days) {
        return days > 0 && days <= 15;
    }
}

class Contractor extends Employee {
    Contractor(String name) {
        super(name);
    }

    @Override
    public boolean canTakeLeave(int days) {
        return days > 0 && days <= 10;
    }
}

class LeaveRequest {
    private Employee employee;
    private String startDate;
    private String endDate;
    private int days;
    private String status;

    LeaveRequest(Employee employee, String startDate, String endDate, int days) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        this.status = "Pending";
    }

    public void approve() {
        if ("Pending".equals(status)) {
            if (employee.canTakeLeave(days)) {
                status = "Approved";
                System.out.println(
                    employee.getName()
                    + "'s leave request ("
                    + startDate + "-" + endDate
                    + ") approved. Status: Approved."
                );
            } else {
                System.out.println(
                    "Leave policy does not allow this request for "
                    + employee.getName() + "."
                );
            }
        }
    }

    public void reject() {
        if ("Pending".equals(status)) {
            status = "Rejected";

            System.out.println(
                employee.getName()
                + "'s leave request ("
                + startDate + "-" + endDate
                + ") rejected. Status: Rejected."
            );
        }
    }

    public void setStatus(String newStatus) {
        if (!"Pending".equals(status)) {
            System.out.println(
                "Cannot change leave request status from "
                + status + " to " + newStatus + "."
            );
            return;
        }

        if ("Approved".equals(newStatus) || "Rejected".equals(newStatus)) {
            status = newStatus;
        }
    }
}

class LeaveManager {
    public LeaveRequest submit(
        Employee employee,
        String startDate,
        String endDate,
        int days
    ) {
        LeaveRequest request =
            new LeaveRequest(employee, startDate, endDate, days);

        System.out.println(
            "Leave request submitted for "
            + employee.getName()
            + " (" + startDate + "-" + endDate + ")."
        );
        System.out.println("Status: Pending.");

        return request;
    }
}

public class EmployeeLeaveWorkflow {
    public static void main(String[] args) {
        LeaveManager manager = new LeaveManager();

        Employee john = new FullTimeEmployee("John");
        LeaveRequest johnRequest =
            manager.submit(john, "Jan 1", "Jan 5", 5);

        johnRequest.approve();

        Employee jane = new PartTimeEmployee("Jane");
        LeaveRequest janeRequest =
            manager.submit(jane, "Feb 10", "Feb 11", 2);

        janeRequest.reject();

        johnRequest.setStatus("Pending");
    }
}