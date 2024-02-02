package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.ProductDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    //@Query("SELECT new org.albertorado.actividad04springdatajpaalbertorado.dtos.ProductDto(p.productId,p.sku,p.description,p.price,p.stock,c.categoryId,c.name) from Product p JOIN p.categories c")
    //@Query("SELECT p.productId,p.sku,p.description,p.price,p.stock,p.categories from Product p join p.categories order by p.description desc")
    @Query("SELECT p from Product p order by p.description")
    Page<ProductDto> findAllOrderByDescriptionDes(Pageable pageable);
}
