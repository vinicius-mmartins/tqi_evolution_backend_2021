package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo;

import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo.usuarioLogado.UsuarioLogado;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v2")
@AllArgsConstructor
public class EmprestimoRequestController {

    private final EmprestimoRequestService emprestimoRequestService;

    @PostMapping(path = "solicitar-emprestimo")
    public String solicitarEmprestimo(@RequestBody EmprestimoRequest emprestimoRequest){
        emprestimoRequestService.pedidoDeEmprestimo(emprestimoRequest);
        return "Emprestimo solicitado, entraremos em contato após feita a análise.";
    }

}
