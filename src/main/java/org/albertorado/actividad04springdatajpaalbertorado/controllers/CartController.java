package org.albertorado.actividad04springdatajpaalbertorado.controllers;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartTotalDto;
import org.albertorado.actividad04springdatajpaalbertorado.services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("/products")
    public ResponseEntity<CartTotalDto> getAllCartProducts(@RequestParam int customerId){
        return ResponseEntity.ok(cartService.findAllCartProducts(customerId));
    }

    @PostMapping("/add")
    public ResponseEntity<CartTotalDto> addProduct(@RequestParam int customerId, @RequestParam int productId,@RequestParam int quantity){
        return ResponseEntity.ok(cartService.addProduct(customerId,productId,quantity));
    }

    @PutMapping("/remove")
    public ResponseEntity<String> removeProduct(@RequestParam int customerId, @RequestParam int productId){
        return ResponseEntity.ok(cartService.removeProduct(customerId, productId));
    }

    @PutMapping("/removeall")
    public ResponseEntity<String> removeProduct(@RequestParam int customerId){
        return ResponseEntity.ok(cartService.removeAllProduct(customerId));
    }
}
