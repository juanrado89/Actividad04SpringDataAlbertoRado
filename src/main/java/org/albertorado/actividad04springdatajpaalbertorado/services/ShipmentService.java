package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.ShipmentDto;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ShipmentService {

    private ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public ShipmentDto makeShipment(int customerId, Timestamp date, String zipCode, String state, String country, String address, String city){

    }
}
