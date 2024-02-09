package org.albertorado.actividad04springdatajpaalbertorado.controllers;

import org.albertorado.actividad04springdatajpaalbertorado.services.ShipmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }


}
