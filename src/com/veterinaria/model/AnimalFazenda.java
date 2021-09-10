package com.veterinaria.model;

import java.time.LocalDate;

public class AnimalFazenda extends Animal{
    public AnimalFazenda(int numeroDoPaciente, String especie, String raca, String cor, LocalDate dataDeNascimento, String nome) {
        super(numeroDoPaciente, especie, raca, cor, dataDeNascimento, nome);
    }
}
