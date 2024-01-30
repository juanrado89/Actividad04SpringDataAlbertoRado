package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    //Collection<CartDto> getAllCartsDto();
    //@Query("SELECT NEW org.albertorado.actividad04springdatajpaalbertorado.dtos.CartDto(c.cartId, c.quantity, new (p.productId, p.sku, p.description, p.price, p.stock), new (cu.customerId, cu.firstName, cu.lastName, cu.email, cu.address, cu.phoneNumber)) FROM Cart c JOIN c.product p JOIN c.customer cu WHERE c.cartId = :cartId")
    //Optional<CartDto> getCartByCartId(@Param("cartId") int cartId);
}
