package com.projetAngular.stylos.repo;

import com.projetAngular.stylos.model.Stylo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StyloRepo extends JpaRepository<Stylo, Long> {

    Optional<Stylo> findStyloById(Long StyloID);
}
