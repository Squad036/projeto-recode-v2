package com.br.sgme.sgme.controller.dto;

import com.br.sgme.sgme.model.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteDto implements Serializable {

    private Long id;
    private String cpf;

    private String nome;

    private String telefone;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    public static ClienteDto to(Cliente saved){
        return new ClienteDto(
                saved.getId(),
                saved.getCpf(),
                saved.getNome(),
                saved.getTelefone(),
                saved.getDataNascimento()
        );
    }

}
