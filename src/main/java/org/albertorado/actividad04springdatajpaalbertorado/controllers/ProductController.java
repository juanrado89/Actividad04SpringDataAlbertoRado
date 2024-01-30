package org.albertorado.actividad04springdatajpaalbertorado.controllers;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.ProductDto;
import org.albertorado.actividad04springdatajpaalbertorado.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
}
