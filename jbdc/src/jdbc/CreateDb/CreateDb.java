package jdbc.CreateDb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import jdbc.ConnectionDb.ConnectionDb;


public class CreateDb{
    
    public static void createDatabase(String name) throws SQLException{
        Connection connection = ConnectionDb.connect(null);
        Statement stmt = connection.createStatement();

        stmt.execute("DROP DATABASE IF EXISTS "+ name + ";" + "CREATE DATABASE "+ name + ";");

        System.out.println("Database "+ name + " started with sucess.");

        connection.close();
    }

}