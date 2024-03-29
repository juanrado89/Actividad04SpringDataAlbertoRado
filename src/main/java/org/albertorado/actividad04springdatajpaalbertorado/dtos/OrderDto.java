package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface OrderDto {

    int getOrderId();
    Timestamp getOrderDate();
    BigDecimal getTotalPrice();
    ShipmentDto getShipment();
    List<OrderItemDto> getOrderItem();
}
