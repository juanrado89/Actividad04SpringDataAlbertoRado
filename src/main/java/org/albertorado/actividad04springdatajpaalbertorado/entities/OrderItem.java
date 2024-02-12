package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table (name = "order_Item",uniqueConstraints = {@UniqueConstraint(name = "products",columnNames = {"product_id","order_id"})})
@NoArgsConstructor
public class OrderItem {
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
    @JoinColumn(name = "product_id",referencedColumnName = "product_id",nullable = false,updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id",nullable = true,updatable = false)
    private Order order;

    @Override
    public int hashCode() {
        return Objects.hashCode(getOrderItemId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OrderItem orderItem = (OrderItem) obj;
        return orderItemId == orderItem.orderItemId;
    }
}
