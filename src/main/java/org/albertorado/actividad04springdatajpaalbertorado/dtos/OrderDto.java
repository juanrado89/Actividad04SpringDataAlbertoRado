package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;


public interface OrderDto {

    int getOrderId();
    Timestamp getOrderDate();
    BigDecimal getTotalPrice();
}
