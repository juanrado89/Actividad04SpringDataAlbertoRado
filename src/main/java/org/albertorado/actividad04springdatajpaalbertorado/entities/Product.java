package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table
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
    private int stock;
}
