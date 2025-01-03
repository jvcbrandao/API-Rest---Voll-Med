package com.med.voll.api.domain.medico;

import com.med.voll.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String telefone,
        String nome,
        DadosEndereco endereco) {



}
