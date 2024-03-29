package org.albertorado.actividad04springdatajpaalbertorado.controllers;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.OrderDto;
import org.albertorado.actividad04springdatajpaalbertorado.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/cart")
    public ResponseEntity<OrderDto> completarPedido(@RequestParam int customerId){
        return ResponseEntity.ok(orderService.completarPedido(customerId));
    }
}
