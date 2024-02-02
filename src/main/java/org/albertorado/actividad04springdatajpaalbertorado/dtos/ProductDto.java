package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Category;

import java.math.BigDecimal;
import java.util.List;


public interface ProductDto {
    Integer getProductId();
    String getSku();
    String getDescription();
    BigDecimal getPrice();
    Integer getStock();
    List<CategoryDto> getCategories();
}
