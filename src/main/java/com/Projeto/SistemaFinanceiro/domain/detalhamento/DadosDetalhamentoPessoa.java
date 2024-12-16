package com.Projeto.SistemaFinanceiro.domain.detalhamento;

import com.Projeto.SistemaFinanceiro.domain.endereco.Endereco;
import com.Projeto.SistemaFinanceiro.domain.model.Pessoa;

public record DadosDetalhamentoPessoa(
        Long id, String nome, Boolean ativo,
        Endereco endereco
) {

    public DadosDetalhamentoPessoa (Pessoa pessoa){

        this(pessoa.getId(),pessoa.getNome(),
                pessoa.getAtivo(),
                pessoa.getEndereco());

    }
}
