package com.br.sgme.sgme.controller;

import com.br.sgme.sgme.controller.dto.ClienteDto;
import com.br.sgme.sgme.model.Cliente;
import com.br.sgme.sgme.ports.ClienteUseCase;
import com.br.sgme.sgme.repository.ClienteRepository;
import jakarta.persistence.Access;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class ClienteController {


    private final ClienteUseCase clienteUseCase;

    @GetMapping("/clientes")
    public Page<ClienteDto> getAllClientes(Pageable pageable) {
        return clienteUseCase.get(pageable);
    }

    @GetMapping("/clientesLista")
    public List<ClienteDto> getAllClientes() {
        return clienteUseCase.get();
    }

    @GetMapping("/clientes/{id}")
    public ClienteDto getClienteById(@PathVariable Long id) {
        return clienteUseCase.get(id);
    }

    @PostMapping("/clientes")
    public ClienteDto createCliente(@RequestBody ClienteDto clienteDto) {
        return clienteUseCase.save(clienteDto);
    }

    @PutMapping("/clientes/{id}")
    public ClienteDto updateCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        return clienteUseCase.update(id, clienteDto);

    }

    @DeleteMapping("/clientes/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteUseCase.delete(id);
    }
}
