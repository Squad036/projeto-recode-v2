package com.br.sgme.sgme.controller.dto;

import com.br.sgme.sgme.model.Despesa;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DespesaDto implements Serializable {

    private Long id;

    @JsonProperty("fornecedor_id")
    @NotNull
    private Long fornecedorid;

    private Double valor;

    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;

    private String status;

    @JsonProperty("forma_pagamento")
    private String formaPagamento;

    public static DespesaDto to(Despesa saved) {
        return new DespesaDto(
                saved.getId(),
                saved.getFornecedor().getId(),
                saved.getValor(),
                saved.getDataVencimento(),
                saved.getStatus(),
                saved.getPagamento().name()
        );
    }
}
