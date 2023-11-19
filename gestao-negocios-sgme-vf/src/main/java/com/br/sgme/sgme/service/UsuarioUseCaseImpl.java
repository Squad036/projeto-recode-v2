package com.br.sgme.sgme.service;

import com.br.sgme.sgme.controller.dto.UsuarioDTo;
import com.br.sgme.sgme.model.Usuario;
import com.br.sgme.sgme.ports.UsuarioUseCase;
import com.br.sgme.sgme.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTo save(UsuarioDTo usuarioDTo) {
        Usuario usuario = Usuario.builder()
                .nome(usuarioDTo.getNome())
                .email(usuarioDTo.getEmail())
                .senha(usuarioDTo.getSenha())
                .build();

        Usuario saved = usuarioRepository.save(usuario);
        return UsuarioDTo.to(saved);
    }

    @Override
    public UsuarioDTo update(Long idUsuario, UsuarioDTo usuarioDTo) {
        Usuario usuarioSelecionado = usuarioRepository.findById(idUsuario).get();

        Usuario usuario = Usuario.builder()
                .id(usuarioSelecionado.getId())
                .nome(usuarioDTo.getNome())
                .email(usuarioDTo.getEmail())
                .senha(usuarioSelecionado.getSenha())
                .build();
        Usuario saved = usuarioRepository.save(usuario);

        return UsuarioDTo.to(saved);
    }

    @Override
    public List<UsuarioDTo> get() {

        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTo::to)
                .collect(Collectors.toList());
    }



    @Override
    public UsuarioDTo get(Long id) {
        return usuarioRepository.findById(id)
                .stream()
                .map(UsuarioDTo::to)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public UsuarioDTo get(String email) {
        return usuarioRepository.findByEmail(email)
                .stream()
                .map(UsuarioDTo::to)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        UsuarioDTo usuarioSelecionado = get(id);

        if (usuarioSelecionado != null) {
            usuarioRepository.deleteById(id);
        } else {
            throw new Error("Usuario não encontrado");
        }

    }


}
