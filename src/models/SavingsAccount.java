package models;
public class SavingsAccount extends Account {

    public SavingsAccount(int accountId,double balance) {
        super(accountId, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            throw new RuntimeException("Insufficient balance in Savings Account");
        }
        deposit(-amount);
    }
}