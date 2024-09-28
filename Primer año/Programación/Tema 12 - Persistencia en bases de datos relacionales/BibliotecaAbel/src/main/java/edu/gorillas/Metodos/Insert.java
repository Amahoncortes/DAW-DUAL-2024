package edu.gorillas.Metodos;

import java.sql.*;
import java.util.Scanner;

public class Insert {

    static Scanner sc = new Scanner(System.in);

    /**
     * Ejecuta el método mainInsertar, que muestra un menu de opciones para insertar
     * datos en la base de datos. Utiliza un objeto Scanner para leer datos de usuario
     * y un objeto Statement para ejecutar consultas SQL. El método continuará pidiendo datos
     * del usuario hasta que elija la opción de terminar.
     * Si se produce una excepción, el método muestra el mensaje de error en la consola.
     *
     * @param sentencia El objeto Statement usado para ejecutar queries SQL.
     * @param sc        El objeto Scanner que se usa para leer input de usuario.
     */

    public static void mainInsertar(Statement sentencia, Scanner sc, Connection connection) {
        // Inicializar variable opcion.
        int opcion = 0;
        // Loop hasta que se elija la opción de terminar.
        do {
            try {
                // Muestra el menu de insert y obtiene la elección del usuario.
                opcion = Menu.menuInsertar(sc);
                // Ejecuta la funcion correspondiente segun la eleccion del usuario.
                switch (opcion) {
                    case 1:
                        // Si el usuario elige insertar un autor, llama a la funcion nuevoAutor. 
                        Insert.nuevoAutor(connection);
                        break;
                    case 2:
                        // Si el usuario elige insertar un libro, llama a la funcion nuevoLibro. 
                        Insert.nuevoLibro(sentencia);
                        break;
                    case 3:
                        // Si el usuario elige terminar, sale del loop. 
                        break;
                    default:
                        // Si el usuario elige una opcion invalida, muestra un mensaje de error. 
                        System.out.println("Opción incorrecta");
                }
            } catch (Exception e) {
                // Si ocurre una excepción, muestra el mensaje de error.
                System.out.println(e.getMessage());
            }
        } while (opcion != 3);
    }


    /**
     * * Inserta un nuevo autor en la base de datos.
     * * Se solicita al usuario que introduzca el DNI, nombre y nacionalidad del autor.
     * * Luego se prepara y ejecuta una sentencia SQL para insertar estos datos en la tabla Authors.
     * * Finalmente, se muestra un mensaje indicando que el autor ha sido insertado correctamente en la base de datos.
     *
     * @param connection La conexión a la base de datos.
     */
    private static void nuevoAutor(Connection connection) {
        try {
            // Solicitar y almacenar el DNI del autor
            System.out.println("Dame el dni del autor");
            String dni = sc.nextLine();

            // Solicitar y almacenar el nombre del autor
            System.out.println("Dame el nombre del autor");
            String nombre = sc.nextLine();

            // Solicitar y almacenar la nacionalidad del autor
            System.out.println("Dame la nacionalidad del autor");
            String nacionalidad = sc.nextLine();
            // Crear la sentencia SQL para insertar un nuevo autor
            String sql = "INSERT INTO Autores VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores en la sentencia SQL
            preparedStatement.setString(1, dni);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, nacionalidad);

            // Ejecutar la sentencia SQL para insertar el autor en la base de datos
            preparedStatement.executeUpdate();

            // Mostrar mensaje de éxito
            System.out.println("Autor insertado en la base de datos...");
        } catch (SQLException e) {
            // Manejar cualquier excepción SQL que pueda ocurrir
            System.out.println(e.getMessage());
        }
    }

    /**
     * Esta función permite al usuario insertar un nuevo libro en la base de datos.
     * Solicita al usuario que ingrese el título, precio y nombre del autor del libro.
     * Luego verifica si el autor existe en la tabla 'Autores' y inserta el libro en la tabla 'Libros'.
     * Si el autor no se encuentra, muestra un mensaje indicando que el autor no fue encontrado.
     *
     * @param sentencia El objeto de declaración SQL para ejecutar consultas y actualizaciones SQL
     */
    private static void nuevoLibro(Statement sentencia) {
        // Solicitar al usuario que ingrese el título del libro
        System.out.println("Dame el titulo del libro");
        String titulo = sc.nextLine();

        // Solicitar al usuario que ingrese el precio del libro
        System.out.println("Dame el precio del libro");
        double precio = sc.nextDouble();
        sc.nextLine(); // Consumir el carácter de nueva línea que queda en el búfer

        // Solicitar al usuario que ingrese el nombre del autor
        System.out.println("Dame el nombre del autor");
        String autorNombre = sc.nextLine();

        try {
            // Ejecutar una consulta SQL para encontrar el DNI del autor basado en su nombre
            ResultSet rs = sentencia.executeQuery("SELECT dni FROM Autores WHERE nombre = '" + autorNombre + "'");

            // Si el autor se encuentra
            if (rs.next()) {
                String dni = rs.getString("dni");

                // Insertar el libro en la tabla 'Libros' con el título, precio y DNI del autor
                sentencia.executeUpdate("INSERT INTO Libros (Titulo, Precio, Autor) VALUES ('" + titulo + "', '" + precio + "', '" + dni + "')");
                System.out.println("Libro insertado en base de datos...");
            } else {
                // Si el autor no se encuentra
                System.out.println("Autor no encontrado");
            }
        } catch (SQLException e) {
            // Si hay una excepción mientras se ejecuta la consulta o actualización SQL, imprimir el mensaje de error
            System.out.println(e.getMessage());
        }
    }
}

