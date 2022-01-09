package com.github.viniciusmmartins.tqi_evolution_v2.cliente.cadastro;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CadastroRequest {

    private final String nome;
    private final String email;
    private final String CPF;
    private final String RG;
    private final String endereço;
    private final Long renda;
    private final String senha;

}
