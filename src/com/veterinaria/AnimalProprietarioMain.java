package com.veterinaria;

import com.veterinaria.model.AnimalProprietario;
import com.veterinaria.model.DAOAnimalProprietario;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AnimalProprietarioMain {


    public AnimalProprietarioMain(String s, String jose, String silva, LocalDate now, String s1, int i) {
    }

    public static void main(String[] args) throws ParseException {

        AnimalProprietario animalProprietario = new AnimalProprietario("78945612312","Jose", "Silva", LocalDate.now(), "rua 13", 987456321);
        AnimalProprietario animalProprietario1 = new AnimalProprietario("14745612456","Joao", "Souza", LocalDate.now(), "rua 15", 897456328);
        AnimalProprietario animalProprietario2 = new AnimalProprietario("85245612312","Pedro", "Silva", LocalDate.now(), "rua 44", 789456321);
        AnimalProprietario animalProprietario3 = new AnimalProprietario("96345612456","Caio", "Souza", LocalDate.now(), "rua 55", 963456328);

        List<AnimalProprietario> proprietarioCadastro = new ArrayList<>();
        proprietarioCadastro.add(animalProprietario);
        proprietarioCadastro.add(animalProprietario1);
        proprietarioCadastro.add(animalProprietario2);
        proprietarioCadastro.add(animalProprietario3);

        DAOAnimalProprietario animalProprietarioDao = new DAOAnimalProprietario("proprietario.txt"); //instanciando um dao para trabalhar com o arquivo proprietario.txt
        animalProprietarioDao.salva(proprietarioCadastro);
    }
}

