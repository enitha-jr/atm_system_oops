package models;

public class Account {
    private int accountId;
    private double balance;

    public Account(int accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public double getBalance( boolean isCurrentAccount) {
        if (isCurrentAccount) {
            return balance + 500; 
        }
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new Exception("Insufficient balance");
        }
    }
}