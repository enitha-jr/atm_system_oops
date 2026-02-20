package models;
public class CurrentAccount extends Account {

    private double overdraftLimit = 500;

    public CurrentAccount(int accountId, double balance) {
        super(accountId, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance() + overdraftLimit) {
            throw new RuntimeException("Overdraft limit exceeded");
        }
        deposit(-amount);
    }
}