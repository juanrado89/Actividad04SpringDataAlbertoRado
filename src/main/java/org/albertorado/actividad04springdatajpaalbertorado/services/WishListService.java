package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.WishListDto;
import org.albertorado.actividad04springdatajpaalbertorado.dtos.WishListTotalDto;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {
    private WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public List<WishListDto> getAllWishListByCustomerId(int customerId){
        return wishListRepository.getAllByCustomer_CustomerId(customerId);
    }
    public void addProductToWishList(int customerId, int productId){
        List<WishListDto> deseos = wishListRepository.getAllByCustomer_CustomerId(customerId);
        if(deseos.isEmpty()){
            wishListRepository.insertProductInWishList(customerId, productId);
        }

    }

    public void removeProduct(int customerId, int productId){
        wishListRepository.removeByCustomer_CustomerIdAndAndProduct_ProductId(customerId, productId);

    }

    public void removeAllProduct(int customerId) {
        wishListRepository.removeAllByCustomer_CustomerId(customerId);

    }
}
