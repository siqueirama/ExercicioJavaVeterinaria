package com.veterinaria;

import com.veterinaria.model.*;
import com.veterinaria.services.AnimalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse("08/08/2016",formatter);

          Animal cao = new Animal(123, "cachorro","fila","preto",ld,"thor");
          Animal gato = new Animal(456, "gato","siames","cinza",ld,"aranha");
          Animal cavalo = new Animal(789, "cavalo","alazão","marrom",ld,"gruth");
          Animal vaca = new Animal(741, "vaca","nelori","branca",ld,"mimosa");

          ArrayList<Animal> cadastroDomesticos= new ArrayList<>();
          cadastroDomesticos.add(cao);
          cadastroDomesticos.add(gato);

        for ( Animal a : cadastroDomesticos) {
            System.out.println(a.toString());
        }

          ArrayList<Animal> cadastroFazenda= new ArrayList<>();
          cadastroFazenda.add(cavalo);
          cadastroFazenda.add(vaca);

          AnimalProprietario animalProprietario = new AnimalProprietario(123,"78945612312","Jose", "Silva", ld, "rua 13", 987456321);
          AnimalProprietario animalProprietario1 = new AnimalProprietario(456,"78945612312","Joao", "Souza", ld, "rua 15", 897456328);

        Cosulta cosulta = new Cosulta ( 987987, ld, "carrapato", "doença do carrapato", "remedio");



         AnimalService animalService = new AnimalService();


    }
}
