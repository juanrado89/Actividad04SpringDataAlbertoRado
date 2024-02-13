package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Order;

import java.sql.Timestamp;
import java.util.List;

public interface ShipmentDto {

    int getShipmentId();
    Timestamp getShipmentDate();
    String getAddress();
    String getCity();
    String getState();
    String getCountry();
    String getZipCode();
    CustomerDto getCustomer();
    OrderDto getOrderList();
}
