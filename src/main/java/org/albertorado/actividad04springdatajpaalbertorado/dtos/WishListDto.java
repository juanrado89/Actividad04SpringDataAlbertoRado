package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;
@Getter
@AllArgsConstructor
public class WishListDto {

    private final int wishlistId;
    private final Product product;
    private final Customer customer;
}
