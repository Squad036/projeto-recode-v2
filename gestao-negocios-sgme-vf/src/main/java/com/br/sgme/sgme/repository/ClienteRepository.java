package com.br.sgme.sgme.repository;

import com.br.sgme.sgme.model.Cliente;
import com.br.sgme.sgme.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {
}
