package com.devsenior.service;

import com.devsenior.exceptions.AsientoInvalidoException;
import com.devsenior.exceptions.AsientoLibreException;
import com.devsenior.exceptions.AsientoOcupadoException;
import com.devsenior.model.Asiento;
import com.devsenior.model.EstadoAsiento;

public class Teatro {
    private final int FILAS = 10;
    private final int COLUMNAS = 6;
    private Asiento[][] asientos;

    public Teatro() {
        asientos = new Asiento[FILAS][COLUMNAS];
        inicializarAsiento();
    }

    private void inicializarAsiento() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                asientos[i][j] = new Asiento();
            }
        }
    }

    public EstadoAsiento[][] obtenerEstadoAsientos() {
        EstadoAsiento[][] estadoAsientos = new EstadoAsiento[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                estadoAsientos[i][j] = asientos[i][j].getEstado();
            }
        }
        return estadoAsientos;
    }

    public void reservarAsiento(int fila, int columna) throws AsientoInvalidoException, AsientoOcupadoException {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            throw new AsientoInvalidoException("Fila o columna fuera de rango");
        }
        if (asientos[fila][columna].isLibre()) {
            asientos[fila][columna].setEstado(EstadoAsiento.OCUPADO);
        } else {
            throw new AsientoOcupadoException("El asiento ya esta resevado");
        }
    }

    public void cancelarReserva(int fila, int columna) throws AsientoInvalidoException, AsientoLibreException {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            throw new AsientoInvalidoException("Selecciono un asiento que no existe");
        }
        if (asientos[fila][columna].isLibre()) {
            throw new AsientoLibreException("El asiento en la fila"
                    + fila + " y columna " + columna + "ya esta libre");
        }

        asientos[fila][columna].setEstado(EstadoAsiento.LIBRE);
    }

    // Metodo para devolve las estadisticas de ocupacion de los asientos

    public String CalcularEstadisticas(){
        int ocupados = 0;
        int libre = 0;
        int totalAsiento = FILAS * COLUMNAS;
        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                if (asientos[i][j].isLibre()) {
                    libre++;
                }else{
                    ocupados++;
                }

            }
        }
        double porcentajeOcupacion = (double) ocupados/totalAsiento*100;

        return String.format("--- Estadistica de ocupacion ---\n" +
            "Asientos ocupados %d\n" + 
            "Asientos libres %d\n" + 
            "porcentaje de ocupacion %2.2f%%\n", 
            ocupados, libre, porcentajeOcupacion);
    }
}
