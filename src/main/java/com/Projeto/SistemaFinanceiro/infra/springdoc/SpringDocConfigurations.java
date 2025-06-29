package com.Projeto.SistemaFinanceiro.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("sistema_financeiro API")
                        .description("API Rest da aplicação sistema_financeiro, contendo as funcionalidades de CRUD de pessoas," +
                                " lançamentos e categorias. Além disso, permite o acompanhamento de diferentes categorias de" +
                                " receitas e despesas, o registro de informações de pessoas envolvidas nas transações " +
                                "(quem pagou, quem recebeu, etc.),")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@sistema_financeiro"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://sistema_financeiro/api/licenca")));
    }

}
