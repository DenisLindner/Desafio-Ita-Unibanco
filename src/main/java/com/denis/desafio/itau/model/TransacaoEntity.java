package com.denis.desafio.itau.model;



import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class TransacaoEntity {

    private double valor;
    private OffsetDateTime dataHora;

    public TransacaoEntity(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }
}
