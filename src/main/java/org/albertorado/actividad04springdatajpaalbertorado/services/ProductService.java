package org.albertorado.actividad04springdatajpaalbertorado.services;


import org.albertorado.actividad04springdatajpaalbertorado.dtos.CategoryDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.ProductDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*
    public List<ProductDto> findAll() {
        return productRepository.findAllOrderByDescriptionDes(PageRequest.of(0,2)).getContent();
    }
*/
    public Page<ProductDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllOrderByDescriptionDes(pageable);
    }

    public Page<ProductDto> findByDescription(String description) {
        Pageable pageable = PageRequest.of(0, 20);
        return productRepository.findAllByDescriptionLikeIgnoreCaseOrderByDescriptionCartsDesc(pageable,description);
    }
}
