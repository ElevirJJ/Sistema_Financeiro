package com.Projeto.SistemaFinanceiro.controller;

import com.Projeto.SistemaFinanceiro.domain.atualizacao.DadosAtualizacaoPessoa;
import com.Projeto.SistemaFinanceiro.domain.cadastro.DadosCadastroPessoa;
import com.Projeto.SistemaFinanceiro.domain.detalhamento.DadosDetalhamentoPessoa;
import com.Projeto.SistemaFinanceiro.domain.listagem.DadosListagemPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.Projeto.SistemaFinanceiro.domain.model.Pessoa;
import com.Projeto.SistemaFinanceiro.domain.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired // é usada para injetar um objeto gerenciado pelo Spring em outra classe.
    private PessoaRepository pessoaRepository;

    @PostMapping
    @Transactional // É um método como transacional, o que significa que todas as operações
    // de banco de dados realizadas dentro dele serão tratadas como uma única transação.
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        pessoaRepository.save(pessoa);
        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPessoa>>
    listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable
                    paginacao ){
        var page = pessoaRepository.findByAtivoTrue(paginacao).map(DadosListagemPessoa::new);
        return ResponseEntity.ok(page);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
//        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
//        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoPessoa dados) {
        var pessoa = pessoaRepository.getReferenceById(id);
        pessoa.atualizarInformacoesPessoa(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var pessoa = pessoaRepository.getReferenceById(id);
        pessoa.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var pessoa = pessoaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoa(pessoa));
    }
}
