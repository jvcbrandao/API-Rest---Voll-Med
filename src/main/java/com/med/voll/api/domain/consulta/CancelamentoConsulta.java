package com.med.voll.api.domain.consulta;


import com.med.voll.api.domain.ValidacaoException;
import com.med.voll.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import com.med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import com.med.voll.api.domain.medico.MedicoRepository;
import com.med.voll.api.domain.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CancelamentoConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> cancelar;

    @Transactional
    public String cancelar(@Valid DadosCancelamentoConsulta dados) {

        if (!consultaRepository.existsById(dados.id())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        cancelar.forEach(cancelar->cancelar.cancelar(dados));

        Consulta consulta = consultaRepository.getReferenceById(dados.id());

        consultaRepository.delete(consulta);
        return "Consulta cancelada com sucesso";
    }
}
