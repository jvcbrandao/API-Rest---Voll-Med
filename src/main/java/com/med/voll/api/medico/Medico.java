package com.med.voll.api.medico;

import com.med.voll.api.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="medico")
@Table(name="medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String nome;

    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo;


    public Medico(DadosCadastroMedico dados){
        this.ativo=true;
        this.nome=dados.nome();
        this.email=dados.email();
        this.telefone=dados.telefone();
        this.crm= dados.crm();
        this.especialidade=dados.especializacao();
        this.endereco=new Endereco(dados.endereco());
    }
    public Medico(Long id, String nome, String email, String crm, String crmed, Especialidade especializacao, Endereco endereco) {
        this.id=null;
        this.nome=nome;
        this.email=email;
        this.crm=crm;
        this.especialidade=especializacao;
        this.endereco=endereco;

    }

    public Medico(Object id, String nome, String email, String crm, Especialidade especializacao, Endereco endereco) {
        this.id=null;
        this.nome=nome;
        this.email=email;
        this.crm=crm;
        this.especialidade=especializacao;
        this.endereco=endereco;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {

        if(dados.nome()!=null){
            this.nome= dados.nome();
        }
        if(dados.telefone()!=null){
            this.telefone = dados.telefone();
        }

        if(dados.endereco()!=null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo=false;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}