package com.veterinaria.model;

import lombok.Data;

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
}
