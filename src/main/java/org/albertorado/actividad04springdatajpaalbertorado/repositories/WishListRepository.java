package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import jakarta.transaction.Transactional;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.WishListDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WishListRepository extends JpaRepository<Wishlist,Integer> {

    @Query("select w from Wishlist w WHERE w.customer.customerId = :customer")
    List<WishListDto> getAllByCustomer_CustomerId(@Param("customer") int customerId);
    Optional<Wishlist> getByCustomer_CustomerIdAndProduct_ProductId(@Param("customer") int customerId, @Param("product") int productId);

}
