package edu.gorillas.Metodos;

import java.util.Scanner;

public class Menu {

    public static int menuMain(Scanner sc) {
        int opcion = 0;

        System.out.println("****MENU PRINCIPAL****\n"
                + "[1] Insert\n"
                + "[2] Eliminar\n"
                + "[3] Change\n"
                + "[4] Search\n"
                + "[5] Exit\n");
        opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public static int menuInsertar(Scanner sc) {
        int opcion = 0;
        System.out.println(
                "****MENU INSERTAR****\n"
                        + "[1] Insert Autores\n"
                        + "[2] Insert Libros\n"
                        + "[3] Exit\n"
        );
        opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public static int menuBorrar(Scanner sc) {
        int opcion = 0;
        System.out.println(
                "****MENU BORRAR****\n"
                        + "[1] Delete Libros\n"
                        + "[2] Delete Autores\n"
                        + "[3] Exit\n"
        );
        opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public static int menuConsultas(Scanner sc) {
        int opcion = 0;
        System.out.println(
                "****MENU CONSULTAS****\n"
                        + "[1] Search Libro por Titulo\n"
                        + "[2] Search Libro por Autor\n"
                        + "[3] Listar libros\n"
                        + "[4] Listar Autores con sus libros\n"
                        + "[5] Exit\n"
        );
        opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public static int menuModificar(Scanner sc) {
        int opcion = 0;

        System.out.println("**** MENU MODIFICAR ****\n"
                + "[1] Libros\n"
                + "[2] Autores\n"
                + "[3] Exit\n");
        opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }

    public static int menuModificarLibros(Scanner sc) {
        int opcion = 0;

        System.out.println("**** MENU MODIFICAR LIBROS ****\n"
                + "[1] Titulo\n"
                + "[2] Precio\n"
                + "[3] Autor\n"
                + "[4] Exit\n");

        opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }

    public static int menuModAutores (Scanner sc)
    {
        int opcion = 0;

        System.out.println("**** MENU MODIFICAR AUTORES \n"
                + "[1] DNI\n"
                + "[2] Nombre\n"
                + "[3] Nacionalidad\n"
                + "[4] Exit\n");
        opcion = sc.nextInt();
        sc.nextLine();

        return opcion;
    }


}
