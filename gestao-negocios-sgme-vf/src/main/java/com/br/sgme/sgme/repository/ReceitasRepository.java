package com.br.sgme.sgme.repository;

import com.br.sgme.sgme.model.Despesa;
import com.br.sgme.sgme.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitasRepository extends JpaRepository <Receita, Long>, PagingAndSortingRepository<Receita, Long> {
}
