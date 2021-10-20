package jdbc.OrderController;

import jdbc.OrderCreateDTO.OrderCreateDTO;
import jdbc.OrderRepository.OrderRepository;

import java.util.List;

import jdbc.InvalidParamsException.InvalidParamsException;
import jdbc.Order.Order;

public class OrderController {
 
   private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order create(OrderCreateDTO order) throws InvalidParamsException{
        if(order.getProducts() == null){
            throw new InvalidParamsException("Products parameter not sended.");
        }
        if(order.getShipmentPrice() == null){
            throw new InvalidParamsException("ShipmentPrice parameter not sended.");
        }
        Order result = this.orderRepository.create(order);

        return result;
    }
    public Order getOne(String uuid){
        Order o = this.orderRepository.findByUuid(uuid);
        
        return o;
    }
    public List <Order> list() {
      
        List <Order> result =  this.orderRepository.list();

        return result;
    }
}
