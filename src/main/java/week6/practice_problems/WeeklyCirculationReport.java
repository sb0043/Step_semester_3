package week6.practice_problems;

public class WeeklyCirculationReport {

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

        public String displayInfo() {
            return "General | Books: " + booksBorrowed;
        }
    }

    static class StudentMember extends LibraryMember {
        private String course;

        public StudentMember(
                String memberId,
                int borrowLimit,
                String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        public String getCourse() {
            return course;
        }

        @Override
        public String displayInfo() {
            return "Student | Course: " + course
                    + " | Books: " + booksBorrowed;
        }
    }

    static String batchPrint(LibraryMember[] members) {
        StringBuilder result = new StringBuilder();

        for (LibraryMember member : members) {
            result.append(member.displayInfo());

            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;

                result.append(" [Course via downcast: ")
                        .append(student.getCourse())
                        .append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
                new LibraryMember("LIB5", 3),
                new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}