package com.med.voll.api.domain.paciente;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findAllByAtivoTrue();


    @Query("""
            select p.ativo
            from Paciente p
            where
            p.id =:id            
            """)
    Boolean findAtivoById(Long id);
}
