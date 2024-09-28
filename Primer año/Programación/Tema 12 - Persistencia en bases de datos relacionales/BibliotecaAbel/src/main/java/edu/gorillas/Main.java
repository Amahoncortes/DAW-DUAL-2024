package edu.gorillas;

import edu.gorillas.Metodos.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mariadb://localhost:3306/?user=root&password=";

    /**
     * Este es el punto de entrada al programa.
     * Establece la conexión con la base de datos, crea la base de datos y las tablas si no existen,
     * y presenta un menú principal al usuario para realizar operaciones CRUD sobre la base de datos.
     * @param args Los argumentos de linea de comandos.
     */

    // Punto de entrada al programa
    public static void main(String[] args) {
        // Crea un escaner que recibe input de entrada por consola
        Scanner scanner = new Scanner(System.in);

        try (
                // Establece la conexion a la base de datos
                Connection connection = getConnection();
                // Crea un objeto statement para ejecutar queries SQL
                Statement statement = connection.createStatement()
        ) {
            // Crea la base de datos y las tablas si no existen.
            Create.createDatabaseAndTables(statement);

            // Inicializa la variable para almacenar la opcion del menu.
            int opcion = 0;

            // Enseña el menu principal hasta que se elija una de las opciones.
            do {
                //Muestra el menú y recibe la entrada del usuario.
                opcion = Menu.menuMain(scanner);

                // Ejecuta la operación que corresponda con la entrada del usuario.
                switch (opcion) {
                    case 1:
                        // Inserta un nuevo registro en la base de datos.
                        Insert.mainInsertar(statement, scanner, connection);
                        break;
                    case 2:
                        // Borra un registro de la base de datos
                        Delete.mainBorrar(statement, scanner);
                        break;
                    case 3:
                        // Cambia un registro de la base de datos.
                        Change.mainCambiar(statement, scanner);
                        break;
                    case 4:
                        // Busca por un registro en la base de datos.
                        Search.mainBuscar(statement, scanner);
                        break;
                    case 5:
                        // Sale del programa
                        System.out.println("Hasta pronto");
                        break;
                }
            } while (opcion != 5);
        } catch (SQLException e) {
            // Maneja cualquier excepción SQL que pueda ocurrir.
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este método se usa para establecer una conexión con la base de datos.
     * Carga el driver de MariaDB, e intenta establecer una sesión con la base de datos.
     * Si el driver no se encuentra, lanza una RuntimeException.
     *
     * @return Connection - La conexión con la base de datos.
     * @throws SQLException - Si hay un error al establecer la sesión, lanza esta excepción.
     */
    private static Connection getConnection() throws SQLException {
        try {
            // Carga el driver de MariaDB.
            // Esto se hace para asegurar que el driver se encuentra disponible en la clasepath.
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Si el driver no se encuentra, se lanza una excepción.
            throw new RuntimeException("Driver not found", e);
        }

        // Usa el driver para establecer una conexión con la base de datos.
        // La URL es un string que especifica la ubicación de la base de datos, el usuario y la contraseña.
        // Debería ser definida como constante en el código.
        return DriverManager.getConnection(URL);}
}