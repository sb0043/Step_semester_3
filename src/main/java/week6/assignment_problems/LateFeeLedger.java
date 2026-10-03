package week6.assignment_problems;

class GymFeeMember {
    private final double[] feeHistory = new double[20];
    private int feeCount = 0;

    void chargeLateFee(int amount) {

        if (amount <= 0) {
            return;
        }

        feeHistory[feeCount++] = amount;
    }

    double[] getFeeHistory() {

        double[] copy = new double[feeCount];

        for (int i = 0; i < feeCount; i++) {
            copy[i] = feeHistory[i];
        }

        return copy;
    }
}

class PremiumFeeMember extends GymFeeMember {

    @Override
    void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class LateFeeLedger {

    public static void main(String[] args) {

        GymFeeMember regular = new GymFeeMember();
        PremiumFeeMember premium = new PremiumFeeMember();

        regular.chargeLateFee(100);
        premium.chargeLateFee(100);

        double[] regularHistory = regular.getFeeHistory();
        double[] premiumHistory = premium.getFeeHistory();

        System.out.println(
            "Regular Fee: " + regularHistory[0]
        );

        System.out.println(
            "Premium Fee: " + premiumHistory[0]
        );
    }
}