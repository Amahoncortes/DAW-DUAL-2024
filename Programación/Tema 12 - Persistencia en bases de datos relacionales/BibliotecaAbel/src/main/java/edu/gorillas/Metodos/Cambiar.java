package edu.gorillas.Metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Cambiar {
    static Scanner sc = new Scanner(System.in);

    public static void mainCambiar(Statement sentencia, Scanner sc) {
        int opcion = 0;

        do {
            opcion = Menu.menuModificar(sc);
            switch (opcion) {
                case 1:
                    cambiarLibroPorTitulo(sentencia);
                    break;

                case 2:
                    cambiarAutorPorDni(sentencia);
                    break;
            }
        } while (opcion != 3);

    }

    private static void cambiarLibroPorTitulo(Statement sentencia) {
        System.out.println("Introduce el nombre del libro que quieres cambiar: ");
        String nombreLibro = sc.nextLine();

        try {
            ResultSet rs = sentencia.executeQuery("SELECT * FROM libros WHERE titulo = '" + nombreLibro + "'");
            if (rs.next()) {
                System.out.println("Introduce el nuevo nombre del libro: ");
                String nuevoNombreLibro = sc.nextLine();
                System.out.println("Introduce el nuevo precio del libro: ");
                double nuevoPrecioLibro = sc.nextDouble();
                sc.nextLine();
                sentencia.executeUpdate("UPDATE libros SET titulo = '" + nuevoNombreLibro + "', precio = '" + nuevoPrecioLibro + "' WHERE titulo = '" + nombreLibro + "'");
                System.out.println("Libro cambiado correctamente...");
            } else {
                System.out.println("No existe un libro con el titulo '" + nombreLibro + "'.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cambiarAutorPorDni(Statement sentencia) {
        System.out.println("Introduce el dni del autor que quieres cambiar: ");
        String dni = sc.nextLine();

        try {
            ResultSet rs = sentencia.executeQuery("SELECT * FROM autores WHERE dni = '" + dni + "'");
            if (rs.next()) {
                System.out.println("Introduce el nuevo nombre del autor: ");
                String nuevoNombre = sc.nextLine();
                System.out.println("Introduce la nueva nacionalidad del autor: ");
                String nuevaNacionalidad = sc.nextLine();
                sentencia.executeUpdate("UPDATE autores SET Nombre = '" + nuevoNombre + "',Nacionalidad = '" + nuevaNacionalidad + "' WHERE dni = '" + dni + "'");
                System.out.println("Autor cambiado correctamente...");
            } else {
                System.out.println("No existe un autor con el dni '" + dni + "'.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
