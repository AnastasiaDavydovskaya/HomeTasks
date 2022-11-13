package by.tms.lesson34.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConfig {

    public static Connection createConnectionWithDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return  DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
    }
}
