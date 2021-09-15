package com.veterinaria.model;


import lombok.Data;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;

@Data
public class AnimalProprietario {

    private String cpfProprietario;
    private String nomeProprietario;
    private String sobrenomeProprietario;
    private LocalDate dataNascimentoProprietario;
    private String endereco;
    private String telefone;
    private Animal animal;




    public AnimalProprietario(String cpfProprietario, String nomeProprietario, String sobrenomeProprietario, LocalDate dataNascimentoProprietario, String endereco, String
            telefone, Animal animal) throws ParseException {

        this.cpfProprietario = formatarCpf(cpfProprietario);
        this.nomeProprietario = nomeProprietario;
        this.sobrenomeProprietario = sobrenomeProprietario;
        this.dataNascimentoProprietario = dataNascimentoProprietario;
        this.endereco = endereco;
        this.telefone = telefone;
        this.animal = animal;


    }

    public AnimalProprietario(String campo, String campo1, String campo2, LocalDate parse, String campo3, String campo4, String campo5) {

    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getSobrenomeProprietario() {
        return sobrenomeProprietario;
    }

    public void setSobrenomeProprietario(String sobrenomeProprietario) {
        this.sobrenomeProprietario = sobrenomeProprietario;
    }

    public LocalDate getDataNascimentoProprietario() {
        return dataNascimentoProprietario;
    }

    public void setDataNascimentoProprietario(LocalDate dataNascimentoProprietario) {
        this.dataNascimentoProprietario = dataNascimentoProprietario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String formatarCpf(String cpf) throws ParseException {
        MaskFormatter mf = new MaskFormatter("###.###.###-##");
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(cpf);
    }





    @Override
    public String toString() {
        return cpfProprietario +" "+ nomeProprietario +" " + sobrenomeProprietario +" " + dataNascimentoProprietario +" " + endereco +" " + telefone;
    }
}
