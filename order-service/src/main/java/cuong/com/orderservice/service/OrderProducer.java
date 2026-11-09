package cuong.com.orderservice.service;

import cuong.com.orderservice.event.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "order-events";

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCreatedEvent(OrderCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("===========> [KAFKA PRODUCER] Đã bắn sự kiện OrderCreatedEvent cho đơn hàng ID: " + event.getOrderId());
    }
}