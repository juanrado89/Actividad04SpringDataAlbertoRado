package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.ShipmentDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Order;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Shipment;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.CustomerRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.OrderRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.ShipmentRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    private final CustomerRepository customerRepository;
    private final ShipmentRepository shipmentRepository;
    private final OrderRepository orderRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.shipmentRepository = shipmentRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public ShipmentDto makeShipment(int customerId, String zipCode, String state, String country, String address, String city, List<Integer> orders){
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
        Optional<Customer> cliente = customerRepository.findById(customerId);
        if(cliente.isPresent()){
            List<Order> ordenes = new ArrayList<>();
            for(Integer order:orders){
                Optional<Order> include = orderRepository.findById(order);
                if(include.isPresent()){
                    if(include.get().getShipment() == null){
                        ordenes.add(include.get());
                    }else{
                        throw new RuntimeException("El pedido ya ha sido enviado");
                    }
                }else{
                    throw new ObjectNotFoundException(include.get().getOrderId(),"Order");
                }
            }
            if(!ordenes.isEmpty()){
                Shipment shipment = new Shipment();
                shipment.setShipmentDate(date);
                shipment.setCity(city);
                shipment.setAddress(address);
                shipment.setCountry(country);
                shipment.setState(state);
                shipment.setZipCode(zipCode);
                shipment.setCustomer(cliente.orElseThrow());

                shipmentRepository.save(shipment);

                for(Order orden:ordenes){
                    orden.setShipment(shipment);
                    orderRepository.save(orden);
                }
            }else{
                throw new RuntimeException("No tiene ordenes para enviar.");
            }
        }else{
            throw new ObjectNotFoundException(customerId,"Customer");
        }
        List<ShipmentDto> envio = shipmentRepository.getAllByCustomer_CustomerIdOrderByShipmentIdDesc(customerId);
        return envio.get(0);
    }
}
