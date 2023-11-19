package com.br.sgme.sgme.service;

import com.br.sgme.sgme.controller.dto.DespesaDto;
import com.br.sgme.sgme.enums.FormasPagamento;
import com.br.sgme.sgme.model.Despesa;
import com.br.sgme.sgme.model.Fornecedor;
import com.br.sgme.sgme.ports.DespesaUseCase;
import com.br.sgme.sgme.repository.DespesaRepository;
import com.br.sgme.sgme.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DespesaUseCaseImpl implements DespesaUseCase {

    private final DespesaRepository despesaRepository;
    private final FornecedorRepository fornecedorRepository;
    private Pageable pageable;

    @Override
    public DespesaDto save(DespesaDto despesaDto){
        Fornecedor fornecedor = fornecedorRepository.findById(despesaDto.getFornecedorid()).get();
        Despesa despesa = Despesa.builder()
                .fornecedor(fornecedor)
                .valor(despesaDto.getValor())
                .dataVencimento(despesaDto.getDataVencimento())
                .status(despesaDto.getStatus())
                .pagamento(FormasPagamento.valueOf(despesaDto.getFormaPagamento()))
                .build();

        Despesa saved = despesaRepository.save(despesa);
        return DespesaDto.to(saved);
    }

    @Override
    public DespesaDto update(Long idDespesa, DespesaDto despesaDto) {
        Despesa despesaSelecionada = despesaRepository.findById(idDespesa).get();
        Despesa despesa = Despesa.builder()
                .id(despesaSelecionada.getId())
                .fornecedor(despesaSelecionada.getFornecedor())
                .valor(despesaDto.getValor())
                .dataVencimento(despesaDto.getDataVencimento())
                .status(despesaDto.getStatus())
                .pagamento(FormasPagamento.valueOf(despesaDto.getFormaPagamento()))
                .build();

        Despesa saved = despesaRepository.save(despesa);
        return DespesaDto.to(saved);
    }

    @Override
    public List<DespesaDto> get() {
        return despesaRepository.findAll()
                .stream()
                .map(DespesaDto::to)
                .collect(Collectors.toList());
    }

    @Override
    public Page<DespesaDto> get(Pageable pageable) {
        return despesaRepository.findAll(pageable)
                .map(DespesaDto::to);
    }



    @Override
    public DespesaDto get(Long id) {
        return despesaRepository.findById(id)
                .stream()
                .map(DespesaDto::to)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        DespesaDto despesaSelecionada = get(id);
        if(despesaSelecionada != null){
            despesaRepository.deleteById(id);
        }else {
            throw new Error("Despesa nao existe");
        }

    }


}
