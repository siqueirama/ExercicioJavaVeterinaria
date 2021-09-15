package com.veterinaria.model;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAOcosulta implements Persistivel<Cosulta> {

    private File file;
    private ArquivoUtil arquivoUtil;

    public DAOcosulta(String arquivo) {
        file = new File(arquivo);
        arquivoUtil = new ArquivoUtil(file);
    }

    public DAOcosulta() {

    }

    @Override
    public void salva(Cosulta cosulta) {
        String registro = "------- Consulta------ "+"\n"+ "Horário "+cosulta.getDataHora()+"Motivo " + cosulta.getMotivo()+"Diagnóstico "
                + cosulta.getDiagnostico()+"Tratamento " + cosulta.getTratamento()+"\n"+" ---- Paciente ----- " +"\n" + cosulta.getAnimal()+"\n"+"-----Médico----"+"\n" +cosulta.getMedico();

        try {
            arquivoUtil.escreve(registro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salva(List<Cosulta> lista) {
        lista.forEach( cosulta -> salva(cosulta));

        try{
            arquivoUtil.fechaArquivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cosulta obter(String id) {
        return null;
    }

    @Override
    public List<Cosulta> listagem() {
        List<Cosulta> cosultasExistentes = new ArrayList<>();
        try {
            List<String> registros = this.arquivoUtil.retornaRegistros();
            registros.forEach(registro -> {
                Cosulta cosultaConvertido = converte(registro);
                cosultasExistentes.add(cosultaConvertido);
            });
            return cosultasExistentes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    private Cosulta converte(String registro) {
        String[] campos = registro.split(";");
        Cosulta cosulta = new Cosulta((LocalDateTime.parse(campos[0])), campos[1], campos[2], campos[3], campos[4], campos[5]);
        return cosulta;
    }

}
