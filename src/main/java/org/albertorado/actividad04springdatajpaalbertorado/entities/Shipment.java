package org.albertorado.actividad04springdatajpaalbertorado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shipment")
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
    @Column(name = "city", length = 100, nullable = false)
    private String city;
    @Basic
    @Column(name = "state", length = 20, nullable = false)
    private String state;
    @Basic
    @Column(name = "country", length = 50, nullable = false)
    private String country;
    @Basic
    @Column(name = "zip_code", length = 10, nullable = false)
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id",nullable = false,updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "shipment")
    private List<Order> orderList;

    @Override
    public int hashCode() {
        return Objects.hashCode(getShipmentId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shipment shipment = (Shipment) obj;
        return shipmentId == shipment.shipmentId;
    }
}
