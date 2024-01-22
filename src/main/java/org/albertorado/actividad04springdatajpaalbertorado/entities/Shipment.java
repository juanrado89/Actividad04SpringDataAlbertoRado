package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id", nullable = false)
    private int shipmentId;
    @Basic
    @Column(name = "shipment_date", nullable = false)
    private Timestamp shipmentDate;
    @Basic
    @Column(name = "address",length = 100, nullable = false)
    private String address;
    @Basic
    @Column(value = "shipment_date", nullable = false)
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
