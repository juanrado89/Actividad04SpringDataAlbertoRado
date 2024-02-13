package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderItemDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {



    List<OrderItemDto> getOrderItemsByOrder_OrderIdOrderByOrderItemIdDesc(@Param("order") int orderId);
}
