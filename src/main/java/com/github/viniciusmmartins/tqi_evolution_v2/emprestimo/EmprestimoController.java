package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2")
@AllArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

/*    @PostMapping(path = "solicitar-emprestimo")
    public String solicitarEmprestimo(@RequestBody Emprestimo emprestimo){
        emprestimoService.solicitarEmprestimo(emprestimo);
        return "Emprestimo solicitado, entraremos em contato após feita a análise.";
    }*/

   /* @GetMapping(path = "emprestimos")
    public List<Emprestimo> getEmprestimos(){          //nao sei se aqui e no serviço vai ser optional ou lis ou page ou sla
        return emprestimoService.getEmprestimos();
    }*/
}
