package com.med.voll.api.domain.consulta;

import com.med.voll.api.domain.medico.Medico;
import com.med.voll.api.domain.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="paciente_id")
    private Paciente paciente;
    private LocalDateTime data;

    public Consulta(){}

    public Consulta(Medico medico, Paciente paciente, @NotNull @Future LocalDateTime data) {
        this.medico=medico;
        this.paciente=paciente;
        this.data=data;
    }


    public Long getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getData() {
        return data;
    }
}
