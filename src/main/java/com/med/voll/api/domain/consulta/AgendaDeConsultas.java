package com.med.voll.api.domain.consulta;

import com.med.voll.api.domain.ValidacaoException;
import com.med.voll.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import com.med.voll.api.domain.medico.Medico;
import com.med.voll.api.domain.medico.MedicoRepository;
import com.med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){


        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("O id do paciente informado não existe! ");
        }
        if(dados.idMedico()!= null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("O id do médico informado não existe! ");
        }

        validadores.forEach(validar-> validar.validar(dados));
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);

        if(medico==null){
            throw new ValidacaoException("Não existe nenhum médico disponível nessa data ");
        }

        var consulta = new Consulta(medico,paciente,dados.data());
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico()!=null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if(dados.especialidade()==null){
            throw new ValidacaoException("É necessário informar o médico ou a especialidade!" );

        }



        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

}
