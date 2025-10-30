package com.devsenior.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.devsenior.exceptions.AsientoInvalidoException;
import com.devsenior.exceptions.AsientoLibreException;
import com.devsenior.exceptions.AsientoOcupadoException;
import com.devsenior.model.EstadoAsiento;
import com.devsenior.service.Teatro;

public class Menu {
    private Teatro teatro;
    private Scanner entrada;

    public Menu() {
        this.teatro = new Teatro();
        this.entrada = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion = 0;
        while (opcion != 5) {

            MostrarMenu();

            try {
                opcion = entrada.nextInt();

                entrada.nextLine();

                switch (opcion) {
                    case 1:
                        mostrarMapaAsientos();
                        break;

                    case 2:
                        gestionarReserva();
                        break;

                    case 3:
                        gestionarCancelacion();
                        break;

                    case 4:
                        mostrarEstadisticas();
                        break;

                    case 5:
                        System.out.println("Gracias por utilizar el sistema. Hasta pronto ");
                        break;

                    default:
                        System.out.println("Opcion no valida. Po favor, intente de nuevo ");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Debe ingresar un numero del mennu");
                entrada.nextLine();
                opcion = 0;
            }
        }

    }

    private void MostrarMenu() {
        System.out.println("\n---Sistema de reservacion de teatro---");
        System.out.println("1.Ver mapa de asientos");
        System.out.println("2.Reservar");
        System.out.println("3.Cancelar una reserva");
        System.out.println("4.Ver estadistica de ocupacion");
        System.out.println("5.Salir");
        System.out.println("Seleccione una opcion");
    }

    private void mostrarMapaAsientos() {
        System.out.println("\n --- Mapa de asientos (L = libre, X = ocupado)---");

        EstadoAsiento[][] estado = teatro.obtenerEstadoAsientos();

        System.out.print(" ");;
        for (int j = 0; j < estado[0].length; j++) {
            System.out.println(j + " ");
        }

        System.out.println();
        System.out.println(" --- ".repeat(estado[0].length + 1));

        for (int i = 0; i < estado.length; i++) {
            System.out.printf("%2d| ", i);

            for (int j = 0; j < estado[i].length; i++) {
                char simbolo = (estado[i][j] == EstadoAsiento.LIBRE) ? 'L' : 'X';
                System.out.println(simbolo + " ");
            }
            System.out.println();
        }

    }

    private void gestionarReserva() {
        try {
            System.out.println("Ingrese el numero de fila para reservar ");
            int fila = entrada.nextInt();

            System.out.println("Ingrese el numero de columna para reservar");
            int columna = entrada.nextInt();

            teatro.reservarAsiento(fila, columna);
            System.out.println("La reseva fue realizada con exito");

        } catch (InputMismatchException e) {
            System.out.println("ERROR: Fila y columna deben ser numeros ");
            entrada.nextLine();
        } catch (AsientoInvalidoException | AsientoOcupadoException e) {
            System.out.println("Error al reservar " + e.getMessage());
        }
    }

    private void gestionarCancelacion() {
        try {
            System.out.println("Ingrese el numero de fila a cancelar");
            int fila = entrada.nextInt();

            System.out.println("Ingrese la columna a cancelar");
            int columna = entrada.nextInt();

            // Llama al metodo para que intente hacer la cancelacion

            teatro.cancelarReserva(fila, columna);
            System.out.println("Cancelacion realizada con exito ");
        } catch (InputMismatchException e) {
            System.out.println("error la fila y la columna deben ser numeros");
            entrada.nextLine();

        } catch (AsientoLibreException | AsientoInvalidoException e) {
            System.out.println("error al cancelar " + e.getMessage());
        }
    }

    private void mostrarEstadisticas() {
        String estadisticas = teatro.CalcularEstadisticas();
        System.out.println("Las estadisticas son: " + estadisticas);
    }
}
