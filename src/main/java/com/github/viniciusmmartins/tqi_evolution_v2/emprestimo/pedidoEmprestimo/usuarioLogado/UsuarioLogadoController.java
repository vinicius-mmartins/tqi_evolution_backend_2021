package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo.usuarioLogado;

import com.github.viniciusmmartins.tqi_evolution_v2.cliente.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
@AllArgsConstructor
public class UsuarioLogadoController {


    @GetMapping(path = "logado")
    public Object clienteLogado(@UsuarioLogado Cliente cliente){
        return cliente;
    }
}

//realmente retorna tudo do cliente como um objeto no return cliente;