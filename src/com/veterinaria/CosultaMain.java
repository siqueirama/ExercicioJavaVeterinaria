package com.veterinaria;

import com.veterinaria.model.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CosultaMain {


    public static void main(String[] args) {

        AnimalProprietario proprietario = new AnimalProprietario("40323023","Jessica", "silva", LocalDate.now(), "rua carlos jose", 1195829342);
        Medico medico1 = new Medico("323232","hugo", "victor", 4043232, "cahorro");
        Animal animal1 = new Animal(1234, "cachorro", "dog", "preto", LocalDate.now(), "carlos" );

        Cosulta cosulta1 = new Cosulta(LocalDateTime.now(), "Dor", "bacteria", "cortar perna", medico1, animal1 );
        Cosulta cosulta2 = new Cosulta(LocalDateTime.now(), "febre", "bacteria", "cortar perna", medico1, animal1 );



        //lista de pacientes
        List<Cosulta> cosultasPaciente = new ArrayList<>();
        cosultasPaciente.add(cosulta1);


    DAOcosulta daoCosulta = new DAOcosulta("cosultas.txt");
    daoCosulta.salva(cosultasPaciente);

    }
}
