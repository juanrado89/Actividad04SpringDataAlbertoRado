package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
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
}
