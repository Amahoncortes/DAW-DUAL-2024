package edu.teis.examen3aEvaluacion;

import edu.teis.examen3aEvaluacion.Metodos.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VeterinarioPrincipal {
    private static final String URL = "jdbc:mariadb://localhost:3306/?user=root&password=";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (
                //Establece la conexion a la base de datos
                Connection connection = getConnection();
                //Crea objeto statement
                Statement statement = connection.createStatement();
        ) {
            Create.crearBase(statement);

            //Inicializa variable para almacenar opcion de menu
            int opcion = 0;
            //Enseña menu principal hasta que se elija opcion
            do {
                //Muestra menú y recibe entrada
                opcion = Menu.menuMain(scanner);
                switch (opcion) {
                    case 1:
                        //Inserta un nuevo registro
                        Insert.mainInsertar(statement, scanner, connection);
                        break;
                    case 2:
                        // Borra un registro de la base de datos
                        Delete.mainBorrar(statement, scanner);
                        break;
                    case 3:
                        // Busca por un registro en la base de datos.
                        Search.mainBuscar(statement, scanner);
                        break;
                    case 4:
                        // Cambia un registro de la base de datos.
                        Change.mainCambiar(statement, scanner);
                        break;

                }
            } while (opcion != 5);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


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
        return DriverManager.getConnection(URL);
    }
}
