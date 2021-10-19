package jdbc.CreateTable;

import jdbc.ConnectionDb.ConnectionDb;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createTable(String tableName, String fields) throws SQLException{
        Connection c  = ConnectionDb.connect("jdbc_studies");
        Statement stmt = c.createStatement();

        String query = "CREATE TABLE IF NOT EXISTS "+ tableName + " ( " + fields + " );" ;

        System.out.println("Creating table " + tableName + "....");

        stmt.execute(query);

        c.close();
    }
}
