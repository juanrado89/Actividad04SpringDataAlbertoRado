package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import jakarta.transaction.Transactional;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;


public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Order (customer_id,payment_id,shipment_id,total_price, order_date) VALUES (:customer, null, null, :total, :fecha)", nativeQuery = true)
    int insertOrder(@Param("customer") int customerId, @Param("total") double total, @Param("fecha")Timestamp fecha);

    @Query("select o from Order o where o.customer.customerId = :customer order by o.orderDate desc")
    List<OrderDto> getOrdersByCustomerOrderByOrderDateDesc(@Param("customer") int customerId);
}
