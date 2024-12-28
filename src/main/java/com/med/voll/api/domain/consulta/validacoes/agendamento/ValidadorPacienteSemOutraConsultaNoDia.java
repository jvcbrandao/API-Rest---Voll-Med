package com.med.voll.api.domain.consulta.validacoes.agendamento;

import com.med.voll.api.domain.ValidacaoException;
import com.med.voll.api.domain.consulta.ConsultaRepository;
import com.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia  implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados){

            var primeiroHorario = dados.data().withHour(7);
            var ultimoHorario = dados.data().withHour(18);

            var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

            if (pacientePossuiOutraConsultaNoDia){
                throw new ValidacaoException("Número máximo de consultas por dia atingido! ");
            }
    }
}
