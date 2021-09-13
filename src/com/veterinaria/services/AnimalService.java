package com.veterinaria.services;

import com.veterinaria.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {

    private List<Animal> animals = new ArrayList<>();

     //Cadastrar médicos;
    public void cadastrrMedico(){

    }

    // Cadastrar proprietários;
    public void cadastrarProprietario(){

    }

    // Cadastrar pacientes;
    public void cadastrarPaciente(Animal domestico){

        animals.add(domestico);
        System.out.println("Cadastrado!");

    }
    // Criar uma nova consulta;
    public void novaConsulta(){

    }
}
