package com.devsenior.model;

import java.util.ArrayList;
import java.util.List;

public class Satelite {
    private String id;
    private Estado estado;
    private List<Double> mediciones;

    //Constructor instanciacion de la clase satelite
    public Satelite(String id, Estado estado) {
        this.id = id;
        this.estado = estado;
        mediciones = new ArrayList<>();//Siempre instanciar primero
    }

    
}
