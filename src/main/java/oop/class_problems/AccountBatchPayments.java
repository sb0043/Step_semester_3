package oop.class_problems;

class FeeAccount {
    String accountType;

    FeeAccount(String accountType) {
        this.accountType = accountType;
    }
}

class HostelFeeAccount extends FeeAccount {

    HostelFeeAccount() {
        super("Hostel");
    }
}

public class AccountBatchPayments {

    int hostelCount = 0;
    int feeAccountCount = 0;

    void processPayment(FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else {
            System.out.println("Paid in one go (day-scholar account)");
            feeAccountCount++;
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount("FeeAccount"),
            new FeeAccount("FeeAccount")
        };

        double amount = 60000;

        AccountBatchPayments batch = new AccountBatchPayments();

        for (FeeAccount account : accounts) {
            batch.processPayment(account, amount);
        }

        System.out.println("Hostel accounts processed: "
                + batch.hostelCount);
        System.out.println("Fee accounts processed: "
                + batch.feeAccountCount);
    }
}