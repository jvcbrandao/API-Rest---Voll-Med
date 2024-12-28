package com.med.voll.api.controller;
import com.med.voll.api.domain.medico.DadosCadastroMedico;
import com.med.voll.api.domain.medico.DadosDetalhamentoMedico;
import com.med.voll.api.domain.medico.Medico;
import com.med.voll.api.domain.paciente.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
        var paciente  = new Paciente(dados);

        pacienteRepository.save(paciente);

        var  uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));

    }



    @GetMapping
    public ResponseEntity<List<DadosListagemPaciente>> listar(){

        var page =  pacienteRepository.findAllByAtivoTrue().stream().map(DadosListagemPaciente::new).toList();

        return ResponseEntity.ok(page);

    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizarCadastro(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        var dadosPaciente = pacienteRepository.getReferenceById(dados.id());
        dadosPaciente.atualizarCadastro(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(dadosPaciente));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }


}
