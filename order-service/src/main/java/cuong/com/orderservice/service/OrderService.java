package cuong.com.orderservice.service;

import cuong.com.orderservice.entity.OrderEntity;
import cuong.com.orderservice.event.OrderCreatedEvent;
import cuong.com.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    public OrderService(OrderRepository orderRepository, OrderProducer orderProducer) {
        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    public OrderEntity createOrder(OrderEntity order) {
        // 1. Lưu đơn hàng vào Database với trạng thái PENDING
        order.setStatus("PENDING");
        OrderEntity savedOrder = orderRepository.save(order);
        System.out.println("===========> [DB] Đã lưu đơn hàng thành công với ID: " + savedOrder.getId());

        // 2. Tạo Event và bắn lên Kafka Topic (không cần đợi trừ kho hay gửi mail)
        OrderCreatedEvent event = new OrderCreatedEvent(
                savedOrder.getId(),
                savedOrder.getProductCode(),
                savedOrder.getQuantity(),
                savedOrder.getCustomerEmail()
        );
        orderProducer.sendOrderCreatedEvent(event);

        return savedOrder;
    }
}