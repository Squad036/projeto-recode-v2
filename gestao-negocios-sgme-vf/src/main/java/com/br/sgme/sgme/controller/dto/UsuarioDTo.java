package com.br.sgme.sgme.controller.dto;

import com.br.sgme.sgme.model.Cliente;
import com.br.sgme.sgme.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTo  {
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String email;

    @NonNull
    private String senha;

    public static UsuarioDTo to(Usuario saved) {
        return new UsuarioDTo(
                saved.getId(),
                saved.getNome(),
                saved.getEmail(),
                saved.getSenha()
        );
    }
}
