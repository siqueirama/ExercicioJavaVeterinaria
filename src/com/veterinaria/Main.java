package com.veterinaria;

import com.veterinaria.model.*;
import com.veterinaria.services.AnimalService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse("08/08/2016",formatter);
        AnimalService animalService = new AnimalService();

          Animal cao = new Animal(123, "cachorro","fila","preto",ld,"thor");
          Animal gato = new Animal(456, "gato","siames","cinza",ld,"aranha");
          Animal cavalo = new Animal(789, "cavalo","alazão","marrom",ld,"gruth");
          Animal vaca = new Animal(741, "vaca","nelori","branca",ld,"mimosa");

          ArrayList<Animal> cadastroDomesticos= new ArrayList<>();
          cadastroDomesticos.add(cao);
          cadastroDomesticos.add(gato);

          DAOAnimal daoAnimal = new DAOAnimal();
          daoAnimal.salva(cadastroDomesticos);

          HashMap<Animal, AnimalProprietario> hashCadastro = new HashMap<>();

          ArrayList<Animal> cadastroFazenda= new ArrayList<>();
          cadastroFazenda.add(cavalo);
          cadastroFazenda.add(vaca);

          AnimalProprietario animalProprietario = new AnimalProprietario("78945612312","Jose", "Silva", ld, "rua 13", 987456321);
          AnimalProprietario animalProprietario1 = new AnimalProprietario("14745612456","Joao", "Souza", ld, "rua 15", 897456328);
          AnimalProprietario animalProprietario2 = new AnimalProprietario("85245612312","Pedro", "Silva", ld, "rua 44", 789456321);
          AnimalProprietario animalProprietario3 = new AnimalProprietario("96345612456","Caio", "Souza", ld, "rua 55", 963456328);

          hashCadastro.put(cao, animalProprietario);
          hashCadastro.put(gato, animalProprietario1);
          hashCadastro.put(cavalo, animalProprietario2);
          hashCadastro.put(vaca, animalProprietario3);


        for (Animal animalProp : hashCadastro.keySet()) {
            AnimalProprietario value = hashCadastro.get(animalProp);
            System.out.println("--------------------Dados Animal propietario-------------");
            System.out.println("Dados Animal: "+ animalProp.toString()+"\n" + "Dados Proprietario: "+value.toString());
        }

        Cosulta cosulta = new Cosulta(LocalDateTime.now(), "pata quebrada","cortar", "remedio");
        Cosulta cosulta1 = new Cosulta(LocalDateTime.now(), "orelha ferida","costurar", "remedio");
        Cosulta cosulta2 = new Cosulta(LocalDateTime.now(), "rabo cortado","saturar", "soro");
        Cosulta cosulta3 = new Cosulta(LocalDateTime.now(), "olho furado","implante", "fisio");

        HashMap<Animal, Cosulta> consulaAnima = new HashMap<>();
        consulaAnima.put(cao, cosulta);
        consulaAnima.put(gato, cosulta1);
        consulaAnima.put(cavalo, cosulta2);
        consulaAnima.put(vaca, cosulta3);

        for (Animal a : consulaAnima.keySet()) {
            cosulta = consulaAnima.get(a);
            System.out.println("--------------------Dados Consulta-------------");
            System.out.println("Dados Animal: "+ a.toString()+"\n" + "Dados Exame: "+cosulta.toString());
        }

  //      Medico medico = new Medico();
  //      medico.cadastrarMedico(1232323, "Luis", "Fleury", "4565656", "Veterinario" );

        DAOAnimal animalDao = new DAOAnimal("animal.txt");
        List<Animal> animaisCadastrados = animalDao.listagem();
        animaisCadastrados.forEach(System.out::println);
        animalDao.salva(cadastroDomesticos);

      //  arquivoUtil.fechaArquivo();

    }
}
