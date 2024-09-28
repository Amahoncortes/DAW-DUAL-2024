package edu.gorillas.Metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Search {

    static Scanner sc = new Scanner(System.in);

    public static void mainBuscar(Statement sentencia, Scanner sc) {

        int opcion = 0; // Inicializar la variable opción

        do {
            opcion = Menu.menuConsultas(sc); // Llamar al método menuConsultas para obtener la entrada del usuario

            // Switch para manejar diferentes opciones
            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo(sentencia); // Llamar al método para buscar un libro por título
                    break;
                case 2:
                    buscarLibroPorAutor(sentencia); // Llamar al método para buscar un libro por autor
                    break;
                case 3:
                    buscarLibros(sentencia); // Llamar al método para buscar todos los libros
                    break;
                case 4:
                    buscarAutoresConLibros(sentencia); // Llamar al método para buscar autores con libros
                    break;
            }
        } while (opcion != 5); // Repetir el bucle hasta que el usuario elija salir
    }

    /**
     * Este método solicita al usuario que introduzca el título de un libro que desea buscar,
     * y luego realiza una consulta en la base de datos para encontrar el libro con ese título.
     * Si se encuentra el libro, imprime el título y el precio del libro. Si no se encuentra el libro,
     * imprime un mensaje indicando que no se encontraron libros con ese título.
     *
     * @param sentencia El objeto de declaración SQL utilizado para ejecutar la consulta.
     */
    public static void buscarLibroPorTitulo(Statement sentencia) {
        // Solicitar al usuario que introduzca el título del libro que desea buscar
        System.out.println("Introduce el título del libro que quieras buscar: ");
        String titulo = sc.nextLine();

        try {
            // Realizar la consulta para encontrar el libro con el título introducido
            ResultSet rs = sentencia.executeQuery("SELECT * FROM libros WHERE titulo = '" + titulo + "'");

            // Verificar si se encontró un libro con el título introducido
            if (rs.next()) {
                // Obtener el título y el precio del libro desde el conjunto de resultados
                String tituloLibro = rs.getString("titulo");
                double precio = rs.getDouble("precio");

                // Imprimir el título y el precio del libro
                System.out.println("Libro: " + tituloLibro + " Precio: " + precio);
            } else {
                // Imprimir un mensaje indicando que no se encontraron libros con el título introducido
                System.out.println("No se encontraron libros con el título " + titulo + ".");
            }

        } catch (SQLException e) {
            // Imprimir un mensaje de error si ocurre una excepción durante la ejecución de la consulta
            System.err.println("Error al buscar libro por título: " + e.getMessage());
        }
    }

    // Este método permite buscar libros por autor
    public static void buscarLibroPorAutor(Statement sentencia) {
        // Solicitar al usuario que ingrese el nombre del autor que desea buscar
        System.out.println("Introduce el nombre del autor que quieras buscar: ");
        String nombreAutor = sc.nextLine();

        try {
            // Ejecutar una consulta para obtener el DNI (identificador del autor) del autor con el nombre dado
            ResultSet rs = sentencia.executeQuery("SELECT dni FROM autores WHERE Nombre = '" + nombreAutor + "'");

            // Verificar si se encontró un autor coincidente
            if (rs.next()) {
                // Obtener el DNI del autor
                String dniAutor = rs.getString("dni");

                // Ejecutar una consulta para obtener todos los libros escritos por el autor con el DNI obtenido
                ResultSet rs2 = sentencia.executeQuery("SELECT * FROM libros WHERE autor = '" + dniAutor + "'");

                // Verificar si se encontraron libros
                if (rs2.next()) {
                    // Imprimir un mensaje indicando los libros encontrados
                    System.out.println("Libros del autor " + nombreAutor + ":");
                    do {
                        // Obtener el título y precio de cada libro
                        String tituloLibro = rs2.getString("titulo");
                        double precio = rs2.getDouble("precio");
                        // Imprimir el título y precio de cada libro
                        System.out.println("Libro: " + tituloLibro + " Precio: " + precio);
                    } while (rs2.next());
                } else {
                    // Imprimir un mensaje indicando que no se encontraron libros para el autor
                    System.out.println("No se encontraron libros del autor " + nombreAutor + ".");
                }
            } else {
                // Imprimir un mensaje indicando que no se encontró ningún autor con el nombre dado
                System.out.println("No se encontró ningún autor llamado " + nombreAutor + ".");
            }
        } catch (SQLException e) {
            // Imprimir un mensaje de error si ocurre una excepción durante la ejecución de las consultas
            System.err.println("Error al buscar libro por autor: " + e.getMessage());
        }
    }

    /**
     * Este método busca libros en la base de datos y muestra sus detalles junto con el nombre del autor.
     * Utiliza dos consultas SQL: una para obtener los detalles de los libros y otra para obtener el nombre del autor.
     *
     * @param sentencia El objeto Statement utilizado para ejecutar las consultas.
     */
    public static void buscarLibros(Statement sentencia) {
        try {
            // Ejecutar la primera consulta para obtener todos los detalles de los libros de la tabla 'libros'
            ResultSet rs = sentencia.executeQuery("SELECT * FROM libros");

            // Si hay libros en el conjunto de resultados
            if (rs.next()) {
                // Imprimir un mensaje que indica que se encontraron libros
                System.out.println("Libros encontrados:");

                // Iterar a través de todos los libros en el conjunto de resultados
                do {
                    // Obtener el título y el precio del libro del conjunto de resultados
                    String tituloLibro = rs.getString("titulo");
                    double precio = rs.getDouble("precio");

                    // Obtener el DNI del autor del conjunto de resultados
                    String dniAutor = rs.getString("autor");

                    // Ejecutar la segunda consulta para obtener el nombre del autor utilizando el DNI del autor
                    ResultSet rs2 = sentencia.executeQuery("SELECT Nombre FROM autores WHERE DNI = '" + dniAutor + "'");

                    // Si se encuentra el nombre del autor en el conjunto de resultados
                    if (rs2.next()) {
                        // Obtener el nombre del autor del conjunto de resultados
                        String nombreAutor = rs2.getString("Nombre");

                        // Imprimir los detalles del libro junto con el nombre del autor
                        System.out.println("Libro: " + tituloLibro + " Precio: " + precio + " Autor: " + nombreAutor);
                    } else {
                        // Si no se encuentra el nombre del autor, imprimir un mensaje que indica que los libros del autor no se encontraron
                        System.out.println("No se encontraron libros del autor con DNI" + dniAutor + ".");
                    }
                } while (rs.next()); // Iterar al siguiente libro en el conjunto de resultados
            } else {
                // Si no se encuentran libros, imprimir un mensaje que indica que no se encontraron libros en la base de datos
                System.out.println("No se encontraron libros en la base de datos.");
            }
        } catch (SQLException e) {
            // Si ocurre una excepción SQL, imprimir un mensaje de error con el mensaje de la excepción
            System.err.println("Error al buscar libros: " + e.getMessage());
        }
    }

    /**
     * Este método busca autores que tienen libros en la base de datos.
     * Ejecuta dos consultas SQL: una para obtener los autores y otra para obtener los libros de cada autor.
     * Si se encuentra algún libro para un autor, imprime el nombre del autor y los detalles de los libros.
     * Si no se encuentran libros para un autor, imprime un mensaje indicando que no se encontraron libros para ese autor.
     * Si ocurre una excepción durante la ejecución de las consultas, imprime un mensaje de error con el mensaje de la excepción.
     *
     * @param sentencia El objeto de declaración SQL utilizado para ejecutar las consultas.
     */
    public static void buscarAutoresConLibros(Statement sentencia) {
        try {
            // Ejecutar la primera consulta SQL para obtener los autores
            ResultSet rs = sentencia.executeQuery("SELECT * FROM autores");

            // Iterar sobre los autores
            while (rs.next()) {
                // Obtener el DNI y el nombre de cada autor
                String dni = rs.getString("DNI");
                String nombre = rs.getString("Nombre");

                // Ejecutar la segunda consulta SQL para obtener los libros de cada autor
                ResultSet rs2 = sentencia.executeQuery("SELECT * FROM libros WHERE autor = '" + dni + "'");

                // Imprimir el nombre del autor
                System.out.println("Autor: " + nombre);

                // Verificar si se encuentra algún libro para el autor
                if (rs2.next()) {
                    // Imprimir el mensaje indicando que se encontraron libros
                    System.out.println("Libros: ");

                    // Iterar sobre los libros del autor
                    do {
                        // Obtener el título y el precio de cada libro
                        String titulo = rs2.getString("titulo");
                        double precio = rs2.getDouble("precio");

                        // Imprimir los detalles del libro
                        System.out.println("Libro: " + titulo + " Precio: " + precio);
                    } while (rs2.next());
                } else {
                    // Imprimir el mensaje indicando que no se encontraron libros para el autor
                    System.out.println("No se encontraron libros del autor con DNI" + dni + ".");
                }
            }
        } catch (SQLException e) {
            // Imprimir un mensaje de error con el mensaje de la excepción si ocurre una excepción
            System.err.println("Error al buscar autores con libros: " + e.getMessage());
        }
    }
}