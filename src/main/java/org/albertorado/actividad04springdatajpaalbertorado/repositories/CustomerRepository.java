package org.albertorado.actividad04springdatajpaalbertorado.repositories;

import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
