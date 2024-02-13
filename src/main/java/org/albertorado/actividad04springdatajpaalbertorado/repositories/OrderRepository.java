package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<OrderDto> getOrdersByCustomer_CustomerIdOrderByOrderDateDesc(int customerId);
}
