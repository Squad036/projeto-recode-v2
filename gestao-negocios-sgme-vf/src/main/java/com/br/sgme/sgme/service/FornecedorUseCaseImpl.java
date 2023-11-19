package com.br.sgme.sgme.service;

import com.br.sgme.sgme.controller.dto.FornecedorDto;
import com.br.sgme.sgme.model.Fornecedor;
import com.br.sgme.sgme.ports.FornecedorUseCase;
import com.br.sgme.sgme.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FornecedorUseCaseImpl implements FornecedorUseCase {

    private final FornecedorRepository fornecedorRepository;


    @Override
    public FornecedorDto save(FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = Fornecedor.builder()
                .codigo(fornecedorDto.getCodigo())
                .nome(fornecedorDto.getNome())
                .build();

        Fornecedor saved = fornecedorRepository.save(fornecedor);

        return FornecedorDto.to(saved);
    }

    @Override
    public FornecedorDto update(Long id, FornecedorDto fornecedorDto) {
        Fornecedor fornecedorSelecionado = fornecedorRepository.findById(id).get();
        Fornecedor fornecedor = Fornecedor.builder()
                .id(fornecedorSelecionado.getId())
                .codigo(fornecedorDto.getCodigo())
                .nome(fornecedorDto.getNome())
                .build();

        Fornecedor saved = fornecedorRepository.save(fornecedor);
        return FornecedorDto.to(saved);
    }

    @Override
    public List<FornecedorDto> get() {
        return fornecedorRepository.findAll()
                .stream()
                .map(FornecedorDto::to)
                .collect(Collectors.toList());
    }

    @Override
    public Page<FornecedorDto> get(Pageable pageable) {
        return fornecedorRepository.findAll(pageable)
                .map(FornecedorDto::to);
    }

    @Override
    public FornecedorDto get(Long id) {
        return fornecedorRepository.findById(id)
                .stream()
                .map(FornecedorDto::to)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        Fornecedor fornecedorSelecionado = fornecedorRepository.findById(id).get();
        if(fornecedorSelecionado != null){
            fornecedorRepository.deleteById(id);
        }else {
            throw new Error("Fornecedor nao encontrado");
        }

    }
}
