package main;
import java.util.Scanner;

import models.Account;
import models.CardAuth;
import models.CurrentAccount;
import models.SavingsAccount;
import services.ATMOperations;
import services.ATMService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardAuth cardAuth = new CardAuth(12345, 1111, "Enith");
        ATMOperations atm = new ATMService();

        System.out.print("Enter your account ID: ");
        int accountId = scanner.nextInt();
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); 

        if (cardAuth.getAccountId() == accountId && cardAuth.verifyPin(pin)) {
            System.out.println("\n*******************");
            System.out.println("Login Successful");
            System.out.println("Welcome, " + cardAuth.getAccountHolderName());

            System.out.print("Choose account type (Current / Savings): ");
            String str = scanner.nextLine();

            Account account;

            if (str.charAt(0) == 'C' || str.charAt(0) == 'c') {
                account = new CurrentAccount(12345, 1000.0);
                System.out.println("Current Account selected.");
            } else if (str.charAt(0) == 'S' || str.charAt(0) == 's') {
                account = new SavingsAccount(12345, 1000.0);
                System.out.println("Savings Account selected.");
            } else {
                System.out.println("Invalid account type. Defaulting to Current Account.");
                account = new CurrentAccount(12345, 1000.0);
            }

            int option;
            do {
                System.out.println("\n*******************");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(account, depositAmount);
                        System.out.println("Deposit successful!");
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        try {
                            atm.withdraw(account, withdrawAmount);
                            System.out.println("Withdrawal successful!");
                        } catch (RuntimeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        if (account instanceof CurrentAccount) {
                            System.out.println("Current Account Balance: " + atm.checkBalance(account, true));
                        } else {
                            System.out.println("Savings Account Balance: " + atm.checkBalance(account));
                        }
                        break;

                    case 4:
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }

            } while (option != 4);

        } else {
            System.out.println("Invalid account ID or PIN. Access denied.");
        }

        scanner.close();
    }
}