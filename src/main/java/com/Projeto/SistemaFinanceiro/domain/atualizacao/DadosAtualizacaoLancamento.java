package com.Projeto.SistemaFinanceiro.domain.atualizacao;

import com.Projeto.SistemaFinanceiro.domain.model.Categoria;
import com.Projeto.SistemaFinanceiro.domain.model.Pessoa;
import com.Projeto.SistemaFinanceiro.domain.model.TipoLancamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public record DadosAtualizacaoLancamento(
        @NotNull
        Long id,

        @Size(max = 100)
        String descricao,

        @NotNull
        Date dataVencimento,

        Date dataPagamento,

        @Size(max = 255)
        String observacao,

        @NotNull
        Pessoa pessoa,

        @NotNull
        Categoria categoria,

        @NotNull
        TipoLancamento tipoLancamento,

        @NotNull
        BigDecimal valor
) {
}
