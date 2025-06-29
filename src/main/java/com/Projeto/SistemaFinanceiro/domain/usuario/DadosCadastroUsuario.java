package com.Projeto.SistemaFinanceiro.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank(message = "Login é Obrigátorio!!!")
        String login,

        @NotBlank(message = "Senha é Obrigátorio!!!")
        String senha) {
}
