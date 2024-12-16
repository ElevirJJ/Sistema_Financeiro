package com.Projeto.SistemaFinanceiro.domain.model;

import com.Projeto.SistemaFinanceiro.domain.endereco.Endereco;
import com.Projeto.SistemaFinanceiro.domain.cadastro.DadosCadastroPessoa;
import com.Projeto.SistemaFinanceiro.domain.atualizacao.DadosAtualizacaoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pessoa")
@Table(name = "pessoas")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Pessoa(DadosCadastroPessoa dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoesPessoa(DadosAtualizacaoPessoa dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public Endereco getEndereco() {
//        return endereco;
//    }

    public boolean isAtivo() {
        return ativo;
    }
}


