package edu.gorillas.Metodos;

import java.util.Scanner;

public class Menu {

    public static int menuMain(Scanner sc) {
        int opcion = 0;

        System.out.println("****MENU PRINCIPAL****\n"
                + "[1] Insertar\n"
                + "[2] Eliminar\n"
                + "[3] Modificar\n"
                + "[4] Consultar\n"
                + "[5] Exit\n");
        opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public static int menuInsertar(Scanner sc) {
        int opcion = 0;
        System.out.println(
                "****MENU INSERTAR****\n"
                        + "[1] Insertar Autores\n"
                        + "[2] Insertar Libros\n"
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
                        + "[1] Borrar Libros\n"
                        + "[2] Borrar Autores\n"
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
                        + "[1] Consultar Datos Libro\n"
                        + "[2] Consultar Libros Autor\n"
                        + "[3] Consultar Libros\n"
                        + "[4] Consultar Autores Con Sus Libros\n"
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
