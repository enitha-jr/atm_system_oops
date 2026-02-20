package models;

public class CardAuth {
    
    private int accountId;
    private String accountHolderName;
    private int pin;

    public CardAuth(int accountId, int pin, String accountHolderName) {
        this.accountId = accountId;
        this.pin = pin;
        this.accountHolderName = accountHolderName;
    }

    public int getAccountId() {
        return accountId;
    }

    public boolean verifyPin(int inputPin) {
        return this.pin == inputPin;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}