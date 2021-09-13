package com.veterinaria.model;

import lombok.Data;

import java.time.LocalDate ;

@Data
public class AnimalProprietario{// extends Animal{

    private String cpfProprietario;
    private String nomeProprietario;
    private String sobrenomeProprietario;
    private LocalDate dataNascimentoProprietario;
    private String endereco;
    private long telefone;




    public AnimalProprietario(String cpfProprietario, String nomeProprietario, String sobrenomeProprietario, LocalDate dataNascimentoProprietario, String endereco, long telefone) {

        this.cpfProprietario = cpfProprietario;
        this.nomeProprietario = nomeProprietario;
        this.sobrenomeProprietario = sobrenomeProprietario;
        this.dataNascimentoProprietario = dataNascimentoProprietario;
        this.endereco = endereco;
        this.telefone = telefone;

    }

    @Override
    public String toString() {
        return cpfProprietario +" "+ nomeProprietario +" " + sobrenomeProprietario +" " + dataNascimentoProprietario +" " + endereco +" " + telefone;
    }
}
