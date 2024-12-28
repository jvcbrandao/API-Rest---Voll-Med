package com.med.voll.api.domain.consulta.validacoes.cancelamento;

import com.med.voll.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void cancelar(DadosCancelamentoConsulta dados);
}
