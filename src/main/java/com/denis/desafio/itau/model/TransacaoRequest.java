package com.denis.desafio.itau.model;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record TransacaoRequest(double valor, @NotNull OffsetDateTime dataHora) {
}
