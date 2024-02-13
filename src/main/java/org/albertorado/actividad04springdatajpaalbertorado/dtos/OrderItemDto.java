package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Order;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;

import java.math.BigDecimal;


public interface OrderItemDto {

    int getOrderItemId();
    int getQuantity();
    BigDecimal getPrice();
    ProductDto getProduct();

}
