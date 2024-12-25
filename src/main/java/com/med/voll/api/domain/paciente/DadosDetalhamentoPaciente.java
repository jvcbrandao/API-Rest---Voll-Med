package com.med.voll.api.domain.paciente;

import com.med.voll.api.domain.endereco.Endereco;
import com.med.voll.api.domain.paciente.Paciente;

public record DadosDetalhamentoPaciente(String nome,
                                        String email,
                                        String telefone,
                                        String cpf,
                                        Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf(),
                paciente.getEndereco());
    }
}