package com.Projeto.SistemaFinanceiro.controller;

import com.Projeto.SistemaFinanceiro.domain.atualizacao.DadosAtualizacaoLancamento;
import com.Projeto.SistemaFinanceiro.domain.cadastro.DadosCadastroLancamento;
import com.Projeto.SistemaFinanceiro.domain.detalhamento.DadosDetalhamentoLancamento;
import com.Projeto.SistemaFinanceiro.domain.detalhamento.DadosDetalhamentoPessoa;
import com.Projeto.SistemaFinanceiro.domain.listagem.DadosListagemLancamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.Projeto.SistemaFinanceiro.domain.model.Lancamento;
import com.Projeto.SistemaFinanceiro.domain.repository.LancamentoRepository;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLancamento dados, UriComponentsBuilder uriBuilder) {
        var lancamento = new Lancamento(dados);
        lancamentoRepository.save(lancamento);
        var uri = uriBuilder.path("/lancamentos/{id}").buildAndExpand(lancamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoLancamento(lancamento));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLancamento>>
    listar (@PageableDefault(size = 10, sort = {"descricao"}) Pageable
                    paginacao ){
        var page = lancamentoRepository.findByAtivoTrue(paginacao).map(DadosListagemLancamento::new);
        return ResponseEntity.ok(page);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Lancamento> buscarLancamentoPorId(@PathVariable Long id) {
//        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
//        return lancamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLancamento dados){
        var lancamento = lancamentoRepository.getReferenceById(dados.id());
        lancamento.atualizarInformacoesLancamento(dados);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var lancamento = lancamentoRepository.getReferenceById(id);
        lancamento.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var lancamento = lancamentoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

}
