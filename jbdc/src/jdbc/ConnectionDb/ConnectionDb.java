package jdbc.ConnectionDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    
    public  static Connection connect(String dbName){
        String database = "";
        if(dbName != null){
            database = dbName;
        }
        final String url = "jdbc:postgresql://localhost:5432/" + database;
        final String user = "jdbc";
        final String password = "jdbc";

        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
    
            System.out.println("Connected with sucess on 5432 using psql.");
    
            return DriverManager.getConnection(url, user, password);
        }catch(SQLException err){
            throw new RuntimeException(err);
        }
       
       
    }


}