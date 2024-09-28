package edu.teis.examen3aEvaluacion.Metodos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static int menuMain(Scanner sc) {
        System.out.println("""
                **** MENU ****
                [1] Insertar elementos
                [2] Eliminar elementos
                [3] Consultas
                [4] Modificaciones
                [5] Exit
                """);
        int opcion;
        try {
            opcion = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, introduzca un valor numérico.");
            sc.nextLine();
            opcion = menuMain(sc);
        }
        return opcion;
    }

    public static int menuInsertar(Scanner sc) {
        int opcion = 0;
        System.out.println("""
                **** MENU INSERCIONES ****
                [1] Insertar veterinario 
                [2] Insertar mascota
                [3] Exit
                """);

        if (sc.hasNextInt()) {
            opcion = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
        }
        return opcion;
    }

    public static int menuBorrar(Scanner sc) {
        int opcion = 0;
        System.out.println("**** MENU ELIMINAR ****\n"
                + "[1] Eliminar mascota\n"
                + "[2] Eliminar veterinario\n"
                + "[3] Exit\n");
        if (sc.hasNextInt()) {
            opcion = sc.nextInt();
            sc.nextLine();
        } else {

            System.out.println("Entrada inválida. Por favor, ingresa un número.");
        }
        return opcion;
    }

    public static int menuConsultas(Scanner sc) {
        int opcion = 0;
        System.out.println("**** MENU CONSULTAS ****\n"
                + "[1] Mostrar mascotas de un veterinario\n"
                + "[2] Mostrar veterinario de una mascota\n"
                + "[3] Exportar a fichero los datos de veterinarios con salario alto\n"
                + "[4] Exit\n");
        if (sc.hasNextInt()) {
            opcion = sc.nextInt();
            sc.nextLine();
        } else {

            System.out.println("Entrada inválida. Por favor, ingresa un número.");
        }
        return opcion;
    }

    public static int menuModificar(Scanner sc) {
        int opcion = 0;
        System.out.println("**** MENU MODIFICACIONES ****\n"
                + "[1] Modificar salario de veterinario\n"
                + "[2] Modificar veterinario asignado a mascota\n"
                + "[3] Exit\n");
        if (sc.hasNextInt()) {
            opcion = sc.nextInt();
            sc.nextLine();
        } else {

            System.out.println("Entrada inválida. Por favor, ingresa un número.");
        }
        return opcion;
    }




}

