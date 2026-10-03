package week8.assignment_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface NotificationChannel {
    void send(Student student, String message);
}

class EmailChannel implements NotificationChannel {
    @Override
    public void send(Student student, String message) {
        System.out.println(
            "[Email → "
            + student.getName()
            + "] "
            + message
        );
    }
}

class SmsChannel implements NotificationChannel {
    @Override
    public void send(Student student, String message) {
        System.out.println(
            "[SMS → "
            + student.getName()
            + "] "
            + message
        );
    }
}

class AppChannel implements NotificationChannel {
    @Override
    public void send(Student student, String message) {
        System.out.println(
            "[App → "
            + student.getName()
            + "] "
            + message
        );
    }
}

class Student {
    private String name;
    private String department;
    private List<NotificationChannel> channels =
        new ArrayList<>();

    Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    public List<NotificationChannel> getChannels() {
        return channels;
    }
}

class Notice {
    private String title;
    private Set<String> departments;

    Notice(String title, Set<String> departments) {
        this.title = title;
        this.departments = departments;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getDepartments() {
        return departments;
    }
}

class NoticeBoard {
    private List<Student> students =
        new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void postNotice(Notice notice) {
        if (notice.getTitle() == null ||
            notice.getTitle().trim().isEmpty()) {

            System.out.println(
                "Cannot post notice: Title is required."
            );
            return;
        }

        if (notice.getDepartments() == null ||
            notice.getDepartments().isEmpty()) {

            System.out.println(
                "Cannot post notice: At least one target department is required."
            );
            return;
        }

        System.out.println(
            "Notice '"
            + notice.getTitle()
            + "' posted to "
            + String.join(", ", notice.getDepartments())
            + "."
        );

        for (Student student : students) {
            if (notice.getDepartments()
                    .contains(student.getDepartment())) {

                for (NotificationChannel channel :
                        student.getChannels()) {

                    channel.send(
                        student,
                        notice.getTitle()
                    );
                }
            }
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student asha =
            new Student("Asha", "CSE");

        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        Student ravi =
            new Student("Ravi", "ECE");

        ravi.addChannel(new SmsChannel());

        board.addStudent(asha);
        board.addStudent(ravi);

        Set<String> cse =
            new HashSet<>();

        cse.add("CSE");

        board.postNotice(
            new Notice(
                "Lab Closed Tomorrow",
                cse
            )
        );

        Set<String> cseEce =
            new HashSet<>();

        cseEce.add("CSE");
        cseEce.add("ECE");

        board.postNotice(
            new Notice(
                "Fee Deadline Extended",
                cseEce
            )
        );

        board.postNotice(
            new Notice(
                "Sports Day",
                new HashSet<>()
            )
        );
    }
}