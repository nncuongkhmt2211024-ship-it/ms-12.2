package cuong.com.inventoryservice.listener;

import cuong.com.inventoryservice.event.OrderCreatedEvent; // Hoặc copy lại class Event này sang module này
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryListener {

    @KafkaListener(topics = "order-events", groupId = "inventory-group")
    public void handleOrderCreated(OrderCreatedEvent event) {
        System.out.println("==================================================");
        System.out.println("[INVENTORY-SERVICE] Nhận được sự kiện cho Đơn hàng ID: " + event.getOrderId());
        System.out.println("-> Đang tiến hành trừ kho sản phẩm: " + event.getProductCode() + " với số lượng: " + event.getQuantity());
        // Giả lập xử lý nghiệp vụ trừ kho mất vài giây...
        System.out.println("[INVENTORY-SERVICE] Đã cập nhật kho thành công!");
        System.out.println("==================================================");
    }
}