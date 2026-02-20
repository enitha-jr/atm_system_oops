package services;
import models.Account;

public class ATMService implements ATMOperations {

    @Override
    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    @Override
    public void withdraw(Account account, double amount) {
        try {
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public double checkBalance(Account account) {
        return account.getBalance();
    }

    @Override
    public double checkBalance(Account account, boolean isCurrentAccount) {
        return account.getBalance(isCurrentAccount);
    }
    
}