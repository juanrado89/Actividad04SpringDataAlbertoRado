package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Order;

import java.sql.Timestamp;
import java.util.List;
@Getter
@AllArgsConstructor
public class ShipmentDto {

    private final int shipmentId;
    private final Timestamp shipmentDate;

    private final String address;
    private final String city;
    private final String state;
    private final String country;
    private final String zipCode;
    private final Customer customer;
    private final List<Order> orderList;
}
