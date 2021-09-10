package com.veterinaria.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Cosulta extends Medico{
    private LocalDate dataHora;
    private String motivo;
    private String diagnostico;
    private String tratamento;


    public Cosulta(long cpfMedico, LocalDate dataHora, String motivo, String diagnostico, String tratamento) {
        super(cpfMedico);
        this.dataHora = dataHora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
    }

}
