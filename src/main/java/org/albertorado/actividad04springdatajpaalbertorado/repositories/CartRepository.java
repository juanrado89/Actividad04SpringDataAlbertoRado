package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.ProductDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query("select c from Cart c where c.customer.customerId = :customer")
    List<CartDto> findCartsByCustomer(@Param("customer") int customerId);

    @Modifying
    @Query(value = "INSERT INTO Cart (customer_id, product_id, quantity) VALUES (:customerId, :productId, :quantity)", nativeQuery = true)
    void insertCartProduct(@Param("customer") int customerId, @Param("product") int productId, @Param("quantity") int quantity);
    @Modifying
    @Query("DELETE from Cart c where c.customer.customerId = :customer and c.product.productId = :productId")
    int removeCartByProductAndCustomer(@Param("customer") int customerId, @Param("product") int productId);

    @Modifying
    @Query("DELETE from Cart c where c.customer.customerId = :customerId")
    int removeCartByCustomer(@Param("customer") int customerId);
}
