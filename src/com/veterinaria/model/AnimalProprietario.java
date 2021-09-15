package com.veterinaria.model;


import lombok.Data;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;

@Data
public class AnimalProprietario{// extends Animal{

    private String cpfProprietario;
    private String nomeProprietario;
    private String sobrenomeProprietario;
    private LocalDate dataNascimentoProprietario;
    private String endereco;
    private Integer telefone;





    public AnimalProprietario(String cpfProprietario, String nomeProprietario, String sobrenomeProprietario, LocalDate dataNascimentoProprietario, String endereco, Integer
            telefone) throws ParseException {

        this.cpfProprietario = formatarCpf(cpfProprietario);
        this.nomeProprietario = nomeProprietario;
        this.sobrenomeProprietario = sobrenomeProprietario;
        this.dataNascimentoProprietario = dataNascimentoProprietario;
        this.endereco = endereco;
        this.telefone = telefone;


    }

    public String formatarCpf(String cpf) throws ParseException {
        MaskFormatter mf = new MaskFormatter("###.###.###-##");
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(cpf);
    }


    public AnimalProprietario() {

    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public String getSobrenomeProprietario() {
        return sobrenomeProprietario;
    }

    public LocalDate getDataNascimentoProprietario() {
        return dataNascimentoProprietario;
    }

    public String getEndereco() {
        return endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return cpfProprietario +" "+ nomeProprietario +" " + sobrenomeProprietario +" " + dataNascimentoProprietario +" " + endereco +" " + telefone;
    }
}
