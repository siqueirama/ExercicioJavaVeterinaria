package com.veterinaria.model;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAOAnimalProprietario implements Persistivel<AnimalProprietario>{
    private File file;
    private ArquivoUtil arquivoUtil;

    public DAOAnimalProprietario(String arquivo) {
        file = new File(arquivo);
        arquivoUtil = new ArquivoUtil(file);
    }

    public DAOAnimalProprietario() {

    }

    @Override
    public void salva(AnimalProprietario animalProprietario) {
        String registro = animalProprietario.getCpfProprietario()+";"+animalProprietario.getNomeProprietario()+";"+animalProprietario.getSobrenomeProprietario()+";"+animalProprietario.getDataNascimentoProprietario()+";"+animalProprietario.getEndereco()+";"+animalProprietario.getTelefone();
        try {
            arquivoUtil.escreve(registro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salva(List<AnimalProprietario> lista) {
        lista.forEach( animalProprietario -> salva(animalProprietario));

        try{
            arquivoUtil.fechaArquivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AnimalProprietario obter(String id) {
        return null;
    }

    @Override
    public List<AnimalProprietario> listagem() {
        List<AnimalProprietario> proprietarioExistentes = new ArrayList<>();
        try {
            List<String> registros = this.arquivoUtil.retornaRegistros();
            registros.forEach(registro -> {
                AnimalProprietario animalProprietarioConvertido = converte(registro);
                proprietarioExistentes.add(animalProprietarioConvertido);
            });
            return proprietarioExistentes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private AnimalProprietario converte(String registro) {
        String[] campos = registro.split(";");
        AnimalProprietario animalProprietario = new AnimalProprietario((campos[0]), campos[1], campos[2], LocalDate.parse(campos[3]), campos[4], Integer.valueOf(campos[5]));
        return animalProprietario;
    }
}

