package jdbc.OrderRepository;

import jdbc.Order.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jdbc.BaseRepository.BaseRepository;
import jdbc.OrderCreateDTO.OrderCreateDTO;
import jdbc.ConnectionDb.ConnectionDb;


public class OrderRepository implements BaseRepository<Order, OrderCreateDTO>{
    
    @Override
    public Order create(OrderCreateDTO order){
        Connection connection = ConnectionDb.connect("jdbc_studies");

        String query = "INSERT INTO shipment (uuid, products, status, shipment_price) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            UUID uuid = UUID.randomUUID();
            stmt.setString(1, uuid.toString());
            stmt.setString(2, order.getProducts());
            stmt.setString(3, "ETIQUETA_EMITIDA");
            stmt.setDouble(4, order.getShipmentPrice().doubleValue());
            stmt.execute();


            Order o = this.findByUuid(uuid.toString());

            connection.close();
            return o;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

       
    }

    @Override
    public List <Order> list() {
        try{
            Connection connection = ConnectionDb.connect("jdbc_studies");
            String query =  "SELECT * FROM shipment";
            Statement stmt = connection.createStatement();

            List <Order> list = new ArrayList<Order>();

            ResultSet response = stmt.executeQuery(query);
            while(response.next()){
                Order o = new Order();
                o.setId(response.getInt("id"));
                o.setProducts(response.getString("products"));
                o.setUuid(response.getString("uuid"));
                o.setStatus(response.getString("status"));
                o.setShipmentPrice(response.getBigDecimal("shipment_price"));
                o.setDeliveredTime(response.getDate("delivered_time"));
                o.setDispatchTime(response.getDate("dispatch_time"));

                list.add(o);
            }
            connection.close();

            return list;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order findById(int id) {
        try{
            Connection connection = ConnectionDb.connect("jdbc_studies");
            String query =  "SELECT * FROM shipment where id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id );

            ResultSet response = stmt.executeQuery();
            
            if(!response.next()){
                return null;
            }
            Order o = new Order();
            o.setId(response.getInt("id"));
            o.setProducts(response.getString("products"));
            o.setUuid(response.getString("uuid"));
            o.setStatus(response.getString("status"));
            o.setShipmentPrice(response.getBigDecimal("shipment_price"));
            o.setDeliveredTime(response.getDate("delivered_time"));
            o.setDispatchTime(response.getDate("dispatch_time"));

            return o;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
       
    }
    
    @Override
    public Order findByUuid(String uuid) {
        try{
            Connection connection = ConnectionDb.connect("jdbc_studies");
            String query =  "SELECT * FROM shipment where uuid = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, uuid );

            ResultSet response = stmt.executeQuery();
            
            if(!response.next()){
                return null;
            }
            Order o = new Order();
            o.setId(response.getInt("id"));
            o.setProducts(response.getString("products"));
            o.setUuid(response.getString("uuid"));
            o.setStatus(response.getString("status"));
            o.setShipmentPrice(response.getBigDecimal("shipment_price"));
            o.setDeliveredTime(response.getDate("delivered_time"));
            o.setDispatchTime(response.getDate("dispatch_time"));

            return o;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
