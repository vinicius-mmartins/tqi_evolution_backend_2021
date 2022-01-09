package com.github.viniciusmmartins.tqi_evolution_v2.emprestimo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Optional<Emprestimo> findById(Long emprestimoId); //vai ser por clienteid, ou daqui ou do cliente dando um join
}
