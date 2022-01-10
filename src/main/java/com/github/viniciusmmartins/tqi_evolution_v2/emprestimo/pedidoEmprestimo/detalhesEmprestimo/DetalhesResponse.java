package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.pedidoEmprestimo.detalhesEmprestimo;

import com.github.viniciusmmartins.tqi_evolution_v2.cliente.Cliente;
import com.github.viniciusmmartins.tqi_evolution_v2.emprestimo.Emprestimo;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DetalhesResponse {

    private Long emprestimoId;
    private Long valor;
    private Integer quantidadeDeParcelas;
    private LocalDate dataPrimeiraParcela;
    private String email;
    private Long renda;


    public DetalhesResponse(Emprestimo emprestimo) {
        this.setEmprestimoId(emprestimo.getEmprestimoId());
        this.setValor(emprestimo.getValor());
        this.setQuantidadeDeParcelas(emprestimo.getQuantidadeDeParcelas());
        this.setDataPrimeiraParcela(emprestimo.getDataPrimeiraParcela());
        this.setEmail(emprestimo.getCliente().getEmail());
        this.setRenda(emprestimo.getCliente().getRenda());
    }

    /*
    public DetalhesResponse(Emprestimo emprestimo, Cliente cliente) {
        this.setEmprestimoId(emprestimo.getEmprestimoId());
        this.setValor(emprestimo.getValor());
        this.setQuantidadeDeParcelas(emprestimo.getQuantidadeDeParcelas());
        this.setDataPrimeiraParcela(emprestimo.getDataPrimeiraParcela());
        this.setEmail(cliente.getEmail());
        this.setRenda(cliente.getRenda());
    }*/
}
