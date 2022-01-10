package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo;

import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.Emprestimo;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EmprestimoResponse {

    private Long emprestimoId;
    private Long valor;
    private Integer quantidadeDeParcelas;

    public EmprestimoResponse(Emprestimo emprestimo) {
        this.setEmprestimoId(emprestimo.getEmprestimoId());
        this.setValor(emprestimo.getValor());
        this.setQuantidadeDeParcelas(emprestimo.getQuantidadeDeParcelas());
    }
}
