package com.Projeto.SistemaFinanceiro.domain.model;

import com.Projeto.SistemaFinanceiro.domain.atualizacao.DadosAtualizacaoLancamento;
import com.Projeto.SistemaFinanceiro.domain.cadastro.DadosCadastroLancamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Lancamento")
@Table(name = "lancamentos")
@Data
@Getter
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    private BigDecimal valor;
    private String observacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoa")
    @NotNull
    @JsonIgnore
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria")
    @NotNull
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipoLancamento;

    private Boolean ativo = true;

    public Lancamento(DadosCadastroLancamento dados) {
        this.descricao = dados.descricao();
        this.dataVencimento = dados.dataVencimento();
        this.dataPagamento = dados.dataPagamento();
        this.valor = dados.valor();
        this.observacao = dados.observacao();
        this.pessoa = dados.pessoa();
        this.categoria = dados.categoria();
        this.tipoLancamento = dados.tipoLancamento();
        this.ativo = true;
    }

    public void atualizarInformacoesLancamento(DadosAtualizacaoLancamento dados) {
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.dataVencimento() != null) {
            this.dataVencimento = dados.dataVencimento();
        }
        if (dados.dataPagamento() != null) {
            this.dataPagamento = dados.dataPagamento();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();
        }
        if (dados.observacao() != null) {
            this.observacao = dados.observacao();
        }
        if (dados.pessoa() != null) {
            this.pessoa = dados.pessoa();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if (dados.tipoLancamento() != null) {
            this.tipoLancamento = dados.tipoLancamento();
        }
    }

    public void excluir() {
        this.ativo = false; // Agora isso funcionará
    }

//    public Long getId() {
//        return id;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public Date getDataVencimento() {
//        return dataVencimento;
//    }
//
//    public Date getDataPagamento() {
//        return dataPagamento;
//    }
//
//    public BigDecimal getValor() {
//        return valor;
//    }
//
//    public String getObservacao() {
//        return observacao;
//    }
//
//    public Pessoa getPessoa() {
//        return pessoa;
//    }
//
//    public Categoria getCategoria() {
//        return categoria;
//    }
//
//    public TipoLancamento getTipoLancamento() {
//        return tipoLancamento;
//    }

    public boolean isAtivo() {
        return ativo;
    }
}
