package com.Projeto.SistemaFinanceiro.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
//        @Pattern(regexp = "\\d{8}", message = "CEP deve ter 8 dígitos")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$", message = "Estado deve ter 2 letras maiúsculas")
        String estado,
        String complemento,
        String numero) {
}
