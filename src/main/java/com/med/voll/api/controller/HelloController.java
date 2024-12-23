package com.med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class HelloController {

    @GetMapping
    public String olaMundo(){
        return "Olá mundo! ";
    }
}
