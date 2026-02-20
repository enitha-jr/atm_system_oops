package services;
import models.Account;

public interface ATMOperations {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount);
    double checkBalance(Account account);
    double checkBalance(Account account, boolean isCurrentAccount);
}