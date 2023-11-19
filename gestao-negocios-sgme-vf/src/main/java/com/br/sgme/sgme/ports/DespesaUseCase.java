package com.br.sgme.sgme.ports;

import com.br.sgme.sgme.controller.dto.DespesaDto;
import com.br.sgme.sgme.model.Despesa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DespesaUseCase {
    DespesaDto save (DespesaDto despesaDto);
    DespesaDto update (Long idDespesa, DespesaDto despesaDto);

    List<DespesaDto> get();

    Page<DespesaDto> get (Pageable pageable);
    DespesaDto get (Long id);

     void delete (Long id);


}
