package com.github.viniciusmmartins.tqi_evolution_v2.cliente.cadastro;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v2/cadastro")
@AllArgsConstructor
public class CadastroController {

    private CadastroService cadastroService;

    @PostMapping
    public String cadastro(@RequestBody CadastroRequest cadastroRequest){
        return cadastroService.cadastro(cadastroRequest);
    }

}
