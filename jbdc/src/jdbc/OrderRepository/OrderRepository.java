package jdbc.OrderRepository;

import jdbc.Order.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import jdbc.BaseRepository.BaseRepository;
import jdbc.OrderCreateDTO.OrderCreateDTO;
import jdbc.ConnectionDb.ConnectionDb;


public class OrderRepository implements BaseRepository<Order, OrderCreateDTO>{
    
    @Override
    public Order create(OrderCreateDTO order){
        Connection connection = ConnectionDb.connect("jbdc_studies");

        String query = "INSERT INTO shipment VALUES (uuid, products, status, shipment_price) VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            UUID uuid = UUID.randomUUID();
            stmt.setString(1, uuid.toString());
            stmt.setString(2, order.getProducts());
            stmt.setString(3, "ETIQUETA_EMITIDA");
            stmt.setDouble(4, order.getShipmentPrice().doubleValue());
            stmt.execute();


            Order o = this.findByUuid(uuid.toString(), connection);

            connection.close();
            return o;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

       
    }

    @Override
    public List list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Order findById(int id) {
        Connection connection = ConnectionDb.connect("jbdc_studies");
        return null;
    }
    
    @Override
    public Order findByUuid(String uuid) {
        Connection connection = ConnectionDb.connect("jbdc_studies");
        return null;
    }

    @Override
    public Order findByUuid(String uuid, Connection c) {
        if(c == null)
            return null;

        try{
            String query =  "SELECT * FROM shipment where uuid = ?";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, uuid );

            ResultSet response = stmt.executeQuery(query);
            
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
            o.setDispatchTime(response.getDate("dispatch"));

            return o;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
