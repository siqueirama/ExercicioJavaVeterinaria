package com.veterinaria;

import com.veterinaria.model.Animal;
import com.veterinaria.model.DAOAnimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalMain {


    public static void main(String[] args) {

        Animal cao = new Animal(123, "cachorro","fila","preto", LocalDate.now(),"thor");
        Animal gato = new Animal(456, "gato","siames","cinza",LocalDate.now(),"aranha");
        Animal cavalo = new Animal(789, "cavalo","alazão","marrom",LocalDate.now(),"gruth");
        Animal vaca = new Animal(741, "vaca","nelori","branca",LocalDate.now(),"mimosa");

        //Cadastro Animais
        List<Animal> cadastroAnimais = new ArrayList<>();
        cadastroAnimais.add(cao);
        cadastroAnimais.add(gato);
        cadastroAnimais.add(cavalo);
        cadastroAnimais.add(vaca);

        DAOAnimal animalDao = new DAOAnimal("animal.txt");
        animalDao.salva(cadastroAnimais);
    }
}
