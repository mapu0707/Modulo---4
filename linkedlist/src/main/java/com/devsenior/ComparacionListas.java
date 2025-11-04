package com.devsenior;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComparacionListas {
    private static final int SIZE = 100_000;

    public static void main(String[] args) {
        pruebaInsercionFinal(new ArrayList<>(), "ArrayList");
        pruebaInsercionFinal(new LinkedList<>(), "LinkedList");

        // Prueba de accesos aleatorios
        pruebaAccesoAleatorio(new ArrayList<>(), "ArrayList");
        pruebaAccesoAleatorio(new LinkedList<>(), "LinkedList");

        // Insecion al inicio
        pruebaInsercionInicio(new ArrayList<>(), "ArrayList");
        pruebaInsercionInicio(new LinkedList<>(), "LinkedList");
    }

    private static void pruebaInsercionFinal(List<Integer> list, String nombre) {
        long inicio = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
        long fin = System.nanoTime();
        System.out.println(nombre + " - Insercion al final: " + (fin - inicio) / 1_000_000 + "ms");
    }

    private static void pruebaAccesoAleatorio(List<Integer> list, String nombre) {
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
        long inicio = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.get((int) (Math.random() * SIZE));
        }
        long fin = System.nanoTime();
        System.out.println(nombre + " - Acceso aleatorio: " + (fin - inicio) / 1_000_000 + "ms");
    }

    private static void pruebaInsercionInicio(List<Integer> list, String nombre) {
        long inicio = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            list.add(0, i); //Sobrecarga del metodo add
        }
        long fin = System.nanoTime();
        System.out.println(nombre + " - Insercion al Inicio: " + (fin - inicio) / 1_000_000 + "ms");
    }
}