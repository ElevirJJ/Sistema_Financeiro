package com.Projeto.SistemaFinanceiro.domain.listagem;

import com.Projeto.SistemaFinanceiro.domain.model.Pessoa;

public record DadosListagemPessoa(Long id, String nome, Boolean Pessoa) {

    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getAtivo());
    }
}
