package com.desenior.ui;

import java.util.Scanner;

import com.desenior.datos.DataBaseSimulada;
import com.desenior.model.Categoria;
import com.desenior.service.PlatoService;

public class Menu {
    public static void Start(){
        Scanner scanner = new Scanner(System.in);
        PlatoService platoService = new PlatoService(DataBaseSimulada.getPlatos());

        int opcion = 0;
        var salir = false;

        do{
        System.out.println("Bienvenido al recomendador de platos");
        System.out.println("1. Recomendar platos por presupuesto y categoria");
        System.out.println("2. Ver top 3 platos mas saludables");
        System.out.println("3. Ver platos agrupados por categoria");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");

      

        opcion = scanner.nextInt(); 
        switch(opcion){
            case 1:
                System.out.print("Ingrese su presupuesto: ");
                double presupuesto = scanner.nextDouble();
                System.out.print("Ingrese la categoria (VEGANO, DULCE, PICANTE, TRADICIONAL, BEBIDA): ");
                String categoriaStr = scanner.next().toUpperCase();
                try {
                    Categoria categoria = Categoria.valueOf(categoriaStr);
                    var platosFiltrados = platoService.filtrarPlatos(presupuesto, categoria);
                    System.out.println("Platos recomendados:");
                    platosFiltrados.forEach(System.out::println);
                } catch (IllegalArgumentException e) {
                    System.out.println("Categoria invalida.");
                }
                break;
            case 2:
                var top3 = platoService.top3Saludables();
                System.out.println("Top 3 platos mas saludables:");
                top3.forEach(System.out::println);
                break;
            case 3:
                var agrupados = platoService.agruparPorCategoria();
                agrupados.forEach((cat, platos) -> {
                    System.out.println("Categoria: " + cat);
                    platos.forEach(System.out::println);
                });
                break;

            case 4:
                salir = true;
            default:
                System.out.println("Opcion invalida.");
            }
        } while (!salir);
            System.out.println(".:HASTA LA PROXIMA:.");
        scanner.close();
        }

    }
