package com.br.sgme.sgme.ports;

import com.br.sgme.sgme.controller.dto.ClienteDto;
import com.br.sgme.sgme.controller.dto.UsuarioDTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Stream;

public interface UsuarioUseCase {

    UsuarioDTo save (UsuarioDTo usuarioDTo);
    UsuarioDTo update (Long idUsuario, UsuarioDTo usuarioDTo);

    List<UsuarioDTo> get();
     UsuarioDTo get (Long id);
    UsuarioDTo get (String email);

    void delete(Long id);
}
