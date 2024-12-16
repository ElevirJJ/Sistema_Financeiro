package com.Projeto.SistemaFinanceiro.domain.atualizacao;
import com.Projeto.SistemaFinanceiro.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(

        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco) {

}