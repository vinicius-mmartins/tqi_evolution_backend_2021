package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo;

import com.github.viniciusmmartins.tqi_evolution_v2.cliente.Cliente;
import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.Emprestimo;
import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.EmprestimoService;
import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo.usuarioLogado.UsuarioLogado;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmprestimoRequestService {
    private final EmprestimoService emprestimoService;


    public String pedidoDeEmprestimo(EmprestimoRequest emprestimoRequest, @UsuarioLogado Cliente cliente){

        //Long clienteLogadoId = cliente.getClienteId();

        return emprestimoService.solicitarEmprestimo(
                new Emprestimo(emprestimoRequest.getValor(),
                        emprestimoRequest.getDataDoPedido(),
                        emprestimoRequest.getDataPrimeiraParcela(),
                        emprestimoRequest.getQuantidadeDeParcelas(),
                        cliente)
        );
    }


}
