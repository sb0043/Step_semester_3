package week8.assignment_problems;

interface MembershipPlan {
    int getMonths();
    double calculateFee();
}

class MonthlyPlan implements MembershipPlan {
    @Override
    public int getMonths() {
        return 1;
    }

    @Override
    public double calculateFee() {
        return 1000;
    }
}

class QuarterlyPlan implements MembershipPlan {
    @Override
    public int getMonths() {
        return 3;
    }

    @Override
    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }
}

class AnnualPlan implements MembershipPlan {
    @Override
    public int getMonths() {
        return 12;
    }

    @Override
    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }
}

class GymMember {
    private String name;

    GymMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Membership {
    private GymMember member;
    private MembershipPlan plan;
    private String status;

    Membership(
        GymMember member,
        MembershipPlan plan
    ) {
        this.member = member;
        this.plan = plan;
        this.status = "Active";
    }

    public void checkIn() {
        if ("Active".equals(status)) {
            System.out.println(
                member.getName()
                + " checked in successfully."
            );
        } else {
            System.out.println(
                "Check-in denied: "
                + member.getName()
                + "'s membership is "
                + status
                + "."
            );
        }
    }

    public void freeze() {
        if ("Active".equals(status)) {
            status = "Frozen";

            System.out.println(
                member.getName()
                + "'s membership frozen."
            );

            System.out.println("Status: Frozen.");
        } else {
            System.out.println(
                "Cannot freeze an "
                + status
                + " membership."
            );
        }
    }

    public void unfreeze() {
        if ("Frozen".equals(status)) {
            status = "Active";

            System.out.println(
                member.getName()
                + "'s membership unfrozen."
            );
        } else {
            System.out.println(
                "Cannot unfreeze an "
                + status
                + " membership."
            );
        }
    }

    public void expire() {
        if (!"Expired".equals(status)) {
            status = "Expired";

            System.out.println(
                member.getName()
                + "'s membership expired."
            );

            System.out.println("Status: Expired.");
        }
    }
}

class MembershipDesk {
    public Membership buy(
        GymMember member,
        MembershipPlan plan
    ) {
        Membership membership =
            new Membership(member, plan);

        System.out.println(
            plan.getClass().getSimpleName()
            + " membership created for "
            + member.getName()
            + "."
        );

        System.out.printf(
            "Fee: ₹%.2f.%n",
            plan.calculateFee()
        );

        System.out.println("Status: Active.");

        return membership;
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        MembershipDesk desk =
            new MembershipDesk();

        GymMember asha =
            new GymMember("Asha");

        GymMember ravi =
            new GymMember("Ravi");

        Membership ashaMembership =
            desk.buy(asha, new QuarterlyPlan());

        Membership raviMembership =
            desk.buy(ravi, new MonthlyPlan());

        ashaMembership.checkIn();

        ashaMembership.freeze();

        ashaMembership.checkIn();

        raviMembership.expire();

        raviMembership.freeze();
    }
}