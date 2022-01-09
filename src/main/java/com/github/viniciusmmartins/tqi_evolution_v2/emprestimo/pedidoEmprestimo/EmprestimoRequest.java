package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class EmprestimoRequest {

    private final Long valor;
    private final LocalDate dataDoPedido;
    private final LocalDate dataPrimeiraParcela;
    private final Integer quantidadeDeParcelas;

}
