package com.Projeto.SistemaFinanceiro.domain.cadastro;

import com.Projeto.SistemaFinanceiro.domain.model.Categoria;
import com.Projeto.SistemaFinanceiro.domain.model.Pessoa;
import com.Projeto.SistemaFinanceiro.domain.model.TipoLancamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public record DadosCadastroLancamento(
        Long id,

        @NotBlank
        @Size(max = 100)
        String descricao,

        @NotNull
        Date dataVencimento,
        @NotNull
        Date dataPagamento,

        @NotNull
        @DecimalMin("0.0")
        BigDecimal valor,

        @Size(max = 255)
        String observacao,

        @NotNull
        @Valid
        Pessoa pessoa,

        @NotNull
        @Valid
        Categoria categoria,

        @NotNull
        TipoLancamento tipoLancamento
) {
}
