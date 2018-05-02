package com.higgusp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConnectionDB {
    public Connection connection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/examplerestfulandangularjs?useSSL=false", "root", "123456");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
