package model;

public  class Transactions {

    protected double balance;
    protected double amount;
    private double deposit;
    private double withdrawal;

    public Transactions() {
    }

    public Transactions(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }

    public Transactions(double amount, double deposit, double withdrawal) {
        this.amount = amount;
        this.deposit = deposit;
        this.withdrawal = withdrawal;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
