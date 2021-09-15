package com.veterinaria;

import com.veterinaria.model.DAOmedico;
import com.veterinaria.model.Medico;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MedicoMain {
    public static void main(String[] args) throws ParseException {

          Medico medico1 = new Medico("41423423495", "rogerio", "silva", 12345, "neuro" );
          Medico medico2 = new Medico("41423655495", "carlos", "santos", 23456, "ocular" );
          Medico medico3 = new Medico("51423423495", "vagner", "valdes", 34567, "cirurgiao" );
          Medico medico4 = new Medico("71423423495", "hugo", "silva", 45678, "oftalmo" );

        List<Medico> listaMedico = new ArrayList<>();
        listaMedico.add(medico1);
        listaMedico.add(medico2);
        listaMedico.add(medico3);
        listaMedico.add(medico4);

        DAOmedico daOmedico = new DAOmedico("medicos.txt");
        daOmedico.salva(listaMedico);

    }
}
