package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.ShipmentDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {



    List<ShipmentDto> getAllByCustomer_CustomerIdOrderByShipmentIdDesc(@Param("customer") int customerId);

}
