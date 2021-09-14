package com.veterinaria.model;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOmedico implements Persistivel<Medico> {

    private File file;
    private ArquivoUtil arquivoUtil;

    public DAOmedico(String arquivo) {
        file = new File(arquivo);
        arquivoUtil = new ArquivoUtil(file);
    }

    public DAOmedico() {

    }

    @Override
    public void salva(Medico medico) {
        String registro = medico.getCpfMedico()+";" + medico.getNomeMedico()+";" + medico.getSobrenomeMedico()+";" + medico.getNumeroRegistro()+";" + medico.getEspecielidade();
        try {
            arquivoUtil.escreve(registro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salva(List<Medico> lista) {
        lista.forEach( medico -> salva(medico));

        try{
            arquivoUtil.fechaArquivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Medico obter(String id) {
        return null;
    }

    @Override
    public List<Medico> listagem() {
        List<Medico> animaisExistentes = new ArrayList<>();
        try {
            List<String> registros = this.arquivoUtil.retornaRegistros();
            registros.forEach(registro -> {
                Medico medicoConvertido = converte(registro);
                animaisExistentes.add(medicoConvertido);
            });
            return animaisExistentes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    private Medico converte(String registro) {
        String[] campos = registro.split(";");
        Medico medico = new Medico(campos[0], campos[1], campos[2], (Integer.parseInt(campos[3])), campos[4]);
        return medico;
    }
}