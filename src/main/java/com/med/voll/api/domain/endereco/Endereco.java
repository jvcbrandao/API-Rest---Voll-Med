package com.med.voll.api.domain.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class Endereco {
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name="cep")
    private String cep;
    @Column(name = "numero")
    private String numero;
    @Column(name="complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;


    public Endereco(){}

    public Endereco(DadosEndereco endereco) {
        this.logradouro=endereco.logradouro();
        this.bairro=endereco.bairro();
        this.cidade= endereco.cidade();
        this.uf= endereco.uf();
        this.numero=endereco.numero();
        this.cep=endereco.cep();
        this.complemento=endereco.complemento();
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if(endereco.logradouro()!=null){
            this.logradouro = endereco.logradouro();
        }

        if(endereco.bairro()!=null){
            this.bairro = endereco.bairro();
        }

        if(endereco.cidade()!=null){
            this.cidade = endereco.cidade();
        }

        if(endereco.uf()!=null){
            this.uf = endereco.uf();
        }

    }

    public void atualizarCadastro(DadosEndereco dados) {
            if (dados.logradouro() != null) {
                this.logradouro = dados.logradouro();
            }
            if (dados.bairro() != null) {
                this.bairro = dados.bairro();
            }
            if (dados.cep() != null) {
                this.cep = dados.cep();
            }
            if (dados.uf() != null) {
                this.uf = dados.uf();
            }
            if (dados.cidade() != null) {
                this.cidade = dados.cidade();
            }
            if (dados.numero() != null) {
                this.numero = dados.numero();
            }
            if (dados.complemento() != null) {
                this.complemento = dados.complemento();
            }
    }
}
