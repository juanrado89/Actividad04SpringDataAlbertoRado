package org.albertorado.actividad04springdatajpaalbertorado.services;

import org.albertorado.actividad04springdatajpaalbertorado.dtos.WishListDto;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Product;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Wishlist;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.CustomerRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.ProductRepository;
import org.albertorado.actividad04springdatajpaalbertorado.repositories.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishListService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.wishListRepository = wishListRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public List<WishListDto> getAllWishListByCustomerId(int customerId){
        return wishListRepository.getAllByCustomer_CustomerId(customerId);
    }
    public void addProductToWishList(int customerId, int productId){
        Optional<Wishlist> productList = wishListRepository.getByCustomer_CustomerIdAndProduct_ProductId(customerId, productId);
        if(productList.isEmpty()){
            Optional<Product> producto = productRepository.findById(productId);
            Optional<Customer> cliente = customerRepository.findById(customerId);
            if(cliente.isPresent()){
                if(producto.isPresent()){
                    Wishlist wishList = new Wishlist();
                    wishList.setProduct(producto.orElseThrow());
                    wishList.setCustomer(cliente.orElseThrow());
                    wishListRepository.save(wishList);
                }
            }

        }
    }

    public void removeProduct(int customerId, int productId){
        Optional<Customer> cliente = customerRepository.findById(customerId);
        Optional<Product> producto = productRepository.findById(productId);
        if(cliente.isPresent()){
            if(producto.isPresent()){
                Optional<Wishlist> eliminar = wishListRepository.getByCustomer_CustomerIdAndProduct_ProductId(customerId, productId);
                if(eliminar.isPresent()){
                    wishListRepository.delete(eliminar.orElseThrow());
                }
            }
        }

    }

    public void removeAllProduct(int customerId) {
        Optional<Customer> cliente = customerRepository.findById(customerId);
        if(cliente.isPresent()){
            List<Wishlist> lista = cliente.get().getWishlist();
            wishListRepository.deleteAllInBatch(lista);
        }
    }
}
