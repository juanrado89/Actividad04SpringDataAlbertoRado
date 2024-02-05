package org.albertorado.actividad04springdatajpaalbertorado.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;


public interface CustomerDto {
    int getCustomerId();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getAddress();
    String getPhoneNumber();

}
