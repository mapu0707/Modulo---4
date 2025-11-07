package com.devsenior.model;

import java.util.ArrayList;
import java.util.List;

public class Satelite {
    private String id;
    private Estado estado;
    private List<Double> mediciones;//Se declara con la interfaz

    //Constructor instanciacion de la clase satelite
    public Satelite(String id, Estado estado) {
        this.id = id;
        this.estado = estado;
        mediciones = new ArrayList<>();//Aca se llama la implementacion
        //Siempre instanciar primero
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Double> getMediciones() {
        return mediciones;
    }

    public void agregarMedicion( double medicion) {
        this.mediciones.add(medicion);
    }

    @Override
    public String toString() {
        return "Satelite [id=" + id + ", estado=" + estado + ", mediciones=" + mediciones + "]";
    }

    public boolean equals(Object obj){
        if(this == obj) return true;//Apuntando a la misma referencia en memoria ram
        if(obj == null|| getClass()!=obj.getClass()) return false;// cuando es null o no son de la misma calse
        Satelite satelite = (Satelite) obj;
        return id.equals(satelite.id);// si sus id son iguales entonces son iguales
    }
    
    

    
}
