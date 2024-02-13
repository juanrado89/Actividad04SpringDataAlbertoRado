package org.albertorado.actividad04springdatajpaalbertorado.dtos;


public interface CartDto {
    int getCartId();
    int getQuantity();
    ProductDto getProduct();
    CustomerDto getCustomer();
}
