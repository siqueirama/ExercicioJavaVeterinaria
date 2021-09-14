package com.veterinaria.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cosulta extends Medico{
    private LocalDateTime dataHora;
    private String motivo;
    private String diagnostico;
    private String tratamento;


    public Cosulta (LocalDateTime dataHora, String motivo, String diagnostico, String tratamento) {
        super();
        this.dataHora = dataHora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamento = tratamento;
    }

    @Override
    public String toString() {
        return dataHora + ", "+ motivo + ", "+ diagnostico +", "+ tratamento;
    }
   /*   public String consultar(){
        String consultapaciente = LocalDateTime.now() + getMotivo() + getDiagnostico() + getTratamento() + getNumeroRegistro();
        return consultapaciente;
    }*/
}
