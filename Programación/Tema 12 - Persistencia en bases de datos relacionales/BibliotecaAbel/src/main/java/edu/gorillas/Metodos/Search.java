package edu.gorillas.Metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Search {

    static Scanner sc = new Scanner(System.in);

    public static void mainBuscar(Statement sentencia, Scanner sc) {


        int opcion = 0;

        do {
            opcion = Menu.menuConsultas(sc);

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo(sentencia);
                    break;
                case 2:
                    buscarLibroPorAutor(sentencia);
                    break;
                case 3:
                    buscarLibros(sentencia);
                    break;
                case 4:
                    buscarAutoresConLibros(sentencia);
                    break;
            }
        } while (opcion != 5);
    }

    public static void buscarLibroPorTitulo(Statement sentencia) {
        System.out.println("Introduce el titulo del libro que quieras buscar: ");
        String titulo = sc.nextLine();

        try {
            ResultSet rs = sentencia.executeQuery("SELECT * FROM libros WHERE titulo = '" + titulo + "'");
            if (rs.next()) {
                String tituloLibro = rs.getString("titulo");
                double precio = rs.getDouble("precio");

                System.out.println("Libro: " + tituloLibro + " Precio: " + precio);
            } else {
                System.out.println("No se encontraron libros con el titulo " + titulo + ".");
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar libro por titulo: " + e.getMessage());
        }
    }

    public static void buscarLibroPorAutor(Statement sentencia) {
        System.out.println("Introduce el nombre del autor que quieras buscar: ");
        String nombreAutor = sc.nextLine();

        try {
            ResultSet rs = sentencia.executeQuery("SELECT dni FROM autores WHERE Nombre = '" + nombreAutor + "'");
            if (rs.next()) {
                String dniAutor = rs.getString("dni");

                ResultSet rs2 = sentencia.executeQuery("SELECT * FROM libros WHERE autor = '" + dniAutor + "'");

                if (rs2.next()) {
                    System.out.println("Libros del autor " + nombreAutor + ":");
                    do {
                        String tituloLibro = rs2.getString("titulo");
                        double precio = rs2.getDouble("precio");
                        System.out.println("Libro: " + tituloLibro + " Precio: " + precio);
                    } while (rs2.next());
                } else {
                    System.out.println("No se encontraron libros del autor " + nombreAutor + ".");
                }
            } else {
                System.out.println("No se encontró ningún autor llamado " + nombreAutor + ".");
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar libro por autor: " + e.getMessage());
        }
    }

    public static void buscarLibros(Statement sentencia) {
        try {
            ResultSet rs = sentencia.executeQuery("SELECT * FROM libros");
            if (rs.next()) {
                System.out.println("Libros encontrados:");
                do {
                    String tituloLibro = rs.getString("titulo");
                    double precio = rs.getDouble("precio");
                    String dniAutor = rs.getString("autor");

                    ResultSet rs2 = sentencia.executeQuery("SELECT Nombre FROM autores WHERE DNI = '" + dniAutor + "'");
                    if (rs2.next()) {
                        String nombreAutor = rs2.getString("Nombre");
                        System.out.println("Libro: " + tituloLibro + " Precio: " + precio + " Autor: " + nombreAutor);
                    } else {
                        System.out.println("No se encontraron libros del autor con DNI" + dniAutor + ".");
                    }
                } while (rs.next());
            } else {
                System.out.println("No se encontraron libros en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar libros: " + e.getMessage());
        }
    }

    public static void buscarAutoresConLibros(Statement sentencia) {
        try {
            ResultSet rs = sentencia.executeQuery("SELECT * FROM autores");
            while (rs.next()) {
                String dni = rs.getString("DNI");
                String nombre = rs.getString("Nombre");

                ResultSet rs2 = sentencia.executeQuery("SELECT * FROM libros WHERE autor = '" + dni + "'");
                System.out.println("Autor: " + nombre);

                if (rs2.next()) {
                    System.out.println("Libros: ");
                    do {
                        String titulo = rs2.getString("titulo");
                        double precio = rs2.getDouble("precio");
                        System.out.println("Libro: " + titulo + " Precio: " + precio);
                    } while (rs2.next());
                } else {
                    System.out.println("No se encontraron libros del autor con DNI" + dni + ".");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar autores con libros: " + e.getMessage());
        }
    }
}