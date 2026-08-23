package oop.class_problems;

public class Course {

    String code;
    String title;
    int credits;
    int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {

        Course course1 =
                new Course("CS101", "Java Programming", 3, 1);

        Course course2 =
                new Course("CS102", "Database Systems", 4);

        System.out.println("Total credits for " + course1.code + ": "
                + course1.totalCredits());

        System.out.println("Total credits for " + course2.code + ": "
                + course2.totalCredits());
    }
}