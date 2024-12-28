package com.med.voll.api.domain.consulta.validacoes.agendamento;

import com.med.voll.api.domain.ValidacaoException;
import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();

        var agora = LocalDateTime.now();

        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos<30){
            throw new ValidacaoException("Favor agendar com no mínimo 30 minutos de antecedência ");
        }

    }
}
