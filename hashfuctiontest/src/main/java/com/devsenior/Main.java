package com.devsenior;

public class Main {
    public static void main(String[] args) throws Exception{
        String nombre = "juan";
        int h = nombre.hashCode();
        System.out.println("El hash code de " + nombre + " es: " +h);
    }
}