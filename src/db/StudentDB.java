package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDB {
    public Connection getCon() throws SQLException, ClassNotFoundException{
        String url = "jdbc:postgresql://localhost:5432/postgres";
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, "postgres", "1234");
        } catch (Exception e) {
            System.out.println("Problems with either connection or class not found");
            return null;
        }
    }
}
