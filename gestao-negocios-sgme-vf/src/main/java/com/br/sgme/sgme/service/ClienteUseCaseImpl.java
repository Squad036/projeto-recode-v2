package com.br.sgme.sgme.service;

import com.br.sgme.sgme.controller.dto.ClienteDto;
import com.br.sgme.sgme.model.Cliente;
import com.br.sgme.sgme.ports.ClienteUseCase;
import com.br.sgme.sgme.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteUseCaseImpl  implements ClienteUseCase {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteDto save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .cpf(clienteDto.getCpf())
                .nome(clienteDto.getNome())
                .telefone(clienteDto.getTelefone())
                .dataNascimento(clienteDto.getDataNascimento())
                .build();

        Cliente saved = clienteRepository.save(cliente);
        return ClienteDto.to(saved);
    }

    @Override
    public ClienteDto update(Long idCliente, ClienteDto clienteDto) {
        Cliente clienteSelecionado = clienteRepository.findById(idCliente).get();

        Cliente cliente = Cliente.builder()
                .id(clienteSelecionado.getId())
                .cpf(clienteDto.getCpf())
                .nome(clienteDto.getNome())
                .telefone(clienteDto.getTelefone())
                .dataNascimento(clienteDto.getDataNascimento())
                .build();

        Cliente  saved = clienteRepository.save(cliente);
        return ClienteDto.to(saved);
    }

    @Override
    public List<ClienteDto> get() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteDto ::to)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ClienteDto> get(Pageable pageable) {
        return clienteRepository.findAll(pageable)
                .map(ClienteDto::to);
    }

    @Override
    public ClienteDto get(Long id) {
        return clienteRepository.findById(id)
                .stream()
                .map(ClienteDto ::to)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        ClienteDto clienteSelecionado = get(id);

        if(clienteSelecionado != null){
            clienteRepository.deleteById(id);
        }else {
            throw new Error("Cliente nao encontrado");
        }
    }
}
