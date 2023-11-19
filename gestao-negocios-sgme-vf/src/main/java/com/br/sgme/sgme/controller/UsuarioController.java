package com.br.sgme.sgme.controller;

import com.br.sgme.sgme.controller.dto.UsuarioDTo;
import com.br.sgme.sgme.ports.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    @GetMapping("/usuarios")
    public List<UsuarioDTo> getAllUsuarios(){
        return usuarioUseCase.get();
    }

    @GetMapping("/usuarios/{id}")
    public  UsuarioDTo getClienteById(@PathVariable Long id){
        return usuarioUseCase.get(id);
    }


    @PostMapping("/usuarios")
    public UsuarioDTo createCliente(@RequestBody UsuarioDTo usuarioDTo){
       return usuarioUseCase.save(usuarioDTo);
    }

    @PutMapping("/usuarios/{id}")
    public UsuarioDTo update(@PathVariable Long id, @RequestBody UsuarioDTo usuarioDTo){
        return usuarioUseCase.update(id, usuarioDTo);
    }

    @DeleteMapping("/usuarios/{id}")
    public void  deleteUsuario(@PathVariable Long id){
        usuarioUseCase.delete(id);
    }
}
