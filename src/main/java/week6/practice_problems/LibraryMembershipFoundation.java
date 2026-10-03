package week6.practice_problems;

public class LibraryMembershipFoundation {

    static class LibraryMember {
        private String memberId;
        private int borrowLimit;
        private int booksBorrowed;

        public LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().isEmpty()
                    || memberId.length() < 4) {
                throw new IllegalArgumentException("Invalid member ID");
            }

            if (borrowLimit <= 0) {
                throw new IllegalArgumentException("Borrow limit must be positive");
            }

            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
        }

        public void borrowBook() {
            if (booksBorrowed < borrowLimit) {
                booksBorrowed++;
            }
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public String displayInfo() {
            return "General Member | Books Borrowed: " + booksBorrowed;
        }

        public static String enrollBatch(String[] memberIds, int borrowLimit) {
            int enrolled = 0;
            int rejected = 0;

            for (String memberId : memberIds) {
                try {
                    new LibraryMember(memberId, borrowLimit);
                    enrolled++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }

            return "Enrolled: " + enrolled + " | Rejected: " + rejected;
        }
    }

    static class StudentMember extends LibraryMember {
        private String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }
    }

    public static void main(String[] args) {
        StudentMember student =
                new StudentMember("STU10", 3, "CSE");

        student.borrowBook();
        student.borrowBook();

        System.out.println(student.getBooksBorrowed());

        System.out.println(
                LibraryMember.enrollBatch(
                        new String[]{"STU1", "LB1", "STU2", "", "STU3"},
                        3
                )
        );
    }
}