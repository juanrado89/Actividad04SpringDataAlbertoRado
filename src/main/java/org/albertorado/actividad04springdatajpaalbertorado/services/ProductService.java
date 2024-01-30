package org.albertorado.actividad04springdatajpaalbertorado.services;


import org.albertorado.actividad04springdatajpaalbertorado.dtos.ProductDto;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAll() {
        return productRepository.findAllOrderByDescriptionDes(PageRequest.of(0,2)).getContent();
    }
}
