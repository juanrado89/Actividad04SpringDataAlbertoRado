package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartTotalDto;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartTotalDto findAllCartProducts(int customerId){
        List<CartDto> carts = cartRepository.findCartsByCustomer(customerId);
        double total = 0;
        for(CartDto cart: carts){
            total += Double.parseDouble(cart.getProduct().getPrice().toString()) * cart.getQuantity();
        }
        return new CartTotalDto(carts,total);
    }

    public CartTotalDto addProduct(int customerId, int productId, int quantity){
        cartRepository.insertCartProduct(customerId, productId, quantity);
        return findAllCartProducts(customerId);
    }

    public String removeProduct(int customerId, int productId){
        String filas = "El número de filas borradas es de ";
        filas += cartRepository.removeCartByProductAndCustomer(customerId,productId);
        return filas;
    }

    public String removeAllProduct(int customerId){
        String filas = "El número de filas borradas es de ";
        filas += cartRepository.removeCartByCustomer(customerId);
        return filas;
    }
}
