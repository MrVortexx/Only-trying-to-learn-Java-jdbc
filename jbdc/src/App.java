import jdbc.CreateDb.CreateDb;
import jdbc.CreateTable.CreateTable;
import jdbc.OrderRepository.OrderRepository;

public class App {
    public static void main(String[] args) throws Exception {
        CreateDb.createDatabase("jdbc_studies");

        CreateTable.createTable("shipment", "id SERIAL, products VARCHAR(128) NOT NULL, status VARCHAR(10) NOT NULL, shipment_price NUMERIC(15,6) NOT NULL,  dispatch_time DATE, delivered_time DATE ");
        
        
    }
}
