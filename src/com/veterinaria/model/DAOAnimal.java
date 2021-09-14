package com.veterinaria.model;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOAnimal implements Persistivel<Animal> {

    private File file;
    private ArquivoUtil arquivoUtil;

    public DAOAnimal(String arquivo) {
        file = new File(arquivo);
        arquivoUtil = new ArquivoUtil(file);
    }

    public DAOAnimal() {

    }

    @Override
    public void salva(Animal animal) {
       String registro = animal.getNumeroDoPaciente()+";" + animal.getEspecie()+";" + animal.getRaca()+";" + animal.getCor()+";" + animal.getDataDeNascimento()+";" + animal.getNome();
        try {
            arquivoUtil.escreve(registro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salva(List<Animal> lista) {
        lista.forEach( animal -> salva(animal));

      try{
          arquivoUtil.fechaArquivo();
      } catch (Exception e) {
          e.printStackTrace();
      }
    }

    @Override
    public Animal obter(String id) {
        return null;
    }

    @Override
    public List<Animal> listagem() {
        List<Animal> animaisExistentes = new ArrayList<>();
        try {
            List<String> registros = this.arquivoUtil.retornaRegistros();
            registros.forEach(registro -> {
                Animal animalConvertido = converte(registro);
                animaisExistentes.add(animalConvertido);
            });
            return animaisExistentes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    private Animal converte(String registro) {
        String[] campos = registro.split(";");
        Animal animal = new Animal(Integer.valueOf(campos[0]), campos[1], campos[2], campos[3], LocalDate.parse(campos[4]), campos[5]);
        return animal;
    }
}