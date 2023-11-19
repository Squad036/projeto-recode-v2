package com.br.sgme.sgme.controller;

import com.br.sgme.sgme.controller.dto.UsuarioDTo;
import com.br.sgme.sgme.ports.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class AutenticacaoController {

    private final UsuarioUseCase usuarioUseCase;

    @PostMapping("/login")
    public UsuarioDTo getClienteByEmail(@RequestBody UsuarioDTo usuarioDTo) {
        UsuarioDTo usuarioInvalido = new UsuarioDTo();
        UsuarioDTo usuarioValido = usuarioUseCase.get(usuarioDTo.getEmail());
        if (usuarioValido.getSenha().equals(usuarioDTo.getSenha())) {

            return usuarioValido;
        }
        return usuarioInvalido;
    }


}
