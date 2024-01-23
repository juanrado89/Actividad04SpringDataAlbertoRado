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
@Table
@NoArgsConstructor
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlist_id",nullable = false)
    private int wishlistId;
    @Basic
    @Column(name = "wishlist_name",length = 100,nullable = false)
    private String wishlistName;

    @ManyToOne
    @JoinColumn(name = "wishlist_id",referencedColumnName = "wishlist_id",nullable = false,updatable = false)
    private Product product;
    @OneToMany()
    private  List<Customer> customers;
}
