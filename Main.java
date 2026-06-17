import model.Account;
import service.BankService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while (true) {

            System.out.println("\n====== Banking System ======");
            System.out.println("1 Create Account");
            System.out.println("2 Deposit");
            System.out.println("3 Withdraw");
            System.out.println("4 Check Balance");
            System.out.println("5 View All Accounts");
            System.out.println("6 Delete Account");
            System.out.println("7 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Enter Account Number");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name");
                    String name = sc.nextLine();

                    System.out.println("Enter Initial Balance");
                    double balance = sc.nextDouble();

                    Account acc = new Account(accNo, name, balance);

                    bank.createAccount(acc);

                    break;

                case 2:

                    System.out.println("Enter Account Number");
                    int a = sc.nextInt();

                    System.out.println("Enter Amount");
                    double amt = sc.nextDouble();

                    bank.deposit(a, amt);

                    break;

                case 3:

                    System.out.println("Enter Account Number");
                    int w = sc.nextInt();

                    System.out.println("Enter Amount");
                    double wa = sc.nextDouble();

                    bank.withdraw(w, wa);

                    break;

                case 4:

                    System.out.println("Enter Account Number");
                    int c = sc.nextInt();

                    bank.checkBalance(c);

                    break;

                case 5:

                    bank.displayAccounts();

                    break;

                case 6:

                    System.out.println("Enter Account Number");
                    int d = sc.nextInt();

                    bank.deleteAccount(d);

                    break;

                case 7:

                    System.out.println("Thank you for using the banking system.");
                    System.exit(0);
            }
        }
    }
}

// import database.DBConnection;
// import java.sql.Connection;

// public class Main {

//     public static void main(String[] args) {

//         Connection conn = DBConnection.getConnection();

//         if(conn != null)
//             System.out.println("Connection working properly");
//         else
//             System.out.println("Connection failed");

//     }
// }