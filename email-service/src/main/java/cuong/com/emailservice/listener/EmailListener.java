package cuong.com.emailservice.listener;

import cuong.com.emailservice.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailListener {

    @KafkaListener(topics = "order-events", groupId = "email-group")
    public void handleOrderCreated(OrderCreatedEvent event) {
        System.out.println("**************************************************");
        System.out.println("[EMAIL-SERVICE] Nhận được sự kiện cho Đơn hàng ID: " + event.getOrderId());
        System.out.println("-> Đang gửi email xác nhận đơn hàng đến khách hàng: " + event.getCustomerEmail());
        // Giả lập gửi email thành công
        System.out.println("[EMAIL-SERVICE] Gửi email thành công!");
        System.out.println("**************************************************");
    }
}