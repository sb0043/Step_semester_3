package oop.assignment_problems;

public class HallTicket {

    String studentName;
    String exam;
    int seatNumber;

    public HallTicket(String studentName, String exam, int seatNumber) {
        this.studentName = studentName;
        this.exam = exam;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        HallTicket ticket1 =
                new HallTicket("Ravi", "Java", 101);

        HallTicket ticket2 = ticket1;

        ticket2.seatNumber = 202;

        System.out.println("ticket1 seatNumber: " + ticket1.seatNumber);
        System.out.println("ticket2 seatNumber: " + ticket2.seatNumber);
        System.out.println("ticket1 == ticket2: " + (ticket1 == ticket2));

        HallTicket ticket3 =
                new HallTicket("Ravi", "Java", 202);

        System.out.println("ticket1 == ticket3: " + (ticket1 == ticket3));
    }
}