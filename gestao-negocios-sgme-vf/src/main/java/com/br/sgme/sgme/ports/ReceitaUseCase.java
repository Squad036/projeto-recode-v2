package com.br.sgme.sgme.ports;

import com.br.sgme.sgme.controller.dto.ReceitaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceitaUseCase {
    ReceitaDto save(ReceitaDto receitaDto);

    ReceitaDto update(Long idReceita, ReceitaDto receitaDto);

    List<ReceitaDto> get();

    Page<ReceitaDto> get(Pageable pageable);
    ReceitaDto get(Long id);

    void delete(Long id);

}
