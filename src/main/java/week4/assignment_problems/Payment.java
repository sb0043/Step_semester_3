package week4.assignment_problems;

class CardPayment extends Payment {
    public double payWithProcessingFee(double amount) {
        double fee = amount * 0.02;
        return amount + fee;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Card payment processed");
    }
}

public class Payment {
    public void pay(double amount) {
        System.out.println("Payment processed");
    }

    public static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            double total = cardPayment.payWithProcessingFee(amount);
            System.out.println("Card payment: Rs " + total);
            return total;
        } else {
            payment.pay(amount);
            System.out.println("Regular payment: Rs " + amount);
            return amount;
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {10000, 20000, 15000, 25000};
        double grandTotal = 0;

        for (int i = 0; i < payments.length; i++) {
            grandTotal += processTransaction(payments[i], amounts[i]);
        }

        System.out.println("Grand Total Collected: Rs " + grandTotal);
    }
}