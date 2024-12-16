package com.Projeto.SistemaFinanceiro.domain.detalhamento;

import com.Projeto.SistemaFinanceiro.domain.model.Categoria;
import com.Projeto.SistemaFinanceiro.domain.model.TipoLancamento;
import com.Projeto.SistemaFinanceiro.domain.model.Lancamento;
import com.Projeto.SistemaFinanceiro.domain.model.Pessoa;

import java.math.BigDecimal;
import java.util.Date;

public record DadosDetalhamentoLancamento(
        Long id,
        String descricao,
        Date dataVencimento,
        Date dataPagamento,
        BigDecimal valor,
        String observacao,
        Pessoa pessoa,
        Categoria categoria,
        TipoLancamento tipoLancamento
) {

    public DadosDetalhamentoLancamento(Lancamento lancamento) {
        this(
                lancamento.getId(),
                lancamento.getDescricao(),
                lancamento.getDataVencimento(),
                lancamento.getDataPagamento(),
                lancamento.getValor(),
                lancamento.getObservacao(),
                lancamento.getPessoa(),
                lancamento.getCategoria(),
                lancamento.getTipoLancamento()
        );
    }
}
