package com.Projeto.SistemaFinanceiro.infra.security;

import com.Projeto.SistemaFinanceiro.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;



    public String gerarToken(Usuario usuario){
        System.out.println(secret);
        try {
            var algoritmo  = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Sist.finan")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw  new RuntimeException(
                    "Erro ao gerar o token jwt ", exception);
        }
    }


    public String getSubject(String tokenJWT) {

        try {
            var algoritmo = Algorithm.HMAC256(secret);
            System.out.println("Token recebido: " + tokenJWT);
            System.out.println("Secret usado: " + secret);
            return JWT.require(algoritmo)
                    .withIssuer("API Sist.finan")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }


    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).
                toInstant(ZoneOffset.of("-03:00"));

    }

}
