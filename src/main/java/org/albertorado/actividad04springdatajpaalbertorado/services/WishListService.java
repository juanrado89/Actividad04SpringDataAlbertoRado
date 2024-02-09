package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.WishListDto;
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
        return wishListRepository.getWishlistsByCustomer_CustomerIdOrderByWishlistIdDesc(customerId);
    }
    public List<WishListDto> addProductToWishList(int customerId, int productId){
        wishListRepository.insertProductInWishList(customerId, productId);
        return wishListRepository.getWishlistsByCustomer_CustomerIdOrderByWishlistIdDesc(customerId);
    }

    public List<WishListDto> removeProduct(int customerId, int productId){
        wishListRepository.removeByCustomer_CustomerIdAndAndProduct_ProductId(customerId, productId);
        return wishListRepository.getWishlistsByCustomer_CustomerIdOrderByWishlistIdDesc(customerId);
    }

    public List<WishListDto> removeAllProduct(int customerId) {
        wishListRepository.removeAllByCustomer_CustomerId(customerId);
        return wishListRepository.getWishlistsByCustomer_CustomerIdOrderByWishlistIdDesc(customerId);
    }
}
