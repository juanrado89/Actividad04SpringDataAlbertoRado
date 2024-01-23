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
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private int paymentId;
    @Basic
    @Column(name = "payment_date",nullable = false)
    private Timestamp paymentDate;
    @Basic
    @Column(name = "payment_metho",length = 100,nullable = false)
    private String paymentMetho;
    @Basic
    @Column(name = "amount",precision = 10,scale = 2,nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "payment_id",referencedColumnName = "payment_id",nullable = false,updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "payment")
    private List<Order> orders;
}
