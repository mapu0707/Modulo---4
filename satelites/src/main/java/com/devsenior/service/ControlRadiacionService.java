package com.devsenior.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.devsenior.excepciones.SateliteNoEncontradoException;
import com.devsenior.model.Estado;
import com.devsenior.model.Satelite;

public class ControlRadiacionService {// Clase que estara encargada de administrar la logica de los satelites
    private Map<String, Satelite> satelites;

    public ControlRadiacionService() {
        satelites = new HashMap<>();
    }

    public void registrarSatelites(Satelite satelite) {
        satelites.put(satelite.getId(), satelite);
    }

    // Consultar Estado
    public Estado consultarEstado(String id) throws SateliteNoEncontradoException {
        Satelite satelite = satelites.get(id);
        if (satelite != null) {// si satelite es diferente de null
            return satelite.getEstado();// retorna el estado, rompe el metodo porque el return garantiza la salida del
                                        // metodo
        }
        throw new SateliteNoEncontradoException("Satelite no encontrado");
    }

    public List<Double> consultarHistorial(String id) throws SateliteNoEncontradoException {
        Satelite satelite = satelites.get(id);// La busqueda del satelite en el mapa
        if (satelite != null) {// si satelite es diferente de null
            return satelite.getMediciones();// retorna el estado, rompe el metodo porque el return garantiza la salida
                                            // del metodo
        }
        throw new SateliteNoEncontradoException("Satelite no encontrado");
    }

    public boolean agregarMediciones(String id, double medicion) throws SateliteNoEncontradoException {
        Satelite satelite = satelites.get(id);// La busqueda del satelite en el mapa
        if (satelite != null) {// si satelite es diferente de null
            satelite.agregarMedicion(medicion);
            return true;
        }
        throw new SateliteNoEncontradoException("Satelite no encontrado");
    }

    public void cambiarEstado(String id, Estado nuevoEstado) throws SateliteNoEncontradoException {
        buscarSatelite(id).setEstado(nuevoEstado);
    }

    private Satelite buscarSatelite(String id) throws SateliteNoEncontradoException {
        Satelite satelite = satelites.get(id);// La busqueda del satelite en el mapa
        if (satelite != null) {// si satelite es diferente de null
            return satelite;
        }
        throw new SateliteNoEncontradoException("Satelite no encontrado");
    }
}
