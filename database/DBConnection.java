package database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/bankdb";
            String user = "root";
            String password = "root";   // change if your mysql password is different

            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}