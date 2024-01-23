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
@Table (name = "Order_Item")
@NoArgsConstructor
public class OrdeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id",nullable = false)
    private int orderItemId;
    @Basic
    @Column(name = "quantity",nullable = false)
    private int quantity;
    @Basic
    @Column(name = "price",precision = 10,scale = 2,nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_item_id",referencedColumnName = "order_item_id",nullable = false,updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_item_id",referencedColumnName = "order_item_id",nullable = false,updatable = false)
    private Order order;
}
