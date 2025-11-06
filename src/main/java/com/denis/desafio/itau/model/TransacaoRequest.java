package com.denis.desafio.itau.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record TransacaoRequest(@Min(0) double valor, @NotNull OffsetDateTime dataHora) {
}
