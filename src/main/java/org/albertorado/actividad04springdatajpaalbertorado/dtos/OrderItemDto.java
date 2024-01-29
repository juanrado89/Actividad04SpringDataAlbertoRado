package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Order;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderItemDto {

    private final int orderItemId;
    private final int quantity;
    private final BigDecimal price;
    private final Product product;
    private final Order order;
}
