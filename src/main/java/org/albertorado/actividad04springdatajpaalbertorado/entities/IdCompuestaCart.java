package org.albertorado.actividad04springdatajpaalbertorado.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class IdCompuestaCart implements Serializable {
    private int cartId;
    private int customerId;
}
