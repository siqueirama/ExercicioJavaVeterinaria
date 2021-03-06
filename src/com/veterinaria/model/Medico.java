package com.veterinaria.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Medico {
    private String cpfMedico;
    private String nomeMedico;
    private String sobrenomeMedico;
    private long numeroRegistro;
    private String especielidade;

    public Medico(String cpfMedico, String nomeMedico, String sobrenomeMedico, long numeroRegistro, String especielidade) {
        this.cpfMedico = cpfMedico;
        this.nomeMedico = nomeMedico;
        this.sobrenomeMedico = sobrenomeMedico;
        this.numeroRegistro = numeroRegistro;
        this.especielidade = especielidade;
    }

    public Medico(String cpfMedico, String campo, String campo1, String campo2, LocalDate parse, String campo3) {
    }

    public Medico() {

    }


    public void cadastrarMedico(int i, String luis, String fleury, String s, String veterinario) {

    }

    @Override
    public String toString() {
        return "cpfMedico: " + this.cpfMedico + ", nomeMedico: " + this.nomeMedico + ", sobrenomeMedico: " + this.sobrenomeMedico + ", numeroRegistro: " + this.numeroRegistro + ", especielidade: " + this.especielidade;
    }
}
