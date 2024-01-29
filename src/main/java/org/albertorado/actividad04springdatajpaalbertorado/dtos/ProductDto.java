package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Category;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class ProductDto {

    private final int productId;
    private final String sku;
    private final String description;
    private final BigDecimal price;
    private final int stock;
    private final List<Category> categories;
}
