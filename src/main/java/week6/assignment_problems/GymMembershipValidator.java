package week6.assignment_problems;

class GymMember {
    private final String memberId;
    private final double monthlyFee;

    GymMember(String memberId, double monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("Invalid monthly fee");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    void displayInfo() {
        System.out.print(
            "Member: " + memberId +
            " | Fee: " + monthlyFee
        );
    }
}

class PremiumMember extends GymMember {

    PremiumMember(String memberId, double monthlyFee) {
        super(memberId, monthlyFee);
    }

    @Override
    void displayInfo() {
        System.out.print("Premium | ");
        super.displayInfo();
    }
}

public class GymMembershipValidator {

    static void signUpBatch(String[] ids) {

        int signedUp = 0;
        int rejected = 0;

        for (String id : ids) {
            try {
                new GymMember(id, 1000);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        System.out.println(
            "Signed Up: " + signedUp +
            " | Rejected: " + rejected
        );
    }

    public static void main(String[] args) {

        String[] ids = {
            "GYM1",
            "GYM2",
            "G",
            "",
            "GYM3"
        };

        signUpBatch(ids);
    }
}