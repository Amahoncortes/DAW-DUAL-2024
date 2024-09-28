package edu.gorillas.Metodos;


import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    /**
     * Este método crea una base de datos y dos tablas en la base de datos.
     * La base de datos se llama "Biblioteca" y las tablas son "Autores" y "Libros".
     *
     * @param statement El objeto de declaración SQL utilizado para ejecutar consultas SQL.
     */
    public static void createDatabaseAndTables(Statement statement) {
        try {
            // El nombre de la base de datos que queremos crear
            String databaseName = "Biblioteca";

            // Consulta SQL para crear la tabla "Autores"
            // La tabla tiene tres columnas: dni (clave primaria), Nombre (no nulo), Nacionalidad (no nulo)
            String authorsTable = "CREATE TABLE IF NOT EXISTS Autores ("
                    + "dni char(9) primary key not null,"
                    + "Nombre varchar(20) not null,"
                    + "Nacionalidad varchar(20) not null)";

            // Consulta SQL para crear la tabla "Libros"
            // La tabla tiene cinco columnas: IdLibro (clave primaria, auto incremento), Titulo (no nulo), Precio (no nulo), Autor (no nulo)
            // La columna Autor es una clave externa que referencia la columna dni en la tabla "Autores".
            // ON DELETE CASCADE significa que si se elimina un autor, también se eliminarán todos sus libros.
            // ON UPDATE CASCADE significa que si se actualiza el dni de un autor, todas las referencias a ese dni en la tabla "Libros" también se actualizarán.
            String booksTable = "CREATE TABLE IF NOT EXISTS Libros ("
                    + "IdLibro int(5) primary key auto_increment not null,"
                    + "Titulo varchar(20) not null,"
                    + "Precio float not null,"
                    + "Autor varchar(9) not null,"
                    + "FOREIGN KEY(Autor) REFERENCES Autores(dni)"
                    + " ON DELETE CASCADE "
                    + " ON UPDATE CASCADE)";

            // Ejecutar la consulta SQL para crear la base de datos si no existe
            statement.execute("CREATE DATABASE IF NOT EXISTS " + databaseName + ";");

            // Usar la base de datos que acabamos de crear
            statement.execute("USE " + databaseName + ";");

            // Ejecutar la consulta SQL para crear la tabla "Autores" si no existe
            statement.execute(authorsTable);

            // Ejecutar la consulta SQL para crear la tabla "Libros" si no existe
            statement.execute(booksTable);
        } catch (SQLException e) {
            // Si ocurre una excepción, imprimir el mensaje de error
            System.out.println(e.getMessage());
        }
    }
}

