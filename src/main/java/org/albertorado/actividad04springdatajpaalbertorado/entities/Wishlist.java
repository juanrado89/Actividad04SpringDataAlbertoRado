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

    @ManyToOne()
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, updatable = false)
    private Customer customer;
}
