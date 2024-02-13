package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.ProductDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p from Product p order by p.description")
    Page<ProductDto> findAllOrderByDescriptionDes(Pageable pageable);

    @Query("SELECT p from Product p where lower(p.description) like lower(concat('%', :searchString, '%')) order by p.description desc")
    Page<ProductDto> findAllByDescriptionContainingIgnoreCaseOrderByDescriptionDesc(Pageable pageable, @Param("searchString") String search);
}
