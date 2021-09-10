package com.veterinaria.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Animal {
    private int numeroDoPaciente;
    private String especie;
    private String raca;
    private String cor;
    private LocalDate dataDeNascimento;
    private String nome;

    public Animal(int numeroDoPaciente, String especie, String raca, String cor, LocalDate dataDeNascimento, String nome) {
        this.numeroDoPaciente = numeroDoPaciente;
        this.especie = especie;
        this.raca = raca;
        this.cor = cor;
        this.dataDeNascimento = dataDeNascimento;
        this.nome = nome;
    }

    public Animal(int numeroDoPaciente) {
        this.numeroDoPaciente = numeroDoPaciente;
    }


    List<Animal> animals = new ArrayList<>();

    @Override
    public String toString() {
        return numeroDoPaciente +" " + especie +" " + raca + " " + cor + " " + dataDeNascimento +" " + nome ;
    }
}

