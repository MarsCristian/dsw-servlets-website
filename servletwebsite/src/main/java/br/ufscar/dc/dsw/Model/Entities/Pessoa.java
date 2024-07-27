package br.ufscar.dc.dsw.Model.Entities;

import java.util.Objects;
import java.util.UUID;

abstract public class Pessoa {

    public String id;
    private String nome;
    private String email;
    private String senha;

    public Pessoa( String id, String senha, String email, String nome) {
        this.senha = senha;
        this.email = email;
        this.nome = nome;
        this.id = id;
    }

    public Pessoa(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

//    public void GenerateID( ) {
//        if(Objects.equals(this.id, "")){
//            this.id = (UUID.randomUUID().toString().substring(0, 10));
//        }
//
//    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        senha = senha;
    }
}

