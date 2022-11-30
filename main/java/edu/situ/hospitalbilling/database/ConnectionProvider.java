package edu.situ.hospitalbilling.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //a Returns a database connection
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hospital_management"; // URL of the database
        String username = "root";
        String password = "teja2002";

        return DriverManager.getConnection(url, username, password);
    }
}
