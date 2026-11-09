package cuong.com.orderservice.controller;

import cuong.com.orderservice.entity.OrderEntity;
import cuong.com.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderEntity order) {
        return orderService.createOrder(order);
    }
}