package com.Projeto.SistemaFinanceiro.domain.atualizacao;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCategoria(
        @NotNull
        Long id,
        String nome
) {
}
