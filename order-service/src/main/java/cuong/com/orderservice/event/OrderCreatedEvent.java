package cuong.com.orderservice.event;

import java.io.Serializable;

public class OrderCreatedEvent implements Serializable {
    private Long orderId;
    private String productCode;
    private int quantity;
    private String customerEmail;

    public OrderCreatedEvent() {}

    public OrderCreatedEvent(Long orderId, String productCode, int quantity, String customerEmail) {
        this.orderId = orderId;
        this.productCode = productCode;
        this.quantity = quantity;
        this.customerEmail = customerEmail;
    }

    // Getters và Setters
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
}