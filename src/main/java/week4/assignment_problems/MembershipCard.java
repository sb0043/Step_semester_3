package week4.assignment_problems;

public class MembershipCard {
    private static String libraryName;
    private static String validUntil;

    private String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    public void printIssueConfirmation() {
        System.out.println("Membership card issued: " + studentName);
    }

    public static void main(String[] args) {
        String[] studentNames = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String studentName : studentNames) {
            MembershipCard card = new MembershipCard(studentName);
            card.printIssueConfirmation();
        }
    }
}