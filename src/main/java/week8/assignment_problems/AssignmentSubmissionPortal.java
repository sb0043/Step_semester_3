package week8.assignment_problems;

import java.time.LocalDate;

abstract class CollegeAssignment {
    private String title;
    private int maxMarks;
    private LocalDate dueDate;

    CollegeAssignment(
        String title,
        int maxMarks,
        LocalDate dueDate
    ) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public abstract double applyLatePenalty(
        double awardedMarks,
        long lateDays
    );
}

class CodingAssignment extends CollegeAssignment {
    CodingAssignment(
        String title,
        int maxMarks,
        LocalDate dueDate
    ) {
        super(title, maxMarks, dueDate);
    }

    @Override
    public double applyLatePenalty(
        double awardedMarks,
        long lateDays
    ) {
        double penalty = lateDays * 0.10;
        return Math.max(0, awardedMarks * (1 - penalty));
    }
}

class WrittenAssignment extends CollegeAssignment {
    WrittenAssignment(
        String title,
        int maxMarks,
        LocalDate dueDate
    ) {
        super(title, maxMarks, dueDate);
    }

    @Override
    public double applyLatePenalty(
        double awardedMarks,
        long lateDays
    ) {
        double penalty = lateDays * 0.20;
        return Math.max(0, awardedMarks * (1 - penalty));
    }
}

class SubmissionStudent {
    private String name;

    SubmissionStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class AssignmentSubmission {
    private SubmissionStudent student;
    private CollegeAssignment assignment;
    private LocalDate submissionDate;
    private String status;
    private double finalMarks;

    AssignmentSubmission(
        SubmissionStudent student,
        CollegeAssignment assignment,
        LocalDate submissionDate
    ) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.status = "Submitted";
    }

    public void grade(double awardedMarks) {
        if (!"Submitted".equals(status)) {
            System.out.println(
                "Cannot grade submission in status " + status + "."
            );
            return;
        }

        long lateDays =
            Math.max(
                0,
                assignment.getDueDate()
                    .until(submissionDate)
                    .getDays()
            );

        finalMarks =
            assignment.applyLatePenalty(
                awardedMarks,
                lateDays
            );

        status = "Graded";

        System.out.printf(
            "%s graded: %.0f/%d. Status: Graded.%n",
            student.getName(),
            finalMarks,
            assignment.getMaxMarks()
        );
    }

    public void resubmit(LocalDate newDate) {
        if ("Graded".equals(status)) {
            System.out.println(
                "Cannot resubmit: '"
                + assignment.getTitle()
                + "' has already been graded."
            );
        } else {
            submissionDate = newDate;
        }
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        CollegeAssignment coding =
            new CodingAssignment(
                "Linked List Lab",
                50,
                LocalDate.of(2026, 3, 10)
            );

        CollegeAssignment written =
            new WrittenAssignment(
                "Design Essay",
                50,
                LocalDate.of(2026, 3, 12)
            );

        SubmissionStudent asha =
            new SubmissionStudent("Asha");

        SubmissionStudent ravi =
            new SubmissionStudent("Ravi");

        AssignmentSubmission ashaSubmission =
            new AssignmentSubmission(
                asha,
                coding,
                LocalDate.of(2026, 3, 10)
            );

        System.out.println(
            "Asha's submission for '"
            + coding.getTitle()
            + "' received (on time). Status: Submitted."
        );

        AssignmentSubmission raviSubmission =
            new AssignmentSubmission(
                ravi,
                written,
                LocalDate.of(2026, 3, 14)
            );

        System.out.println(
            "Ravi's submission for '"
            + written.getTitle()
            + "' received (2 days late). Status: Submitted."
        );

        ashaSubmission.grade(45);

        raviSubmission.grade(40);

        ashaSubmission.resubmit(
            LocalDate.of(2026, 3, 11)
        );
    }
}