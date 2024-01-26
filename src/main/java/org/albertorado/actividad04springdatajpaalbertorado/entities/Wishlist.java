package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "wishlist")
@NoArgsConstructor
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlist_id",nullable = false)
    private int wishlistId;

    @OneToMany(mappedBy = "wishlist")
    private List<Product> product;
    @OneToMany(mappedBy = "wishlist")
    private  List<Customer> customers;
}
