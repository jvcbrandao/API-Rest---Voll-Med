package com.med.voll.api.controller;


import com.med.voll.api.domain.consulta.CancelamentoConsulta;
import com.med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import com.med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoDeConsulta;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cancelar")
@SecurityRequirement(name = "bearer-key")
public class CancelarController {

    @Autowired
    private CancelamentoConsulta cancelamentoConsulta;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> cancelamento;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosCancelamentoConsulta dados){
        var dto =  cancelamentoConsulta.cancelar(dados);
        return ResponseEntity.ok(dto);

    }
}
