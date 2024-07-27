package br.ufscar.dc.dsw.Model.Entities;

import java.util.UUID;

public class Paciente extends Pessoa {

    private String cpf;
    private String telefone;
    private String sexo;
    private String dataNascimento;

    public Paciente(String id, String senha, String email, String nome, String cpf, String telefone, String sexo, String dataNascimento) {
        super(id, senha, email, nome);
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;

    }

    public Paciente(String id) {
        super(id);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
