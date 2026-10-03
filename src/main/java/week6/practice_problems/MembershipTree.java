package week6.practice_problems;

public class MembershipTree {

    static class LibraryMember {
        protected int booksBorrowed;
        protected int borrowLimit;

        public LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().isEmpty()
                    || memberId.length() < 4 || borrowLimit <= 0) {
                throw new IllegalArgumentException("Invalid member");
            }

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
    }

    static class StudentMember extends LibraryMember {
        private String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        public String getCourse() {
            return course;
        }

        @Override
        public String displayInfo() {
            return "Student Member | Course: " + course
                    + " | Books Borrowed: " + booksBorrowed;
        }
    }

    static class HonorsStudentMember extends StudentMember {
        private int bonusLimit;

        public HonorsStudentMember(
                String memberId,
                int borrowLimit,
                String course,
                int bonusLimit) {
            super(memberId, borrowLimit, course);
            this.bonusLimit = bonusLimit;
        }

        @Override
        public String displayInfo() {
            return "Honors Student Member | Course: " + getCourse()
                    + " | Bonus Limit: " + bonusLimit
                    + " | Books Borrowed: " + booksBorrowed;
        }
    }

    static class FacultyMember extends LibraryMember {
        private String department;

        public FacultyMember(
                String memberId,
                int borrowLimit,
                String department) {
            super(memberId, borrowLimit);
            this.department = department;
        }

        @Override
        public String displayInfo() {
            return "Faculty Member | Department: " + department
                    + " | Books Borrowed: " + booksBorrowed;
        }
    }

    static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }

        return "General Member";
    }

    static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;

        for (LibraryMember member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }

    public static void main(String[] args) {
        StudentMember student =
                new StudentMember("STU2", 3, "CSE");

        HonorsStudentMember honors =
                new HonorsStudentMember("STU3", 3, "ECE", 2);

        FacultyMember faculty =
                new FacultyMember("STU4", 5, "Physics");

        student.borrowBook();
        student.borrowBook();

        honors.borrowBook();

        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();

        System.out.println(
                new LibraryMember("STU1", 3).displayInfo()
        );
        System.out.println(student.displayInfo());
        System.out.println(honors.displayInfo());
        System.out.println(faculty.displayInfo());

        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));

        System.out.println(
                getTotalBooksBorrowed(
                        new LibraryMember[]{student, honors, faculty}
                )
        );
    }
}