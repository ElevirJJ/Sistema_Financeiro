package com.Projeto.SistemaFinanceiro.domain.detalhamento;

import com.Projeto.SistemaFinanceiro.domain.model.Categoria;

public record DadosDetalhamentoCategoria(
        Long id, String nome
) {

    public DadosDetalhamentoCategoria (Categoria categoria){

        this(categoria.getId(),categoria.getNome());

    }
}
