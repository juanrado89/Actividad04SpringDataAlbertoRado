package org.albertorado.actividad04springdatajpaalbertorado.controllers;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.ShipmentDto;
import org.albertorado.actividad04springdatajpaalbertorado.services.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }


    @PostMapping("/send")
    public ResponseEntity<ShipmentDto> sendOrder(@RequestParam int customerId, @RequestParam String zipCode, @RequestParam String state, @RequestParam String country, @RequestParam String address, @RequestParam String city, @RequestParam List<Integer> orders){
        return ResponseEntity.ok(shipmentService.makeShipment(customerId, zipCode, state, country, address, city, orders));
    }
}
