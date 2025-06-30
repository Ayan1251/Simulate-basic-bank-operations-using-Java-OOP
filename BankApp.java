import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {

    static class Account {
        private String accountHolder;
        private double balance;
        private ArrayList<String> transactionHistory;

        public Account(String accountHolder) {
            this.accountHolder = accountHolder;
            this.balance = 0.0;
            this.transactionHistory = new ArrayList<>();
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactionHistory.add("Deposited: ₹" + amount);
                System.out.println("₹" + amount + " deposited successfully.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrawn: ₹" + amount);
                System.out.println("₹" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }

        public void showBalance() {
            System.out.println("Current Balance: ₹" + balance);
        }

        public void showTransactionHistory() {
            System.out.println("Transaction History:");
            if (transactionHistory.isEmpty()) {
                System.out.println("No transactions yet.");
            } else {
                for (String transaction : transactionHistory) {
                    System.out.println(transaction);
                }
            }
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("Ayan Mandal");

        while (true) {
            System.out.println("\n--- Bank Menu ---");

            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using our service!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

