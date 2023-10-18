import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of Rs." + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of Rs." + amount + " successful.");
            return true;
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
            return false;
        }
    }
}

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(double initialBalance) {
        userAccount = new BankAccount(initialBalance);
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs." + userAccount.getBalance());
    }

    public void withdraw() {
        System.out.print("Enter withdrawal amount: Rs.");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }

    public void deposit() {
        System.out.print("Enter deposit amount: Rs.");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM.Have a good Day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        double initialBalance = 1000.0; // Initial balance for the user's account
        ATM atm = new ATM(initialBalance);
        atm.start();
    }
}
