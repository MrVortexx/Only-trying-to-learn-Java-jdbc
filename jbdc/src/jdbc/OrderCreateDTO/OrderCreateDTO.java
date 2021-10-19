package jdbc.OrderCreateDTO;
import java.math.BigDecimal;

public class OrderCreateDTO {
    private String products;
    private BigDecimal shipmentPrice;

    public OrderCreateDTO(String products, String shipmentPrice) {
        this.products = products;
        this.shipmentPrice = new BigDecimal(shipmentPrice);
    }
    public String getProducts() {
        return products;
    }
    public void setProducts(String products) {
        this.products = products;
    }
    public BigDecimal getShipmentPrice() {
        return shipmentPrice;
    }
    public void setShipmentPrice(BigDecimal shipmentPrice) {
        this.shipmentPrice = shipmentPrice;
    }
}
