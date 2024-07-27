package br.ufscar.dc.dsw.Model.Entities;

import java.util.UUID;

public class Medico  extends Pessoa {

    private String crm;
    private String especialidade;

    public Medico(String senha, String email, String nome, String crm, String especialidade) {
        super(senha, email, nome);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public Medico(String id) {
        super(id);
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
