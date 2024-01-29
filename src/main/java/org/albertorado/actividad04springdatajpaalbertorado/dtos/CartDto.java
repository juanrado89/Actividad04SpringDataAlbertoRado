package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;

@Getter
@AllArgsConstructor
public class CartDto {
    private final int cartId;
    private final int cuantity;
    private final Product product;
    private final Customer customer;
}
