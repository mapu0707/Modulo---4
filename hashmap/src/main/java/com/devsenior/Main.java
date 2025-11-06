package com.devsenior;

import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Usuario> usuarios = new HashMap<>();

        //La llave "devMaria", y contiene el valor que es el usuario completo ( nombre - contraseña)
        usuarios.put("devMaria", new Usuario("Maria", "akz"));
        usuarios.put("devLiz", new Usuario("Liz", "tulipan"));
        usuarios.put("devJungkook", new Usuario("Jungkook", "1997"));
        usuarios.put("devSuga", new Usuario("Suga", "1993"));


        //El username es la llave
        //Simulacion de un login
        String username = "devJungkook"; //Llave
        String password = "1997";

        //Si contiene la llave, entonces retorna el valor del mapa 
        //con el get y eso retorna el valor asociado y se guarda en la instacia de 
        //tipo Usuario
        if(usuarios.containsKey(username)){//Verifica si el usuario existe
            Usuario user = usuarios.get(username);//Si existe entonces dame el usuario (valor)
            if(user.validarPassword(password)){//Valida el password directamente con el objeto
                System.out.println("Login exitoso. Bienvenido " + user.getNombre());
            } else {
                System.out.println("Password incorrecto para el usuario " + username);
            }
        } else{
            System.out.println("Usuario" + username + " no encontrado. ");
        }

        System.out.println(usuarios);

        System.out.println("Imprimiendo ejemplo 2 de TreeMap");
        TreeMap<String,Double> salarios = new TreeMap<>();
        salarios.put("Carlos", 2500.0);// llave, valor
        salarios.put("Ana", 3200.0);
        salarios.put("Beatriz", 2900.0);
        System.out.println(salarios);


    }
}