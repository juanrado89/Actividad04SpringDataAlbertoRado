package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="product")
@NoArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "SKU",length = 100,nullable = false)
    private String sku;
    @Basic
    @Column(name = "description",length = 100,nullable = false)
    private String description;
    @Basic
    @Column(name = "price",precision = 10,scale = 2,nullable = false)
    private BigDecimal price;
    @Basic
    @Column(name = "stock",nullable = false)
    private int stock;

    @ManyToOne()
    @JoinColumn(name = "wishlist_id",referencedColumnName = "wishlist_id",nullable = false,updatable = false,unique = true)
    private Wishlist wishlist;

    @ManyToOne()
    @JoinColumn(name = "cart_id",referencedColumnName = "cart_id",nullable = false,updatable = false,unique = true)
    private Cart cart;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    @ManyToMany
    @JoinTable(
            name="category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
}
