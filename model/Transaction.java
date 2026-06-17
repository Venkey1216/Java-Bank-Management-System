package model;

public class Transaction {

    private int accountNumber;
    private String type;
    private double amount;

    public Transaction(int accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}