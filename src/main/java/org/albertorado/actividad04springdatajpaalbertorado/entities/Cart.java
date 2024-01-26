package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id",nullable = false)
    private int cartId;
    @Basic
    @Column(name = "quantity",nullable = false)
    private int quantity;

    @OneToMany(mappedBy = "cart")
    private List<Product> productList;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, updatable = false)
    private Customer customer;
}
