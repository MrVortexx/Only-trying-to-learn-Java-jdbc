package jbdc.Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    
    public static void main (String[] args) throws SQLException{
        final String url = "jdbc:postgresql://localhost:5432/";
        final String user = "jbdc";
        final String password = "jbdc";

        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection  connection = DriverManager.getConnection(url, user, password);

        System.out.println("Connected with sucess on 5432 using psql.");

        connection.close();
    }
}
