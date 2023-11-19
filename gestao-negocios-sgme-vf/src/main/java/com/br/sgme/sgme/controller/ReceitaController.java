package com.br.sgme.sgme.controller;

import com.br.sgme.sgme.controller.dto.ReceitaDto;
import com.br.sgme.sgme.model.Receita;
import com.br.sgme.sgme.ports.ReceitaUseCase;
import com.br.sgme.sgme.repository.ReceitasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitasRepository receitasRepository;
    private final ReceitaUseCase receitaUseCase;

    @GetMapping("/receitasLista")
    public List<ReceitaDto> getAllReceitas() {
        return receitaUseCase.get();
    }
    @GetMapping("/receitas")
    public Page<ReceitaDto> getAllReceitas(Pageable pageable) {
        return receitaUseCase.get(pageable);
    }

    @GetMapping("/receitas/{id}")
    public ReceitaDto getReceitaById(@PathVariable Long id) {
        return receitaUseCase.get(id);
    }

    @PostMapping("/receitas")
    public ReceitaDto createReceita(@RequestBody ReceitaDto receitaDto) {
        return receitaUseCase.save(receitaDto);
    }

    @PutMapping("/receitas/{id}")
    public ReceitaDto updateReceita(@PathVariable("id") Long idReceita, @RequestBody ReceitaDto receitaDto) {
        return receitaUseCase.update(idReceita, receitaDto);
    }

    @DeleteMapping("/receitas/{id}")
    public void deleteReceita(@PathVariable Long id) {
        receitaUseCase.delete(id);
    }
}
