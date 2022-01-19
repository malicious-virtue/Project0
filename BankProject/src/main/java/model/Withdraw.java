package model;

public class Withdraw extends Transactions {

    public Withdraw() {
        super();
    }

    public Withdraw(double balance, double amount) {
        super(balance, amount);
    }


    public double withdrawal(double amount) {
        return balance -= amount;
    }



}
