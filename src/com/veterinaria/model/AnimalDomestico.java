package com.veterinaria.model;

import java.time.LocalDate;

public class AnimalDomestico extends Animal{

    public AnimalDomestico(int numeroDoPaciente, String especie, String raca, String cor, LocalDate dataDeNascimento, String nome) {
        super(numeroDoPaciente, especie, raca, cor, dataDeNascimento, nome);
    }
}
