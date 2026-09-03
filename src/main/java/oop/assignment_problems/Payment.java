package oop.assignment_problems;

class CashPayment {
    double amount;

    CashPayment(double amount) {
        this.amount = amount;
    }
}

class UpiPayment {
    double amount;

    UpiPayment(double amount) {
        this.amount = amount;
    }
}

public class Payment {

    void processPayment(Object payment) {

        if (payment instanceof CashPayment) {
            System.out.println("Cash payment processed");

        } else if (payment instanceof UpiPayment) {
            System.out.println("UPI payment processed");
        }
    }

    public static void main(String[] args) {

        Object[] payments = {
            new CashPayment(500),
            new UpiPayment(1000),
            new CashPayment(750),
            new UpiPayment(1200)
        };

        Payment payment = new Payment();

        for (int i = 0; i < payments.length; i++) {
            payment.processPayment(payments[i]);
        }
    }
}