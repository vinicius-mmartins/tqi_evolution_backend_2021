package com.github.viniciusmmartins.tqi_evolution_v2.cliente.cadastro;

import com.github.viniciusmmartins.tqi_evolution_v2.cliente.Cliente;
import com.github.viniciusmmartins.tqi_evolution_v2.cliente.ClienteService;
import com.github.viniciusmmartins.tqi_evolution_v2.security.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastroService {

    private final ClienteService clienteService;

    public String cadastro(CadastroRequest cadastroRequest) {

        // TODO: aqui poderia colocar pra validar email mas não vou fazer isso por enquanto


        return clienteService.cadastrarCliente(
                new Cliente(cadastroRequest.getNome(),
                        cadastroRequest.getEmail(),
                        cadastroRequest.getCPF(),
                        cadastroRequest.getRG(),
                        cadastroRequest.getEndereço(),
                        cadastroRequest.getRenda(),
                        cadastroRequest.getSenha(),
                        UserRole.USER
                )
        );
    }
}
