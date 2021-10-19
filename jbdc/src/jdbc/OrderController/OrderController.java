package jdbc.OrderController;

import jdbc.OrderCreateDTO.OrderCreateDTO;
import jdbc.OrderRepository.OrderRepository;

public class OrderController {
 
   private final OrderRepository orderRepository;

    OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    /*create(OrderCreateDTO order){

    }*/
}
