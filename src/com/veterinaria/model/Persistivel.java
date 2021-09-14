package com.veterinaria.model;

import java.util.HashMap;
import java.util.List;

public interface Persistivel<T> {

    void salva(T objeto);
    void salva(List<T> lista);
    //salva(List<AnimalProprietario> lista) {
    T obter(String id);
    List<T> listagem();
    //void salva(HashMap<T, Object> objeto);
}
