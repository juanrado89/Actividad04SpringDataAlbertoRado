package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import jakarta.transaction.Transactional;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderItemDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into order_item (order_id,price,product_id,quantity) values (:order,:price,:product,:quantity)",nativeQuery = true)
    int insertOrderItem(@Param("order") int order, @Param("product") int product, @Param("price")BigDecimal price,@Param("quantity") int quantity);

    List<OrderItemDto> getOrderItemsByOrder_OrderIdOrderByOrderItemIdDesc(@Param("order") int orderId);
}
