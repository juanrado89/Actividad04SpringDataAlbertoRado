package org.albertorado.actividad04springdatajpaalbertorado.controllers;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.CartTotalDto;
import org.albertorado.actividad04springdatajpaalbertorado.services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("/products")
    public ResponseEntity<CartTotalDto> getAllCartProducts(@RequestParam int customerId){
        return ResponseEntity.ok(cartService.findAllCartProducts(customerId));
    }

    @PostMapping("/add")
    public ResponseEntity<CartTotalDto> addProduct(@RequestParam int customerId, @RequestParam int productId,@RequestParam int quantity){
        cartService.addProduct(customerId,productId,quantity);
        return ResponseEntity.ok(cartService.findAllCartProducts(customerId));
    }

    @PutMapping("/remove")
    public void removeProduct(@RequestParam int customerId, @RequestParam int productId){
        cartService.removeProduct(customerId, productId);
    }

    @PutMapping("/removeall")
    public void removeProduct(@RequestParam int customerId){
        cartService.removeAllProduct(customerId);
    }
}
