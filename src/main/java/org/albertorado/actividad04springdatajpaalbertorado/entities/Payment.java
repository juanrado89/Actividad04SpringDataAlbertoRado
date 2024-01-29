package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "payment")
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
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id",nullable = false,updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "payment")
    private List<Order> orders;

    @Override
    public int hashCode() {
        return Objects.hashCode(getPaymentId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Payment payment = (Payment) obj;
        return paymentId == payment.paymentId;
    }

}
