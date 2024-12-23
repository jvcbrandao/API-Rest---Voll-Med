package com.med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(

        @NotBlank
        String rua,
        String numero,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String estado) {
}
