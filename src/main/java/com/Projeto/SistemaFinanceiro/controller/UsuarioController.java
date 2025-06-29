package com.Projeto.SistemaFinanceiro.controller;

import com.Projeto.SistemaFinanceiro.domain.repository.UsuarioRepository;
import com.Projeto.SistemaFinanceiro.domain.usuario.DadosCadastroUsuario;
import com.Projeto.SistemaFinanceiro.domain.usuario.DadosDetalhamentoUsuario;
import com.Projeto.SistemaFinanceiro.domain.usuario.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cadastros")
public class UsuarioController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroUsuario dados,
                                   UriComponentsBuilder uriBuilder){

        if (repository.findByLogin(dados.login()) !=null ){
            return ResponseEntity.badRequest()
                    .body("Login já Cadastrado!!!");
        }

        var senhaCriptografada =passwordEncoder.encode(dados.senha());
        var  usuario = new Usuario(dados.login(), senhaCriptografada);
        repository.save(usuario);



        var uri = uriBuilder.path("/cadastros/{id}")
                .buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri)
                .body(new DadosDetalhamentoUsuario(usuario));
    }

}