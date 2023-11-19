package com.br.sgme.sgme.controller.dto;

import com.br.sgme.sgme.model.Receita;
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
public class ReceitaDto implements Serializable {


    @JsonProperty("cliente_id")
    private Long clienteId;
    private String id;

    private Double valor;

    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;

    private String status;

    @JsonProperty("forma_pagamento")
    private String formaPagamento;

    public  static  ReceitaDto to(Receita saved){
        return new ReceitaDto(
                saved.getCliente().getId(),
                saved.getId().toString(),
                saved.getValor(),
                saved.getDataVencimento(),
                saved.getStatus(),
                saved.getPagamento().name()
        );
    }


}
