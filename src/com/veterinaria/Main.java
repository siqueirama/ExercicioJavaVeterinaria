package com.veterinaria;

import com.veterinaria.model.*;
import com.veterinaria.services.AnimalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {

        //--------------------------- Instanciando Animais

        Animal cao = new Animal(123, "cachorro","fila","preto", LocalDate.now(),"thor");
        Animal gato = new Animal(456, "gato","siames","cinza",LocalDate.now(),"aranha");
        Animal cavalo = new Animal(789, "cavalo","alazão","marrom",LocalDate.now(),"gruth");
        Animal vaca = new Animal(741, "vaca","nelori","branca",LocalDate.now(),"mimosa");

        //Lista de Animais
        List<Animal> cadastroAnimais = new ArrayList<>();
        cadastroAnimais.add(cao);
        cadastroAnimais.add(gato);
        cadastroAnimais.add(cavalo);
        cadastroAnimais.add(vaca);

        //Escrevendo lista de  animal no arquivo txt
        DAOAnimal animalDao = new DAOAnimal("animal1.txt");
        animalDao.salva(cadastroAnimais);

        //--------------------------- Instanciando Proprietario do animal

        AnimalProprietario animalProprietario = new AnimalProprietario("78945612312","Jose", "Silva", LocalDate.now(), "rua 13", 987456321);
        AnimalProprietario animalProprietario1 = new AnimalProprietario("14745612456","Joao", "Souza", LocalDate.now(), "rua 15", 897456328);
        AnimalProprietario animalProprietario2 = new AnimalProprietario("85245612312","Pedro", "Silva", LocalDate.now(), "rua 44", 789456321);
        AnimalProprietario animalProprietario3 = new AnimalProprietario("96345612456","Caio", "Souza", LocalDate.now(), "rua 55", 963456328);

        //Lista de proprietario
        List<AnimalProprietario> proprietarioCadastro = new ArrayList<>();
        proprietarioCadastro.add(animalProprietario);
        proprietarioCadastro.add(animalProprietario1);
        proprietarioCadastro.add(animalProprietario2);
        proprietarioCadastro.add(animalProprietario3);

        //Escrevendo lista de proprietario no arquivo txt
        DAOAnimalProprietario animalProprietarioDao = new DAOAnimalProprietario("proprietario1.txt");
        animalProprietarioDao.salva(proprietarioCadastro);




        //-------------------------- Instanciando Medico ----------------------------

        Medico medico1 = new Medico("41423423495", "rogerio", "silva", 12345, "neuro" );
        Medico medico2 = new Medico("41423655495", "carlos", "santos", 23456, "ocular" );
        Medico medico3 = new Medico("51423423495", "vagner", "valdes", 34567, "cirurgiao" );
        Medico medico4 = new Medico("71423423495", "hugo", "silva", 45678, "oftalmo" );

        //Lista de médicos
        List<Medico> listaMedico = new ArrayList<>();
        listaMedico.add(medico1);
        listaMedico.add(medico2);
        listaMedico.add(medico3);
        listaMedico.add(medico4);

        // Escrevendo lista de medico dentro do arquivo txt
        DAOmedico daOmedico = new DAOmedico("medicos1.txt");
        daOmedico.salva(listaMedico);


        //------------------------------- Consulta -----------




        Cosulta cosulta1 = new Cosulta(LocalDateTime.now(), "Dor", "Infeccao", "Analgesico", medico1, cao );
        Cosulta cosulta2 = new Cosulta(LocalDateTime.now(), "febre", "Bacteria", "Remedio na veia", medico2, gato );
        Cosulta cosulta3 = new Cosulta(LocalDateTime.now(), "Dor estomacal", "Verme", "Vacina de Verme", medico3, cavalo );
        Cosulta cosulta4 = new Cosulta(LocalDateTime.now(), "Dores na teta", "Infeccao", "Aplicacao de massagem", medico4, vaca );



        //lista de pacientes
        List<Cosulta> cosultasPaciente = new ArrayList<>();
        cosultasPaciente.add(cosulta1);
        cosultasPaciente.add(cosulta2);
        cosultasPaciente.add(cosulta3);
        cosultasPaciente.add(cosulta4);


        DAOcosulta daoCosulta = new DAOcosulta("cosultas1.txt");
        daoCosulta.salva(cosultasPaciente);

    }
}
