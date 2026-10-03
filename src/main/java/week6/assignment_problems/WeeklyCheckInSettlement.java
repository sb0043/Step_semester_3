package week6.assignment_problems;

class CheckInMember {
    private static int nextMembershipNumber = 2000;

    private final int membershipNumber;
    private final String memberId;
    private double feePaid;

    CheckInMember(String memberId) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.membershipNumber = ++nextMembershipNumber;
        this.feePaid = 0;
    }

    void payFee(double amount) {
        if (amount > 0) {
            feePaid += amount;
        }
    }

    void payFee(double amount, String method) {
        payFee(amount);
    }

    String getReferralCode() {
        int numberPart = membershipNumber % 100;

        char letter =
            Character.toUpperCase(memberId.charAt(0));

        return "G" + String.format("%02d", numberPart) + letter;
    }

    int getMembershipNumber() {
        return membershipNumber;
    }

    double getFeePaid() {
        return feePaid;
    }
}

class CheckInGroupClassMember extends CheckInMember {

    private final String className;

    CheckInGroupClassMember(
        String memberId,
        String className
    ) {
        super(memberId);
        this.className = className;
    }

    String getClassName() {
        return className;
    }
}

public class WeeklyCheckInSettlement {

    static void processWeeklyCheckIn(
        CheckInMember[] members
    ) {

        for (CheckInMember member : members) {

            if (member == null) {
                continue;
            }

            member.payFee(500);

            if (member instanceof CheckInGroupClassMember) {
                CheckInGroupClassMember groupMember =
                    (CheckInGroupClassMember) member;

                member.payFee(200, groupMember.getClassName());
            }

            System.out.println(
                "Membership: " +
                member.getMembershipNumber() +
                " | Referral: " +
                member.getReferralCode() +
                " | Paid: " +
                member.getFeePaid()
            );
        }
    }

    public static void main(String[] args) {

        CheckInMember[] members = {
            new CheckInMember("GYM1"),
            new CheckInGroupClassMember("GRP1", "Yoga"),
            null
        };

        processWeeklyCheckIn(members);
    }
}