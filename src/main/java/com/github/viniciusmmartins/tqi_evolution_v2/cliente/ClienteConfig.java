package com.github.viniciusmmartins.tqi_evolution_v2.cliente;

import com.github.viniciusmmartins.tqi_evolution_v2.security.UserRole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClienteConfig {

    // deixei aqui esses clientes pré cadastrados pra facilitar, por algum motivo da erro na hora de logar esses, mas
    //criando um novo com postman nao da erro. entao pra testar, faça um post com cliente

    @Bean
    CommandLineRunner commandLineRunner(ClienteRepository repository) {
        return args -> {
            Cliente ana = new Cliente(
                    "Ana",
                    "ana22k@email.com",
                    "00000000000",
                    "MG00000000",
                    "Rua dos Bobos, número 0.",
                    2000L,
                    "senha123",
                    UserRole.USER
            );

            Cliente josnelson = new Cliente(
                    "Josnelson",
                    "josnelsinho@email.com",
                    "00000000001",
                    "MG00000001",
                    "Vizinho da Ana.",
                    1100L,
                    "senha_pre_gravada_nao_encryptada",
                    UserRole.USER
            );

            repository.saveAll(
                    List.of(ana, josnelson)
            );

        };
    }

}