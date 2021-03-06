package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo;

import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.EmprestimoService;
import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo.detalhesEmprestimo.DetalhesResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v2")
@AllArgsConstructor
public class EmprestimoRequestController {

    private final EmprestimoRequestService emprestimoRequestService;
    private final EmprestimoService emprestimoService;


    @PostMapping(path = "solicitar-emprestimo")
    public String solicitarEmprestimo(@RequestBody EmprestimoRequest emprestimoRequest){
        emprestimoRequestService.pedidoDeEmprestimo(emprestimoRequest);
        return "Emprestimo solicitado, entraremos em contato após feito a análise.";
    }

    @GetMapping(path = "emprestimos")
    public List<EmprestimoResponse> getEmprestimos(){
        return emprestimoService.getEmprestimosByClienteId().stream().map(emprestimo -> {
            EmprestimoResponse emprestimoResponse = new EmprestimoResponse(emprestimo);

            return emprestimoResponse;
        }).collect(Collectors.toList());
    }
    @GetMapping(path = "emprestimos/{emprestimoId}")
    public List<DetalhesResponse> getDetalhes(@PathVariable Long emprestimoId){
        return emprestimoService.getEmprestimosByClienteId().stream().map(emprestimo -> {
            DetalhesResponse detalhesResponse = new DetalhesResponse(emprestimo);

            return detalhesResponse;
        }).collect(Collectors.toList());
    }

/*
    @GetMapping(path = "emprestimos/{emprestimoId}")
    public DetalhesResponse getDetalhes(@PathVariable Long emprestimoId){
        return emprestimoService.getForDetalhes();

    }*/   //aqui era pra listar somente 1
}
