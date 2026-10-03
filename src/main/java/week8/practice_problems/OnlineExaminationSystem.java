package week8.practice_problems;

import java.util.LinkedHashMap;
import java.util.Map;

class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

abstract class Question {
    private String text;
    private int points;

    Question(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }

    public abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    private String correctAnswer;

    MultipleChoiceQuestion(String text, int points, String correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    TrueFalseQuestion(String text, int points, boolean correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return Boolean.parseBoolean(answer) == correctAnswer;
    }
}

class Examination {
    private String name;
    private Map<Integer, Question> questions = new LinkedHashMap<>();

    Examination(String name) {
        this.name = name;
    }

    public void addQuestion(int number, Question question) {
        questions.put(number, question);
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }
}

class Attempt {
    private Student student;
    private Examination examination;
    private Map<Integer, String> answers = new LinkedHashMap<>();
    private boolean submitted;

    Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
        this.submitted = false;
    }

    public void recordAnswer(int questionNumber, String answer) {
        if (submitted) {
            System.out.println(
                "Cannot change answers for a submitted examination."
            );
            return;
        }

        answers.put(questionNumber, answer);
        System.out.println("Answer recorded for Question " + questionNumber + ".");
    }

    public void submit() {
        if (!submitted) {
            submitted = true;

            System.out.println(
                examination.getName()
                + " submitted by "
                + student.getName()
                + "."
            );

            calculateResult();
        }
    }

    private void calculateResult() {
        int total = 0;
        int maximum = 0;

        for (Map.Entry<Integer, Question> entry :
                examination.getQuestions().entrySet()) {

            int number = entry.getKey();
            Question question = entry.getValue();
            maximum += question.getPoints();

            String answer = answers.get(number);

            if (answer != null && question.evaluate(answer)) {
                total += question.getPoints();

                System.out.println(
                    "Result: Question "
                    + number
                    + ": Correct ("
                    + question.getPoints()
                    + " points)"
                );
            } else {
                System.out.println(
                    "Result: Question "
                    + number
                    + ": Incorrect (0 points)"
                );
            }
        }

        System.out.println("Total score: " + total + "/" + maximum);
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Student student = new Student("Student 1");

        Examination exam = new Examination("Exam A");

        exam.addQuestion(
            1,
            new MultipleChoiceQuestion(
                "Which option is correct?",
                5,
                "C"
            )
        );

        exam.addQuestion(
            2,
            new TrueFalseQuestion(
                "Java is an object-oriented language.",
                5,
                false
            )
        );

        System.out.println(
            "Exam A started by " + student.getName() + "."
        );

        Attempt attempt = new Attempt(student, exam);

        attempt.recordAnswer(1, "C");
        attempt.recordAnswer(2, "True");

        attempt.submit();

        attempt.recordAnswer(1, "A");
    }
}