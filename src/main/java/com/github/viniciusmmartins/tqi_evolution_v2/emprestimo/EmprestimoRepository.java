package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    @Query("SELECT cid FROM Emprestimo cid JOIN FETCH cid.cliente")
    List<Emprestimo> findEmprestimoByClienteId(@Param("clienteId") Long clienteId); //encontrar o emprestimo pelo id de cliente na tabela emprestimo

    @Query("SELECT cid FROM Emprestimo cid JOIN FETCH cid.cliente")
    Emprestimo findForDetalhes(@Param("clienteId")Long clienteId);
}
