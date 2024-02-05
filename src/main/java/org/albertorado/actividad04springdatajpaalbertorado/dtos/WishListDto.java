package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;

public interface WishListDto {

    int getWishlistId();
    ProductDto getProduct();
    CustomerDto getCustomer();
}
