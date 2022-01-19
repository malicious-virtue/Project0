package model;

public class Deposit extends Transactions{


    public Deposit() {
        super();
    }

    public Deposit(double balance, double amount) {
        super(balance, amount);
    }

    public double calculateDeposit(double amount){
        return balance += amount;
    }

}
