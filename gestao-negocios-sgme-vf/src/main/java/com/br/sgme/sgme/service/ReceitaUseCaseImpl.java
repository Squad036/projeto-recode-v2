package com.br.sgme.sgme.service;

import com.br.sgme.sgme.controller.dto.DespesaDto;
import com.br.sgme.sgme.controller.dto.ReceitaDto;
import com.br.sgme.sgme.enums.FormasPagamento;
import com.br.sgme.sgme.model.Cliente;
import com.br.sgme.sgme.model.Receita;
import com.br.sgme.sgme.ports.ReceitaUseCase;
import com.br.sgme.sgme.repository.ClienteRepository;
import com.br.sgme.sgme.repository.ReceitasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceitaUseCaseImpl implements ReceitaUseCase {
    private final ReceitasRepository receitasRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public ReceitaDto save(ReceitaDto receitaDto){
        Cliente cliente = clienteRepository.findById(receitaDto.getClienteId()).get();
        Receita receita = Receita.builder()
                .cliente(cliente)
                .valor(receitaDto.getValor())
                .dataVencimento(receitaDto.getDataVencimento())
                .status(receitaDto.getStatus())
                .pagamento(FormasPagamento.valueOf(receitaDto.getFormaPagamento()))
                .build();

        Receita saved = receitasRepository.save(receita);
        return ReceitaDto.to(saved);
    }

    @Override
    public ReceitaDto update(Long idReceita, ReceitaDto receitaDto) {
        Receita receitaSelecionada = receitasRepository.findById(idReceita).get();
        Receita receita = Receita.builder()
                .id(receitaSelecionada.getId())
                .cliente(receitaSelecionada.getCliente())
                .valor(receitaDto.getValor())
                .dataVencimento(receitaDto.getDataVencimento())
                .status(receitaDto.getStatus())
                .pagamento(FormasPagamento.valueOf(receitaDto.getFormaPagamento()))
                .build();

        Receita saved = receitasRepository.save(receita);
        return ReceitaDto.to(saved);
    }

    @Override
    public List<ReceitaDto> get() {
        return receitasRepository.findAll()
                .stream()
                .map(ReceitaDto::to)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ReceitaDto> get(Pageable pageable) {
        return receitasRepository.findAll(pageable)
                .map(ReceitaDto::to);
    }

    @Override
    public ReceitaDto get(Long id) {
        return receitasRepository.findById(id)
                .stream()
                .map(ReceitaDto::to)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        ReceitaDto receitaSelecionada = get(id);
        if(receitaSelecionada != null){
            receitasRepository.deleteById(id);
        }else {
            throw new Error("Receita nao existe");
        }

    }

}
