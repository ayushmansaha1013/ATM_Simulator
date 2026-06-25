import java.util.Scanner;

public class ATMSimulator {

    // CORRECTION 1: Method name should be lowercase (camelCase)
    // CORRECTION 2: Remove String[] args parameter - not needed here
    public static void displayMenu() { // ✓ Fixed: lowercase, no args needed
        System.out.println("\n======Main Menu====== ");
        System.out.println("==========================");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("==========================");
    }

    // Helper methods for operations
    public static double checkBalance(double balance) {
        System.out.println("\n=============================");
        System.out.printf("Your Current Balance: Rs. %.2f\n", balance);
        System.out.println("=============================");
        return balance;
    }

    public static double deposit(double balance, Scanner sc) {
        System.out.print("\nEnter amount to deposit (multiple of 100): Rs. ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("ERROR: Amount must be greater than 0!");
            return balance;
        }

        if (amount % 100 != 0) {
            System.out.println("ERROR: Please enter amount in multiples of 100!");
            return balance;
        }

        balance += amount;
        System.out.printf("✓ Successfully Deposited: Rs. %.2f\n", amount);
        System.out.printf("New Balance: Rs. %.2f\n", balance);
        return balance;
    }

    public static double withdraw(double balance, Scanner sc) {
        System.out.print("\nEnter amount to withdraw (multiple of 100): Rs. ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("ERROR: Amount must be greater than 0!");
            return balance;
        }

        if (amount % 100 != 0) {
            System.out.println("ERROR: Please enter amount in multiples of 100!");
            return balance;
        }

        if (amount > balance) {
            System.out.println("ERROR: Insufficient Balance!");
            System.out.printf("Your Balance: Rs. %.2f\n", balance);
            return balance;
        }

        balance -= amount;
        System.out.printf("✓ Successfully Withdrawn: Rs. %.2f\n", amount);
        System.out.printf("Remaining Balance: Rs. %.2f\n", balance);
        return balance;
    }

    // CORRECTION 3: Proper main method with complete logic
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pin = 1234;
        double balance = 5000; // Starting balance

        // PIN Authentication
        System.out.println("=============================");
        System.out.println("Welcome to the ATM Simulator !!!");
        System.out.println("=============================");
        System.out.print("Please Enter your PIN: ");
        int number = sc.nextInt();

        if (number == pin) {
            System.out.println("✓ PIN Correct! Access Granted.");

            // CORRECTION 3: Add menu loop after PIN verification
            int choice = 0;
            while (choice != 4) {
                displayMenu(); // ✓ Fixed: Call with no arguments
                System.out.print("Enter your choice (1-4): ");
                choice = sc.nextInt();

                if (choice == 1) {
                    balance = checkBalance(balance);
                } else if (choice == 2) {
                    balance = deposit(balance, sc);
                } else if (choice == 3) {
                    balance = withdraw(balance, sc);
                } else if (choice == 4) {
                    System.out.println("\n=============================");
                    System.out.println("Thank you for using ATM!");
                    System.out.println("Please take your card.");
                    System.out.println("=============================");
                } else {
                    System.out.println("Invalid choice! Please enter 1-4.");
                }
            }
        } else {
            System.out.println("✗ PIN Incorrect! Access Denied.");
        }

        sc.close();
    }
}