package service;

import database.DBConnection;
import model.Account;

import java.sql.*;
import java.util.*;

public class BankService {

    Connection conn = DBConnection.getConnection();

    public void createAccount(Account acc) {

        try {

            String query = "INSERT INTO accounts VALUES (?, ?, ?)";
            if(conn==null){
                System.out.println("null object");
            }
            else System.out.println(conn);
            
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, acc.getAccountNumber());
            ps.setString(2, acc.getAccountHolderName());
            ps.setDouble(3, acc.getBalance());

            ps.executeUpdate();

            System.out.println("Account created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deposit(int accNo, double amount) {

        try {

            String query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setDouble(1, amount);
            ps.setInt(2, accNo);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Amount deposited successfully.");
            else
                System.out.println("Account not found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw(int accNo, double amount) {

        try {

            String check = "SELECT balance FROM accounts WHERE account_number=?";
            PreparedStatement ps1 = conn.prepareStatement(check);
            ps1.setInt(1, accNo);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("balance");

                if (balance >= amount) {

                    String query = "UPDATE accounts SET balance = balance - ? WHERE account_number=?";
                    PreparedStatement ps2 = conn.prepareStatement(query);

                    ps2.setDouble(1, amount);
                    ps2.setInt(2, accNo);

                    ps2.executeUpdate();

                    System.out.println("Withdrawal successful.");

                } else {
                    System.out.println("Insufficient balance.");
                }

            } else {
                System.out.println("Account not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBalance(int accNo) {

        try {

            String query = "SELECT * FROM accounts WHERE account_number=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, accNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Account Number : " + rs.getInt("account_number"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Balance : " + rs.getDouble("balance"));

            } else {
                System.out.println("Account not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayAccounts() {

        try {

            String query = "SELECT * FROM accounts";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println("----------------------");
                System.out.println("Account Number : " + rs.getInt("account_number"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Balance : " + rs.getDouble("balance"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int accNo) {

        try {

            String query = "DELETE FROM accounts WHERE account_number=?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, accNo);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Account deleted.");
            else
                System.out.println("Account not found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

