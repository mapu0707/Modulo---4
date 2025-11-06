package com.devsenior;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> puntajes = new TreeMap<>();
        puntajes.put(1,"Juan");
        puntajes.put(3,"Ana");
        puntajes.put(2,"Luis");
        puntajes.put(5,"Maria");
        puntajes.put(4,"Carlos");

        for(int i = puntajes.size()-1; i>=0; i--){
            System.out.println(puntajes.get(i+1));
        }

    }
}