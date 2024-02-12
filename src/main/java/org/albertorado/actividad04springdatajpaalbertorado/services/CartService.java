package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartTotalDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Cart;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.CartRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.CustomerRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public CartTotalDto findAllCartProducts(int customerId) {
        List<CartDto> carts = cartRepository.findCartsByCustomer(customerId);
        double total = 0;
        for (CartDto cart : carts) {
            total += Double.parseDouble(cart.getProduct().getPrice().toString()) * cart.getQuantity();

        }
        return new CartTotalDto(carts, total);
    }

        public void addProduct(int customerId, int productId, int quantity){
            Optional<Customer> customer = customerRepository.findById(customerId);
            Optional<Product> product = productRepository.findById(productId);
            Optional<Cart> esta = cartRepository.findCartByCustomerAndProduct(customerId, productId);
            if(customer.isPresent()){
                if(product.isPresent()){
                    if (esta.isEmpty()) {
                        Cart cart = new Cart();
                        cart.setCustomer(customer.orElseThrow());
                        cart.setProduct(product.orElseThrow());
                        cart.setQuantity(quantity);
                        cartRepository.save(cart);
                    } else {
                        int quantityNew = esta.get().getQuantity() + quantity;
                        esta.get().setQuantity(quantityNew);
                    }
                }else{
                    throw new RuntimeException("El producto no existe.");
                }
            }else{
                throw new RuntimeException("El cliente no existe.");
            }

        }

        public void removeProduct(int customerId, int productId){
            Optional<Cart> cart = cartRepository.findCartByCustomerAndProduct(customerId, productId);
            if(cart.isPresent()){
                cartRepository.deleteById(cart.get().getCartId());
            }
        }

        public void removeAllProduct(int customerId){

            Optional<Customer> cliente = customerRepository.findById(customerId);
            if(cliente.isPresent()){
                cartRepository.deleteAllInBatch(cliente.get().getCart());
            }else{
                throw new RuntimeException("El cliente no existe.");
            }
        }

}
