package com.br.sgme.sgme.controller.dto;

import com.br.sgme.sgme.model.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorDto  implements Serializable {
    private Long id;
    private String codigo;
    private String nome;

    public static FornecedorDto to(Fornecedor saved){
        return new FornecedorDto(
                saved.getId(),
                saved.getCodigo(),
                saved.getNome()
        );
    }

}
