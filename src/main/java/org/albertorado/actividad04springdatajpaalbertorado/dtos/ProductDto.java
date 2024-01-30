package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Category;

import java.math.BigDecimal;
import java.util.List;


public record ProductDto(int productId, String sku, String description, BigDecimal price, int stock,
                         List<CategoryDto> categories) {

}
