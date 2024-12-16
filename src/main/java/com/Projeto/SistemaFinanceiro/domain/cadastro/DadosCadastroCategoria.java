package com.Projeto.SistemaFinanceiro.domain.cadastro;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria(
        @NotBlank
        String nome
) {
}
