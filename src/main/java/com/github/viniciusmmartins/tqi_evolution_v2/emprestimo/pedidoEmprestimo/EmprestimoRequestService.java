package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo;

import com.github.viniciusmmartins.tqi_evolution_v2.cliente.Cliente;
import com.github.viniciusmmartins.tqi_evolution_v2.cliente.ClienteRepository;
import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.Emprestimo;
import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.EmprestimoService;
import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo.usuarioLogado.UsuarioLogado;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class EmprestimoRequestService {
    private final EmprestimoService emprestimoService;
    private final ClienteRepository clienteRepository;

    public String pedidoDeEmprestimo(EmprestimoRequest emprestimoRequest){


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userLogin = ((UserDetails)principal).getUsername();
        Cliente cliente = clienteRepository.findClienteByEmail2(userLogin);

        return emprestimoService.solicitarEmprestimo(
                new Emprestimo(emprestimoRequest.getValor(),
                        emprestimoRequest.getDataDoPedido(),
                        emprestimoRequest.getDataPrimeiraParcela(),
                        emprestimoRequest.getQuantidadeDeParcelas(),
                        cliente)
        );
    }


/*
    public String pedidoDeEmprestimo(EmprestimoRequest emprestimoRequest, @UsuarioLogado Cliente cliente){

        return emprestimoService.solicitarEmprestimo(
                new Emprestimo(emprestimoRequest.getValor(),
                        emprestimoRequest.getDataDoPedido(),
                        emprestimoRequest.getDataPrimeiraParcela(),
                        emprestimoRequest.getQuantidadeDeParcelas(),
                        cliente)
        );
    }
*/

}
