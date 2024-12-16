package com.Projeto.SistemaFinanceiro.domain.listagem;

import com.Projeto.SistemaFinanceiro.domain.model.Lancamento;

import java.math.BigDecimal;
import java.util.Date;

public record DadosListagemLancamento(
        Long id,
        String descricao,
        Date dataVencimento,
        BigDecimal valor
) {

    public DadosListagemLancamento(Lancamento lancamento) {
        this(
                lancamento.getId(),
                lancamento.getDescricao(),
                lancamento.getDataVencimento(),
                lancamento.getValor()
        );
    }
}
