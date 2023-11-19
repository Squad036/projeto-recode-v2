package com.br.sgme.sgme.controller;

import com.br.sgme.sgme.controller.dto.DespesaDto;
import com.br.sgme.sgme.ports.DespesaUseCase;
import com.br.sgme.sgme.repository.DespesaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class DespesaController {

    private final DespesaRepository despesaRepository;
    private final DespesaUseCase despesaUseCase;

    @GetMapping("/despesas")
    public Page<DespesaDto> getAllReceitas(Pageable pageable ) {
        return despesaUseCase.get(pageable);
    }

    @GetMapping("/despesaslista")
    public List<DespesaDto> getAllReceitas() {
        return despesaUseCase.get();
    }
    @GetMapping("/despesas/{id}")
    public DespesaDto getDespesaById(@PathVariable Long id) {
        return despesaUseCase.get(id);
    }

    @PostMapping("/despesas")
    public DespesaDto createDespesa(@RequestBody @Valid DespesaDto despesaDto) {
        return despesaUseCase.save(despesaDto);
    }

    @PutMapping("/despesas/{id}")
    public DespesaDto updateReceita(@PathVariable Long id, @RequestBody DespesaDto despesaDetails) {
       return despesaUseCase.update(id,despesaDetails);
    }

    @DeleteMapping("/despesas/{id}")
    public void deleteDespesa(@PathVariable Long id) {
        despesaUseCase.delete(id);
    }
}

