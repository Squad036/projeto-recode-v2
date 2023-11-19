package com.br.sgme.sgme.controller;

import com.br.sgme.sgme.controller.dto.FornecedorDto;
import com.br.sgme.sgme.ports.FornecedorUseCase;
import com.br.sgme.sgme.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class FornecedorController {

    private final FornecedorUseCase fornecedorUseCase;

    @GetMapping("/fornecedoresLista")
    public List<FornecedorDto> getAllFornecedores() {
        return fornecedorUseCase.get();
    }

    @GetMapping("/fornecedores")
    public Page<FornecedorDto> getAllFornecedores(Pageable pageable){
        return fornecedorUseCase.get(pageable);
    }

    @GetMapping("/fornecedores/{id}")
    public FornecedorDto getFornecedorById(@PathVariable Long id) {
        return fornecedorUseCase.get(id);
    }

    @PostMapping("/fornecedores")
    public FornecedorDto createFornecedor(@RequestBody FornecedorDto fornecedorDto) {
        return fornecedorUseCase.save(fornecedorDto);
    }

    @PutMapping("/fornecedores/{id}")
    public FornecedorDto updateFornecedor(@PathVariable Long id, @RequestBody FornecedorDto fornecedorDetails) {
        return fornecedorUseCase.update(id, fornecedorDetails);

    }

    @DeleteMapping("/fornecedores/{id}")
    public void deleteFornecedor(@PathVariable Long id) {
        fornecedorUseCase.delete(id);
    }
}
