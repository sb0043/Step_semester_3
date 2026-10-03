package week6.assignment_problems;

class AttendanceMember {
    protected String memberId;
    protected int attendance;

    AttendanceMember(String memberId) {
        this.memberId = memberId;
        this.attendance = 0;
    }

    void attend() {
        attendance++;
    }

    void displayInfo() {
        System.out.print(
            "Member: " + memberId +
            " | Attendance: " + attendance
        );
    }
}

class AttendancePremiumMember extends AttendanceMember {
    private final String trainerName;

    AttendancePremiumMember(String memberId, String trainerName) {
        super(memberId);
        this.trainerName = trainerName;
    }

    @Override
    void displayInfo() {
        System.out.print(
            "Premium | Member: " + memberId +
            " | Attendance: " + attendance +
            " | Trainer: " + trainerName
        );
    }

    String getTrainerName() {
        return trainerName;
    }
}

public class MonthlyAttendanceAnnouncer {

    static void batchPrint(AttendanceMember[] members) {

        StringBuilder output = new StringBuilder();

        for (AttendanceMember member : members) {

            if (member == null) {
                continue;
            }

            member.displayInfo();

            if (member instanceof AttendancePremiumMember) {
                AttendancePremiumMember premium =
                    (AttendancePremiumMember) member;

                output.append(
                    " | Trainer: "
                ).append(
                    premium.getTrainerName()
                );
            }

            output.append("\n");
        }

        System.out.print(output);
    }

    public static void main(String[] args) {

        AttendanceMember[] members = {
            new AttendanceMember("GYM1"),
            new AttendancePremiumMember("GYM2", "Arun"),
            new AttendanceMember("GYM3")
        };

        for (AttendanceMember member : members) {
            member.attend();
        }

        batchPrint(members);
    }
}