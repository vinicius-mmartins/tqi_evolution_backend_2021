package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo;

import com.github.viniciusmmartins.tqi_evolution_v2.cliente.Cliente;
import com.github.viniciusmmartins.tqi_evolution_v2.cliente.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final ClienteRepository clienteRepository;

    public String solicitarEmprestimo(Emprestimo emprestimo) {
        emprestimoRepository.save(emprestimo);
        return null;
    }

    public List<Emprestimo> getEmprestimosByClienteId() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userLogin = ((UserDetails)principal).getUsername();
        Cliente cliente = clienteRepository.findClienteByEmail2(userLogin);


        return emprestimoRepository.findEmprestimoByClienteId(cliente.getClienteId());
    }
    // TODO: esse find funciona, mas preciso conferir se o id do usuario logado é igual do emprestimo pra n mostrar os de outros clientes


    public Emprestimo getForDetalhes() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userLogin = ((UserDetails) principal).getUsername();
        Cliente cliente = clienteRepository.findClienteByEmail2(userLogin);


        return emprestimoRepository.findForDetalhes(cliente.getClienteId());
    }    //nao consegui usar com o mapping pro DetalhesResponse
}
