package br.com.sistemavendas.dto;

import java.math.BigDecimal;

public record RegistrarVendaRequest(
        Long produtoId,
        BigDecimal valor
) {
}
