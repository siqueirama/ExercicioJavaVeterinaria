package com.veterinaria.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Cosulta {
    private LocalDateTime dataHora;
    private String motivo;
    private String diagnostico;
    private String tratamento;
    private Medico medico;
    private Animal animal;

    public Cosulta(LocalDateTime dataHora, String motivo, String diagnostico, String tratamento, Medico medico, Animal animal) {
        this.dataHora = dataHora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
        this.medico = medico;
        this.animal = animal;
    }

    public Cosulta(LocalDateTime parse, String campo, String campo1, String campo2, String campo3, String campo4) {
    }


    @Override
    public String toString() {
        return
                "Data da Consulta: " + dataHora +
                ", motivo: " + motivo +
                ", diagnostico: " + diagnostico +
                ", tratamento: " + tratamento + "\n" +
                "medico associado: " + medico + "\n" +
                "animal associado: " + animal
                ;
    }
}
