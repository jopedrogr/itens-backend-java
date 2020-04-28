package com.api.repository;

import com.api.model.Itens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItensRepository extends JpaRepository<Itens, Long> {
    Optional<Itens> findByName(String name);
}
