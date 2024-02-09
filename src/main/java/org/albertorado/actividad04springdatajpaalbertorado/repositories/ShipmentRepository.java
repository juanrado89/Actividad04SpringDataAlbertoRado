package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import jakarta.transaction.Transactional;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.ShipmentDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {


    @Transactional
    @Modifying
    @Query(value = "insert into shipment (customer_id,shipment_date,zip_code,state,country,address,city) values (:customer, :date, :zipCode, :state, :country, :address, :city)", nativeQuery = true)
    void makeShipment(@Param("customer") int customerId, @Param("date") Timestamp date, @Param("zipCode") String zipCode, @Param("state") String state, @Param("country") String country, @Param("address") String address, @Param("city") String city);

    List<ShipmentDto> getAllByCustomer_CustomerIdOrderByShipmentIdDesc(@Param("customer") int customerId);
    @Transactional
    @Modifying
    void removeByShipmentId(@Param("shipment") int shipmentId);
}
