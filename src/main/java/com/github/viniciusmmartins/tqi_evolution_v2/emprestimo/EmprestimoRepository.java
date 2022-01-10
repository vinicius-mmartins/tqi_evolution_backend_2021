package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Optional<Emprestimo> findById(Long emprestimoId); //vai ser por clienteid, ou daqui ou do cliente dando um join

    // de cima vai ser apagado se o de baixo der certo, e anotar o de baixo com @Query

    @Query("SELECT cid FROM Emprestimo cid JOIN FETCH cid.cliente")
    List<Emprestimo> findEmprestimoByClienteId(@Param("clienteId") Long clienteId); //encontrar o emprestimo pelo id de cliente na tabela emprestimo

}
