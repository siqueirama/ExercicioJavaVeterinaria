package com.veterinaria.model;

import lombok.Data;

import java.util.List;

@Data
public class Medico {
    private long cpfMedico;
    private String nomeMedico;
    private String sobrenomeMedico;
    private long numeroRegistro;
    private String especielidade;

    public Medico(long cpfMedico, String nomeMedico, String sobrenomeMedico, long numeroRegistro, String especielidade) {
        this.cpfMedico = cpfMedico;
        this.nomeMedico = nomeMedico;
        this.sobrenomeMedico = sobrenomeMedico;
        this.numeroRegistro = numeroRegistro;
        this.especielidade = especielidade;
    }

    public Medico() {
    }


    public void cadastrarMedico(int i, String luis, String fleury, String s, String veterinario) {

    }

    @Override
    public String toString() {
        return cpfMedico +" " + nomeMedico + " " + sobrenomeMedico + " " + numeroRegistro + " "+ especielidade;
    }
}
