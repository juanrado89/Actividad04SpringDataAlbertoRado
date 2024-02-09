package org.albertorado.actividad04springdatajpaalbertorado.controllers;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.WishListDto;
import org.albertorado.actividad04springdatajpaalbertorado.services.WishListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    private WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }
    @GetMapping("byid")
    public ResponseEntity<List<WishListDto>> getAllWishListByCustomerId(@RequestParam int customerId){
        return ResponseEntity.ok(wishListService.getAllWishListByCustomerId(customerId));
    }
    @PostMapping("/add")
    public ResponseEntity<List<WishListDto>> addProductToWishList(@RequestParam int customerId, @RequestParam int productId){
        wishListService.addProductToWishList(customerId, productId);
        return ResponseEntity.ok(wishListService.getAllWishListByCustomerId(customerId));
    }
    @PutMapping("/remove")
    public ResponseEntity<List<WishListDto>> removeProduct(@RequestParam int customerId, @RequestParam int productId){
        wishListService.removeProduct(customerId, productId);
        return ResponseEntity.ok(wishListService.getAllWishListByCustomerId(customerId));
    }

    @PutMapping("/removeall")
    public ResponseEntity<List<WishListDto>> removeAllProduct(@RequestParam int customerId){
        wishListService.removeAllProduct(customerId);
        return ResponseEntity.ok(wishListService.getAllWishListByCustomerId(customerId));
    }
}
