package jdbc.Order;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    
    private int id;
    private String uuid;
    private String status;
    private String products;
    private BigDecimal shipmentPrice;
    private Date dispatchTime;
    private Date deliveredTime;

    public Order(){
   
    }
    public Order(int id, String status, String products, BigDecimal shipmentPrice, Date dispatchTime,
            Date deliveredTime) {
        this.id = id;
        this.status = status;
        this.products = products;
        this.shipmentPrice = shipmentPrice;
        this.dispatchTime = dispatchTime;
        this.deliveredTime = deliveredTime;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public Date getDeliveredTime() {
        return deliveredTime;
    }
    public void setDeliveredTime(Date deliveredTime) {
        this.deliveredTime = deliveredTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
    public Date getDispatchTime() {
        return dispatchTime;
    }
    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

 
}
