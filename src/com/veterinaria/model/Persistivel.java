package com.veterinaria.model;

import java.util.List;

public interface Persistivel<T> {

    void salva(T objeto);
    void salva(List<T> lista);
    T obter(String id);
    List<T> listagem();

}
