package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import java.sql.Timestamp;

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
