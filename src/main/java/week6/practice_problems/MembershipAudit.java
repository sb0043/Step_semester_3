package week6.practice_problems;

class LibraryMember {
    private static int nextNumber = 1000;

    private final int memberNumber;
    private final String memberId;
    private int booksBorrowed;

    LibraryMember(String memberId) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.memberNumber = ++nextNumber;
        this.booksBorrowed = 0;
    }

    void borrowBook() {
        booksBorrowed++;
    }

    void borrowBook(String genre) {
        borrowBook();
    }

    String getRenewalCode() {
        int numberPart = memberNumber % 100;
        char letter = Character.toUpperCase(memberId.charAt(0));

        return "R" + String.format("%02d", numberPart) + letter;
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    void displayInfo() {
        System.out.print(
            "Member: " + memberId +
            " | Number: " + memberNumber +
            " | Books: " + booksBorrowed +
            " | Renewal: " + getRenewalCode()
        );
    }
}

class StudentMember extends LibraryMember {
    private final String course;

    StudentMember(String memberId, String course) {
        super(memberId);
        this.course = course;
    }

    @Override
    void displayInfo() {
        System.out.print(
            "Student | Course: " + course +
            " | Books: " + getBooksBorrowed() +
            " | Renewal: " + getRenewalCode()
        );
    }
}

class FacultyMember extends LibraryMember {
    FacultyMember(String memberId) {
        super(memberId);
    }

    @Override
    void displayInfo() {
        System.out.print(
            "Faculty | Books: " + getBooksBorrowed() +
            " | Renewal: " + getRenewalCode()
        );
    }
}

public class MembershipAudit {

    static void processNightlyAudit(LibraryMember[] members) {

        for (LibraryMember member : members) {

            if (member == null) {
                continue;
            }

            member.borrowBook();

            if (member instanceof FacultyMember) {
                member.borrowBook("Research");
            }

            member.displayInfo();
            System.out.println();
        }
    }

    public static void main(String[] args) {

        LibraryMember[] members = {
            new LibraryMember("LIB1"),
            new StudentMember("STU1", "ECE"),
            new FacultyMember("FAC1"),
            null
        };

        processNightlyAudit(members);
    }
}