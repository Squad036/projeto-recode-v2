package com.br.sgme.sgme.ports;

import com.br.sgme.sgme.controller.dto.FornecedorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FornecedorUseCase {
    FornecedorDto save (FornecedorDto fornecedorDto);

    FornecedorDto update(Long id, FornecedorDto fornecedorDto);

    List<FornecedorDto> get();
    Page <FornecedorDto> get(Pageable pageable);

    FornecedorDto get(Long id);

    void delete(Long id);

}
