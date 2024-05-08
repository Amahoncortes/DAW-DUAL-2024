package edu.gorillas.Metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insertar {

    static Scanner sc = new Scanner(System.in);

    public static void mainInsertar(Statement sentencia, Scanner sc) {
        int opcion = 0;

        do {
            opcion = Menu.menuInsertar(sc);
            switch (opcion) {
                case 1:
                    Insertar.nuevoAutor(sentencia);
                    break;
                case 2:
                    Insertar.nuevoLibro(sentencia);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 3);
    }

    private static void nuevoAutor(Statement sentencia) {
        String dni, nacionalidad, nombre;
        try {
            System.out.println("Dame el dni del autor");
            dni = sc.nextLine();
            System.out.println("Dame el nombre del autor");
            nombre = sc.nextLine();
            System.out.println("Dame la nacionalidad del autor");
            nacionalidad = sc.nextLine();

            sentencia.executeUpdate("INSERT INTO Autores VALUES ('" + dni + "', '" + nombre + "', '" + nacionalidad + "')");
            System.out.println("Autor insertado en base de datos...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void nuevoLibro(Statement sentencia) {
        System.out.println("Dame el titulo del libro");
        String titulo = sc.nextLine();
        System.out.println("Dame el precio del libro");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.println("Dame el nombre del autor");
        String autorNombre = sc.nextLine();

        try {
            ResultSet rs = sentencia.executeQuery("SELECT dni FROM Autores WHERE nombre = '" + autorNombre + "'");

            if (rs.next()) {
                String dni = rs.getString("dni");
                sentencia.executeUpdate("INSERT INTO Libros (Titulo, Precio, Autor) VALUES ('" + titulo + "', '" + precio + "', '" + dni + "')");
                System.out.println("Libro insertado en base de datos...");
            } else {
                System.out.println("Autor no encontrado");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}

