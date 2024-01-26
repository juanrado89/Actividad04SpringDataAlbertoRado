package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;
    @Basic
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "payment_id",referencedColumnName = "payment_id",nullable = false,updatable = false)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "shipment_id",referencedColumnName = "shipment_id",nullable = false,updatable = false)
    private Shipment shipment;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList;
}
