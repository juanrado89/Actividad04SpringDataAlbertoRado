package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.ShipmentDto;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.OrderItemRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.OrderRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ShipmentService {

    private ShipmentRepository shipmentRepository;
    private OrderRepository orderRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, OrderRepository orderRepository) {
        this.shipmentRepository = shipmentRepository;
        this.orderRepository = orderRepository;
    }

    public ShipmentDto makeShipment(int customerId, String zipCode, String state, String country, String address, String city, List<Integer> orders){
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
        shipmentRepository.makeShipment(customerId, date, zipCode, state, country, address, city);
        List<ShipmentDto> envios = shipmentRepository.getAllByCustomer_CustomerIdOrderByShipmentIdDesc(customerId);
        for(Integer order:orders){
            List<OrderDto> orden = orderRepository.getOrderByOrderId(order);
            if(!orden.isEmpty()){
                if(orden.get(0).getShipment() == null){
                    orderRepository.updateOrderByOrderId(orden.get(0).getOrderId(), envios.get(0).getShipmentId());
                }else{
                    throw new RuntimeException("La orden ya ha sido enviada.");
                }
            }else{
                throw new RuntimeException("No tiene ordenes para enviar.");
            }
        }
        return envios.get(0);
    }
}
