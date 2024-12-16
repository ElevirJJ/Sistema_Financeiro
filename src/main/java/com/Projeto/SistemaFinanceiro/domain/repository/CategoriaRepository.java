package com.Projeto.SistemaFinanceiro.domain.repository;

import com.Projeto.SistemaFinanceiro.domain.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Page<Categoria> findByAtivoTrue(Pageable paginacao);
}