package com.br.sgme.sgme.ports;

import com.br.sgme.sgme.controller.dto.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteUseCase {
    ClienteDto save (ClienteDto clienteDto);
    ClienteDto update (Long idCliente, ClienteDto clienteDto);

    List<ClienteDto> get();
    Page<ClienteDto> get(Pageable pageable);

    ClienteDto get (Long id);

    void delete(Long id);
}
