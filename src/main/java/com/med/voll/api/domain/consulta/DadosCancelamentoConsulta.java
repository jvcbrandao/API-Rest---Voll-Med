package com.med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(@NotNull Long id,

                                        MotivoCancelamento motivoCancelamento) {
}
