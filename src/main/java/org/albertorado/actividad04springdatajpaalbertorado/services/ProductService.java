package org.albertorado.actividad04springdatajpaalbertorado.services;


import org.albertorado.actividad04springdatajpaalbertorado.dtos.ProductDto;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllOrderByDescriptionDes(pageable);
    }

    public Page<ProductDto> findByDescription(String description) {
        Pageable pageable = PageRequest.of(0, 20);
        return productRepository.findAllByDescriptionContainingIgnoreCaseOrderByDescriptionDesc(pageable,description);
    }
}
