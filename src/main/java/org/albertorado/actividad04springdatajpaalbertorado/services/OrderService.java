package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.repositories.CartRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.OrderItemRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository;
    private CartRepository cartRepository;
    private OrderItemRepository orderItemRepository;
}
