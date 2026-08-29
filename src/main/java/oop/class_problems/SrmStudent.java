package oop.class_problems;

public class SrmStudent {

    static String collegeName;
    static int academicYear;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = 2026;
        System.out.println("College info loaded");
    }

    String name;

    public SrmStudent(String name) {
        this.name = name;
    }

    public void printConfirmation() {
        System.out.println("Student record created: " + name);
    }

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        for (String name : names) {
            SrmStudent student = new SrmStudent(name);
            student.printConfirmation();
        }
    }
}