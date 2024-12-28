package com.med.voll.api.domain.consulta.validacoes.cancelamento;


import com.med.voll.api.domain.ValidacaoException;
import com.med.voll.api.domain.consulta.ConsultaRepository;
import com.med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class CancelamentoAntecedencia implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void cancelar(DadosCancelamentoConsulta dados){

        var dataConsulta = consultaRepository.findById(dados.id());

        if(dataConsulta.isEmpty()){
            throw new ValidacaoException("Não foi encontrada nenhuma consulta com o id informado! ");
        }
        LocalDateTime agora = LocalDateTime.now();

        LocalDateTime consulta = dataConsulta.get().getData();

        var diferencahoras = Duration.between(agora,consulta).toHours();

        if(diferencahoras<24){
            throw new ValidacaoException("Favor cancelar com no mínimo 24 horas de antecedência ");
        }

    }
}
