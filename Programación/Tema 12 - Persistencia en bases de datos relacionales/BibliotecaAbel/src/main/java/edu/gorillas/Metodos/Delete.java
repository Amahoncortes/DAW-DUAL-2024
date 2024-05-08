package edu.gorillas.Metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {

    static Scanner sc = new Scanner(System.in);

    public static void mainBorrar(Statement sentencia, Scanner sc) {
        int opcion = 0;

        do {
            opcion = Menu.menuBorrar(sc);

            switch (opcion) {
                case 1:
                    borrarLibro(sentencia);
                    break;
                case 2:
                    borrarAutor(sentencia);
                    break;

            }
        } while (opcion != 3);
    }

    /**
     * Este método permite al usuario eliminar un libro de la base de datos basado en el título del libro.
     *
     * @param sentencia El objeto Statement SQL para ejecutar consultas.
     */
    public static void borrarLibro(Statement sentencia) {
        // Solicitar al usuario que ingrese el título del libro que se desea eliminar
        System.out.println("Introduce el nombre del libro que quieres borrar: ");
        String nombreLibro = sc.nextLine();

        try {
            // Ejecutar consulta SQL para seleccionar el Id del libro basado en el título
            ResultSet rs = sentencia.executeQuery("SELECT IdLibro FROM Libros WHERE Titulo = '" + nombreLibro + "'");

            // Verificar si el libro existe
            if (rs.next()) {
                // Solicitar confirmación para eliminar el libro
                System.out.println("¿Seguro que deseas eliminar el libro? y/n");
                String confirmar = sc.nextLine();

                // Si se confirma, eliminar el libro
                if (confirmar.equals("y")) {
                    sentencia.executeUpdate("DELETE FROM Libros WHERE Titulo = '" + nombreLibro + "'");
                    System.out.println("Libro eliminado");
                } else {
                    System.out.println("Operación finalizada");
                }
            } else {
                System.out.println("El libro '" + nombreLibro + "' no se encontró en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este método se utiliza para eliminar un autor de la base de datos.
     * Primero verifica si el autor existe en la base de datos y luego lo elimina.
     * También maneja el caso en el que el autor no existe en la base de datos.
     *
     * @param sentencia El objeto de declaración SQL utilizado para ejecutar las consultas.
     */
    private static void borrarAutor(Statement sentencia) {
        // Solicitar al usuario que ingrese el nombre del autor que desea eliminar
        System.out.println("Dame el nombre del autor que deseas eliminar");
        String nombreAutor = sc.nextLine();

        try {
            // Ejecutar una consulta SQL para verificar si el autor existe en la base de datos
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Autores WHERE Nombre = '" + nombreAutor + "'");

            if (resultado.next()) {
                // Obtener el DNI del autor
                String dniAutor = resultado.getString("DNI");

                // Eliminar al autor de la base de datos
                sentencia.executeUpdate("DELETE FROM Autores WHERE Nombre = '" + nombreAutor + "'");
                System.out.println("Autor eliminado.");
            } else {
                // Si el autor no existe en la base de datos, imprimir un mensaje de error
                System.out.println("Error: El autor '" + nombreAutor + "' no existe en la base de datos.");
            }
        } catch (SQLException e) {
            // Si ocurre una excepción durante la eliminación del autor, imprimir un mensaje de error
            System.err.println("Se ha producido un error al eliminar el autor.");
            System.out.println(e.getMessage());
        }
    }


}
