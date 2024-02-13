package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import java.math.BigDecimal;

public interface OrderItemDto {

    int getOrderItemId();
    int getQuantity();
    BigDecimal getPrice();
    ProductDto getProduct();

}
