package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderTotalDto;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.CartRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.OrderItemRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CartRepository cartRepository;
    private OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public OrderTotalDto completarPedido(int customerId){
        List<CartDto> carrito = cartRepository.findCartsByCustomer(customerId);
        double total = 0;
        for(CartDto cart:carrito){
            total += Double.parseDouble(cart.getProduct().getPrice().toString()) * cart.getQuantity();
        }

        orderRepository.insertOrder(customerId,total, Timestamp.valueOf(LocalDateTime.now()));
        List<OrderDto> orders = orderRepository.getOrdersByCustomerOrderByOrderDateDesc(customerId);
        int orderId = orders.get(0).getOrderId();

        for(CartDto cart:carrito){
            orderItemRepository.insertOrderItem(orderId,cart.getProduct().getProductId(),cart.getProduct().getPrice(), cart.getQuantity());
        }
        cartRepository.removeCartByCustomer(customerId);
        return new OrderTotalDto(orders.get(0),orderItemRepository.getOrderItemsByOrder_OrderIdOrderByOrderItemIdDesc(orderId));
    }


}
