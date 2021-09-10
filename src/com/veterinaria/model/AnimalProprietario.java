package com.veterinaria.model;

import lombok.Data;

import java.time.LocalDate ;

@Data
public class AnimalProprietario extends Animal{

    private String cpfProprietario;
    private String nomeProprietario;
    private String sobrenomeProprietario;
    private LocalDate dataNascimentoProprietario;
    private String endereco;
    private long telefone;




    public AnimalProprietario( int numeroDoPaciente,String cpfProprietario, String nomeProprietario, String sobrenomeProprietario, LocalDate dataNascimentoProprietario, String endereco, long telefone) {
        super(numeroDoPaciente);

        this.cpfProprietario = cpfProprietario;
        this.nomeProprietario = nomeProprietario;
        this.sobrenomeProprietario = sobrenomeProprietario;
        this.dataNascimentoProprietario = dataNascimentoProprietario;
        this.endereco = endereco;
        this.telefone = telefone;

    }
}
