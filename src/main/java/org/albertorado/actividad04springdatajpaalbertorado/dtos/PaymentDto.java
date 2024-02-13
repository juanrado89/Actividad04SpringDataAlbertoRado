package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface PaymentDto {

    int getPaymentId();
    Timestamp getPaymentDate();
    String getPaymentMetho();
    BigDecimal getAmount();
    CustomerDto getCustomer();
}
