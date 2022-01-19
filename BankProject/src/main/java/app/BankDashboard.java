package app;



import java.util.Scanner;

public class BankDashboard {

    public static void main(String[] args) {
        System.out.println("Welcome to L & K Bank. \n What would you like to do today? ");
        Scanner scan = new Scanner(System.in);

        System.out.println("1. Create new account");
        System.out.println("2. Login to existing account");
       String firstChoice =  scan.nextLine();
    }
}
