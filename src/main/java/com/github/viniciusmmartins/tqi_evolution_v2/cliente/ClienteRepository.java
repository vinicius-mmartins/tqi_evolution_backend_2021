package com.github.viniciusmmartins.tqi_evolution_v2.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.email = ?1")
    Optional<Cliente> findClienteByEmail(String email);

    @Query("SELECT c FROM Cliente c WHERE c.email = ?1")
    Cliente findClienteByEmail2(String email);


}