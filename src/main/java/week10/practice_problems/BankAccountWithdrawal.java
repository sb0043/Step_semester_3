package week10.practice_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    String id;
    int balance;

    BankAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    void withdraw(int amount) {
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String id, int balance) {
        super(id, balance);
    }

    @Override
    void withdraw(int amount) {
        if (balance - amount < 1000) {
            System.out.println(id + " rejected: minimum balance 1000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + balance);
        }
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(String id, int balance) {
        super(id, balance);
    }

    @Override
    void withdraw(int amount) {
        if (balance - amount < -5000) {
            System.out.println(id + " rejected: overdraft limit 5000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + balance);
        }
    }
}

public class BankAccountWithdrawal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equals("Savings")) {
                accounts.put(parts[1],
                    new SavingsAccount(parts[1],
                    Integer.parseInt(parts[2])));
            } else if (parts[0].equals("Current")) {
                accounts.put(parts[1],
                    new CurrentAccount(parts[1],
                    Integer.parseInt(parts[2])));
            } else if (parts[0].equals("WITHDRAW")) {
                String id = parts[1];
                int amount = Integer.parseInt(parts[2]);
                BankAccount account = accounts.get(id);

                if (account == null) {
                    System.out.println("Account not found");
                } else if (amount < 0) {
                    System.out.println(id + " rejected: invalid amount");
                } else {
                    account.withdraw(amount);
                }
            }
        }

        sc.close();
    }
}