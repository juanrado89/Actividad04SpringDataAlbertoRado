package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;
    @Basic
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;
    @Basic
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    @Basic
    @Column(name = "password", length = 100, nullable = false)
    private String password;
    @Basic
    @Column(name = "address", length = 100, nullable = false)
    private String address;
    @Basic
    @Column(name = "phone_number", length = 100, nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "wishlist_id",referencedColumnName = "wishlist_id",nullable = false,updatable = false)
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "cart_id",nullable = false,updatable = false)
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    private List<Payment> paymentList;

    @OneToMany(mappedBy = "customer")
    private List<Shipment> shipmentList;

}
