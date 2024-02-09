package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import jakarta.transaction.Transactional;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.WishListDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishListRepository extends JpaRepository<Wishlist,Integer> {

    @Query("select w from Wishlist w WHERE w.customer.customerId = :customer")
    List<WishListDto> getAllByCustomer_CustomerId(@Param("customer") int customerId);
    @Transactional
    @Modifying
    @Query(value = "insert into wishlist (customer_id, product_id) values (:customer, :product)",nativeQuery = true)
    void insertProductInWishList(@Param("customer") int customerId, @Param("product") int productId);
    @Transactional
    @Modifying
    void removeByCustomer_CustomerIdAndAndProduct_ProductId(@Param("customer") int customerId, @Param("product") int productId);
    @Transactional
    @Modifying
    void removeAllByCustomer_CustomerId(@Param("customer") int customerId);
}
