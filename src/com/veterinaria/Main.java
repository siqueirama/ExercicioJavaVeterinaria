package com.veterinaria;


import com.veterinaria.model.*;
import com.veterinaria.services.AnimalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ParseException {

        //--------------------------- Instanciando Animais(pacientes)

        Animal cao = new AnimalDomestico(123, "cachorro","fila","preto", LocalDate.now(),"thor");
        Animal gato = new AnimalDomestico(456, "gato","siames","cinza",LocalDate.now(),"aranha");
        Animal cavalo = new AnimalFazenda(789, "cavalo","alazão","marrom",LocalDate.now(),"gruth");
        Animal vaca = new AnimalFazenda(741, "vaca","nelori","branca",LocalDate.now(),"mimosa");

        //Lista de Animais
        List<Animal> cadastroAnimais = new ArrayList<>();
        cadastroAnimais.add(cao);
        cadastroAnimais.add(gato);
        cadastroAnimais.add(cavalo);
        cadastroAnimais.add(vaca);



        //--------------------------- Instanciando Proprietario do animal

        AnimalProprietario animalProprietario = new AnimalProprietario("78945612312","Jose",
                "Silva", LocalDate.now(), "rua 13", "987456321", cao);
        AnimalProprietario animalProprietario1 = new AnimalProprietario("14745612456",
                "Joao", "Souza", LocalDate.now(), "rua 15", "897456328", gato);
        AnimalProprietario animalProprietario2 = new AnimalProprietario("85245612312",
                "Pedro", "Silva", LocalDate.now(), "rua 44", "789456321", cavalo);
        AnimalProprietario animalProprietario3 = new AnimalProprietario("96345612456",
                "Caio", "Souza", LocalDate.now(), "rua 55", "963456328", vaca);

        //Lista de proprietarios
        List<AnimalProprietario> proprietarioCadastro = new ArrayList<>();
        proprietarioCadastro.add(animalProprietario);
        proprietarioCadastro.add(animalProprietario1);
        proprietarioCadastro.add(animalProprietario2);
        proprietarioCadastro.add(animalProprietario3);



        //-------------------------- Instanciando Medico ----------------------------

        Medico medico1 = new Medico("41423423495", "rogerio", "silva", 12345, "AnimalFazenda" );
        Medico medico2 = new Medico("41423655495", "carlos", "santos", 23456, "AnimalDomestico" );


        //Lista de médicos
        List<Medico> listaMedico = new ArrayList<>();
        listaMedico.add(medico1);
        listaMedico.add(medico2);



        //------------------------------- CRIANDO CONSULTA -----------

        Cosulta cosulta01 = new Cosulta(LocalDateTime.of(2021, 9, 15, 5, 12),  "Dor", "Infeccao", "Analgesico", medico1, cao );
        Cosulta cosulta02 = new Cosulta(LocalDateTime.of(2021, 9, 15, 4, 57), "Dor Forte", "Infeccao", "Analgesico", medico1, cao );

        Cosulta cosulta03 = new Cosulta(LocalDateTime.of(2021, 9, 13, 2, 3), "febre", "Bacteria", "Remedio na veia", medico1, gato );
        Cosulta cosulta04 = new Cosulta(LocalDateTime.of(2021, 9, 12, 12, 5), "febre", "Bacteria", "Remedio na veia", medico1, gato );
        Cosulta cosulta07 = new Cosulta(LocalDateTime.of(2021, 9, 11, 4, 6), "febre", "Bacteria", "Remedio na veia", medico1, gato );

        Cosulta cosulta05 = new Cosulta(LocalDateTime.of(2021, 9, 11, 2, 12), "Dor estomacal", "Verme", "Vacina de Verme", medico2, cavalo );
        Cosulta cosulta06 = new Cosulta(LocalDateTime.of(2021, 9, 15, 14, 12), "Dores na teta", "Infeccao", "Aplicacao de massagem", medico2, vaca );


        //lista de CONSULTAS de pacientes
        List<Cosulta> cosultasPaciente = new ArrayList<>();
        cosultasPaciente.add(cosulta01);
        cosultasPaciente.add(cosulta02);
        cosultasPaciente.add(cosulta03);
        cosultasPaciente.add(cosulta04);
        cosultasPaciente.add(cosulta05);
        cosultasPaciente.add(cosulta06);
        cosultasPaciente.add(cosulta07);






        // ------------------------------ARQUIVO TXT ----------------------------------------
        //Escrevendo lista de consultas dentro do arquivo consultas1
        DAOcosulta daoCosulta = new DAOcosulta("cosultas1.txt");
        daoCosulta.salva(cosultasPaciente);

        // Escrevendo lista de medico dentro do arquivo medicos1
        DAOmedico daOmedico = new DAOmedico("medicos1.txt");
        daOmedico.salva(listaMedico);

        //Escrevendo lista de proprietario no arquivo proprietario1.txt
        DAOAnimalProprietario animalProprietarioDao = new DAOAnimalProprietario("proprietario1.txt");
        animalProprietarioDao.salva(proprietarioCadastro);

        //Escrevendo lista de  animal no arquivo animal1.txt
        DAOAnimal animalDao = new DAOAnimal("animal1.txt");
        animalDao.salva(cadastroAnimais);




        // vendo a lista de  todas consultas de um determinado paciente e ordenada com a data decrescente
        System.out.println("------------- CONSULTAS DE CADA PACIENTE ---------------------");
        cosultasPaciente.stream()
                .filter(cosulta -> cosulta.getAnimal().getNumeroDoPaciente() == 456)
                .sorted(Comparator.comparing(Cosulta::getDataHora).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);



        // vendo a lista de todas consultas de um determinado médico
        System.out.println("------------- CONSULTAS DE CADA MÉDICO ---------------------"+ "\n");
        cosultasPaciente.stream()
                .filter(cosulta -> cosulta.getMedico().getNomeMedico().equalsIgnoreCase("rogerio"))

                .collect(Collectors.toList())
                .forEach(System.out::println);


        // vendo a lista de todas consultas marcadas em um mesmo dia
        System.out.println("------------- CONSULTAS MARCADAS EM UM MESMO DIA ---------------------" + "\n");
        cosultasPaciente.stream()
                .filter(cosulta -> cosulta.getDataHora().equals(LocalDate.of(2021,9, 15)) )


                .sorted(Comparator.comparing(Cosulta::getDataHora))
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
}
