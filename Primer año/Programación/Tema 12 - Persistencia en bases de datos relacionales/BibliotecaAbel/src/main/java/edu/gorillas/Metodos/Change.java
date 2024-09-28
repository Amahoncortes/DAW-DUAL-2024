package edu.gorillas.Metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Change {
    static Scanner sc = new Scanner(System.in);

    /**
     * Este método permite al usuario elegir entre modificar un libro por título o un autor por ID y ejecuta la acción correspondiente.
     * Repite el bucle hasta que el usuario elija salir del menú.
     *
     * @param sentencia El objeto Statement SQL utilizado para las operaciones de base de datos.
     * @param sc El objeto Scanner utilizado para la entrada del usuario.
     */
    public static void mainCambiar(Statement sentencia, Scanner sc) {
        int opcion = 0; // Inicializar la variable opción

        // Repetir el bucle hasta que el usuario elija salir
        do {
            opcion = Menu.menuModificar(sc); // Mostrar el menú de modificación y obtener la elección del usuario
            switch (opcion) {
                case 1:
                    cambiarLibroPorTitulo(sentencia); // Cambiar un libro por título
                    break;

                case 2:
                    cambiarAutorPorDni(sentencia); // Cambiar un autor por ID
                    break;
            }
        } while (opcion != 3); // Continuar hasta que el usuario elija salir
    }


    /**
     * Este método permite al usuario cambiar los detalles de un libro en la base de datos.
     * Primero solicita al usuario que ingrese el título del libro que desea cambiar.
     * Luego comprueba si existe un libro con ese título en la base de datos.
     * Si existe, solicita al usuario que ingrese el nuevo título y precio del libro.
     * Si no existe, imprime un mensaje indicando que no hay un libro con ese título.
     *
     * @param sentencia El objeto de sentencia SQL utilizado para operaciones en la base de datos.
     */
    private static void cambiarLibroPorTitulo(Statement sentencia) {
        // Solicita al usuario que ingrese el título del libro que desea cambiar
        System.out.println("Introduce el nombre del libro que quieres cambiar: ");
        String nombreLibro = sc.nextLine();

        try {
            // Ejecuta una consulta SQL para verificar si existe un libro con ese título en la base de datos
            ResultSet rs = sentencia.executeQuery("SELECT * FROM libros WHERE titulo = '" + nombreLibro + "'");

            // Si existe un libro con ese título, solicita al usuario que ingrese el nuevo título y precio del libro
            if (rs.next()) {
                System.out.println("Introduce el nuevo nombre del libro: ");
                String nuevoNombreLibro = sc.nextLine();
                System.out.println("Introduce el nuevo precio del libro: ");
                double nuevoPrecioLibro = sc.nextDouble();
                sc.nextLine(); // Consume el carácter de nueva línea después de leer el double

                // Ejecuta una sentencia SQL de actualización para cambiar los detalles del libro en la base de datos
                sentencia.executeUpdate("UPDATE libros SET titulo = '" + nuevoNombreLibro + "', precio = '" + nuevoPrecioLibro + "' WHERE titulo = '" + nombreLibro + "'");

                // Imprime un mensaje de éxito
                System.out.println("Libro cambiado correctamente...");
            } else {
                // Si no existe un libro con ese título, imprime un mensaje indicando eso
                System.out.println("No existe un libro con el titulo '" + nombreLibro + "'.");
            }
        } catch (SQLException e) {
            // Si ocurre una excepción durante las operaciones en la base de datos, imprime el mensaje de error
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este método permite al usuario cambiar los detalles de un autor en la base de datos.
     * Le pide al usuario que ingrese el DNI del autor que desea cambiar,
     * luego verifica si hay un autor con ese DNI en la base de datos.
     * Si existe, le pide al usuario que ingrese el nuevo nombre y nacionalidad del autor,
     * y actualiza los detalles del autor en la base de datos.
     * Si no existe, imprime un mensaje indicando que no existe un autor con ese DNI.
     *
     * @param sentencia El objeto de declaración SQL utilizado para las operaciones de base de datos.
     */
    private static void cambiarAutorPorDni(Statement sentencia) {
        // Solicita al usuario que ingrese el DNI del autor que desea cambiar
        System.out.println("Introduce el dni del autor que quieres cambiar: ");
        String dni = sc.nextLine();

        try {
            // Ejecuta una consulta SQL para verificar si hay un autor con ese DNI en la base de datos
            ResultSet rs = sentencia.executeQuery("SELECT * FROM autores WHERE dni = '" + dni + "'");

            // Si hay un autor con ese DNI
            if (rs.next()) {
                // Solicita al usuario que ingrese el nuevo nombre del autor
                System.out.println("Introduce el nuevo nombre del autor: ");
                String nuevoNombre = sc.nextLine();

                // Solicita al usuario que ingrese la nueva nacionalidad del autor
                System.out.println("Introduce la nueva nacionalidad del autor: ");
                String nuevaNacionalidad = sc.nextLine();

                // Ejecuta una sentencia SQL de actualización para cambiar los detalles del autor en la base de datos
                sentencia.executeUpdate("UPDATE autores SET Nombre = '" + nuevoNombre + "', Nacionalidad = '" + nuevaNacionalidad + "' WHERE dni = '" + dni + "'");

                // Imprime un mensaje de éxito
                System.out.println("Autor cambiado correctamente...");
            } else {
                // Si no hay un autor con ese DNI, imprime un mensaje indicando que no existe un autor con ese DNI
                System.out.println("No existe un autor con el dni '" + dni + "'.");
            }
        } catch (SQLException e) {
            // Si hay una excepción durante las operaciones de la base de datos, imprime el mensaje de error
            System.out.println(e.getMessage());
        }
    }
}
