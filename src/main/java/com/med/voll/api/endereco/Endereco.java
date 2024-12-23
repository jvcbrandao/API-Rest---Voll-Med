package com.med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(String rua, String bairro, String cidade, String estado) {
        this.rua=rua;
        this.bairro=bairro;
        this.cidade=cidade;
        this.estado=estado;

    }

    public Endereco(DadosEndereco endereco) {
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if(endereco.rua()!=null){
            this.rua = endereco.rua();
        }

        if(endereco.bairro()!=null){
            this.bairro = endereco.bairro();
        }

        if(endereco.cidade()!=null){
            this.cidade = endereco.cidade();
        }

        if(endereco.estado()!=null){
            this.estado = endereco.estado();
        }

    }
}
