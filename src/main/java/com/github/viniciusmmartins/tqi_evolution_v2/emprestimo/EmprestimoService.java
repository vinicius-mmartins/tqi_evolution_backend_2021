package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    public String solicitarEmprestimo(Emprestimo emprestimo) {
        emprestimoRepository.save(emprestimo);
        return null;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimoRepository.findAll();
    }
}
