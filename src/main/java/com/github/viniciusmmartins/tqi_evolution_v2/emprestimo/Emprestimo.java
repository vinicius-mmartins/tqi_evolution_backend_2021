package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo;

import com.github.viniciusmmartins.tqi_evolution_v2.cliente.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "emprestimo")
public class Emprestimo {

    @Id
    @SequenceGenerator(
            name = "emprestimo_sequence",
            sequenceName = "emprestimo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "emprestimo_sequence"
    )
    private Long emprestimoId;
    private Long valor;
    private LocalDate dataDoPedido;
    private LocalDate dataPrimeiraParcela;
    private Integer quantidadeDeParcelas;

    @ManyToOne(targetEntity = Cliente.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Emprestimo(Long valor, LocalDate dataDoPedido, LocalDate dataPrimeiraParcela, Integer quantidadeDeParcelas, Cliente cliente) {
        this.valor = valor;
        this.dataDoPedido = dataDoPedido;
        this.dataPrimeiraParcela = dataPrimeiraParcela;
        this.quantidadeDeParcelas = quantidadeDeParcelas;
        this.cliente = cliente;
    }
}
