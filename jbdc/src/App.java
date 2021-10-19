import jdbc.CreateDb.CreateDb;
import jdbc.CreateTable.CreateTable;


public class App {
    public static void main(String[] args) throws Exception {
        CreateDb.createDatabase("jdbc_studies");

        CreateTable.createTable("shipment", "products VARCHAR(128) NOT NULL, status VARCHAR(10) NOT NULL, products_value NUMERIC(15,6) NOT NULL, shipment_price NUMERIC(15,6) NOT NULL, order_time DATE NOT NULL, dispatch_time DATE, delivered_time DATE ");
    }
}
