package com.med.voll.api.domain.consulta.validacoes.agendamento;

import com.med.voll.api.domain.ValidacaoException;
import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var antesAberturaDaClinica = dataConsulta.getHour()<7;

        var depoisDoEncerramentoDaClinica =dataConsulta.getHour()>18;

        if(domingo || antesAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Favor agendar dentro do horário de funcionamento! ");
        }

    }
}
