import java.util.List;

import jdbc.CreateDb.CreateDb;
import jdbc.CreateTable.CreateTable;
import jdbc.Order.Order;
import jdbc.OrderRepository.OrderRepository;
import jdbc.OrderController.OrderController;
import jdbc.OrderCreateDTO.OrderCreateDTO;

public class App {
    public static void main(String[] args) throws Exception {
        CreateDb.createDatabase("jdbc_studies");

        CreateTable.createTable("shipment", "id SERIAL, uuid VARCHAR(64) NOT NULL, products VARCHAR(128) NOT NULL, status VARCHAR(20) NOT NULL, shipment_price NUMERIC(15,6) NOT NULL,  dispatch_time DATE, delivered_time DATE ");
        
        OrderRepository orderRepository = new OrderRepository();
        
        OrderController orderController = new OrderController(orderRepository);

        System.out.println("Creating example order...");

        Order result = orderController.create(new OrderCreateDTO("playstation", "4500.30"));

        if(result != null){
            System.out.println("Create Order works! ");
        }else{
            System.out.println("Create Order failed! ");

        }

        result =  orderController.create(new OrderCreateDTO("xbox", "300.30"));
        orderController.create(new OrderCreateDTO("iphone", "150.30"));
        orderController.create(new OrderCreateDTO("mac", "1500.30"));

        System.out.println("Consulting get controler with uuid: " + result.getUuid());

        result = orderController.getOne(result.getUuid());

        if(result != null){
            System.out.println("Consulting by uuid works! ");
        }else{
            System.out.println("Consulting by uuid failed! ");
        }

        List <Order> list = orderController.list();

        if(list.size() > 1){
            System.out.println("Listing all elements works!");
        }else{
            System.out.println("Listing all elements failed!");
        }
    }
}
