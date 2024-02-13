package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderTotalDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.*;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.CartRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.OrderItemRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public OrderDto completarPedido(int customerId){
        List<CartDto> carrito = cartRepository.findCartsByCustomer(customerId);
        List<Cart> carritoForInsert = new ArrayList<>();
        if(!carrito.isEmpty()){
            double total = 0;
            for(CartDto cart:carrito){
                Product product = new Product();
                Customer customer = new Customer();

                product.setProductId(cart.getProduct().getProductId());
                product.setSku(cart.getProduct().getSku());
                product.setDescription(cart.getProduct().getDescription());
                product.setPrice(cart.getProduct().getPrice());
                product.setStock(cart.getProduct().getStock());


                customer.setCustomerId(cart.getCustomer().getCustomerId());
                customer.setFirstName(cart.getCustomer().getFirstName());
                customer.setLastName(cart.getCustomer().getLastName());
                customer.setEmail(cart.getCustomer().getEmail());
                customer.setAddress(cart.getCustomer().getAddress());
                customer.setPhoneNumber(cart.getCustomer().getPhoneNumber());
                carritoForInsert.add(new Cart(cart.getCartId(),cart.getQuantity(),product,customer));
                total += Double.parseDouble(cart.getProduct().getPrice().toString()) * cart.getQuantity();
            }

            Order order = new Order();
            order.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
            order.setTotalPrice(BigDecimal.valueOf(total));
            order.setCustomer(carritoForInsert.get(0).getCustomer());
            orderRepository.save(order);

            List<OrderItem> cartProducts = new ArrayList<>();

            for(Cart cart:carritoForInsert){
                OrderItem item = new OrderItem();
                item.setPrice(cart.getProduct().getPrice());
                item.setProduct(cart.getProduct());
                item.setQuantity(cart.getQuantity());
                item.setOrder(order);
                cartProducts.add(item);
            }
            orderItemRepository.saveAll(cartProducts);
            order.setOrderItem(cartProducts);
            orderRepository.save(order);
            cartRepository.deleteAllInBatch(carritoForInsert);
            return orderRepository.getOrdersByCustomer_CustomerIdOrderByOrderDateDesc(order.getCustomer().getCustomerId()).get(0);
        }else{
            throw new RuntimeException("El carrito esta vacio, no se puede realizar la orden");
        }

    }


}
