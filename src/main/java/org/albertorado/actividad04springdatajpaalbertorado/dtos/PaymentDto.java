package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.albertorado.actividad04springdatajpaalbertorado.entities.Customer;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class PaymentDto {

    private final int paymentId;
    private final Timestamp paymentDate;
    private final String paymentMetho;
    private final BigDecimal amount;
    private final Customer customer;
}
