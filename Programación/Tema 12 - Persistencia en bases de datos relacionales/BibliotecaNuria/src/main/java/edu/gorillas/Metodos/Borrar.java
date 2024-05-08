package edu.gorillas.Metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Borrar {

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

    public static void borrarLibro(Statement sentencia) {

        System.out.println("Introduce el ID del libro que quieres borrar: ");
        String nombreLibro = sc.nextLine();

        try{
            ResultSet rs = sentencia.executeQuery("SELECT IdLibro FROM Libros WHERE Titulo  = " + nombreLibro);

            if(rs.next()){
                System.out.println("Seguro que deseas eliminar el libro? y/n");
                String confirmar = sc.nextLine();

                if(confirmar.equals("y")){
                    sentencia.executeUpdate( "DELETE FROM Libros WHERE Titulo = " + nombreLibro);
                    System.out.println("Libro eliminado");
                }else {
                    System.out.println("Operacion finalizada");
                }
            }else {
                System.out.println("El libro '" + nombreLibro + "' no se ha encontrado en la base de datos.");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void borrarAutor(Statement sentencia) {
        System.out.println("Dame el nombre del autor que deseas eliminar");
        String nombreAutor = sc.nextLine();

        try {
            // Verificar si el autor existe
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Autores WHERE Nombre = '" + nombreAutor + "'");

            if (resultado.next()) {
                // Obtener DNI de autor
                String dniAutor = resultado.getString("DNI");

                // Eliminar al autor
                sentencia.executeUpdate("DELETE FROM Autores WHERE Nombre = '" + nombreAutor + "'");
                System.out.println("Autor eliminado.");
            } else {
                // El autor no existe en la base de datos
                System.out.println("Error: El autor '" + nombreAutor + "' no existe en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Se ha producido un error al eliminar el autor.");
            e.printStackTrace();
        }
    }


}
