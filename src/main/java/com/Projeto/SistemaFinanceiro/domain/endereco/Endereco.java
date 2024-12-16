package com.Projeto.SistemaFinanceiro.domain.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank; // Adicione esta linha


@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class Endereco {
    @NotNull
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @NotNull
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato XXXXX-XXX")
    private String cep;

    private String cidade;

    @NotBlank(message = "Estado (UF) não deve estar em branco")
    private String estado;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.estado = dados.estado();
    }

    public void atualizarInformacoes(DadosEndereco dados) {

        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();

            if (dados.cep() != null) {
                this.cep = dados.cep();
            }
            if (dados.cidade() != null) {
                this.cidade = dados.cidade();
            }
            if (dados.estado() != null) {
                this.estado = dados.estado();
            }
        }
    }
}
