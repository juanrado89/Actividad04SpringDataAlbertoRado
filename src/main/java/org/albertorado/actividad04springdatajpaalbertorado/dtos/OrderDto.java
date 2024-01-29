package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class OrderDto {

    private final int orderId;
    private final Timestamp orderDate;
    private final BigDecimal totalPrice;
}
