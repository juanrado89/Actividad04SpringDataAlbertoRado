package org.albertorado.actividad04springdatajpaalbertorado.controllers;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.ProductDto;
import org.albertorado.actividad04springdatajpaalbertorado.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/productos")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/all")
    public ResponseEntity<Page<ProductDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size) {
        Page<ProductDto> productDtoPage= productService.findAll(page, size);
        return ResponseEntity.ok(productDtoPage);
    }
    @PostMapping("/description")
    public ResponseEntity<Page<ProductDto>> findByDescription(@RequestParam String descripcion){
        Page<ProductDto> productDtoPage = productService.findByDescription(descripcion);
        return ResponseEntity.ok(productDtoPage);
    }
}
