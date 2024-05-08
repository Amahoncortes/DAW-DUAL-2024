package edu.gorillas.Metodos;


import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    public static void createDatabaseAndTables(Statement statement) {
        try {
            String databaseName = "Biblioteca";
            String authorsTable = "CREATE TABLE IF NOT EXISTS Autores ("
                    + "dni char(9) primary key not null,"
                    + "Nombre varchar(20) not null,"
                    + "Nacionalidad varchar(20) not null)";
            String booksTable = "CREATE TABLE IF NOT EXISTS Libros ("
                    + "IdLibro int(5) primary key auto_increment not null,"
                    + "Titulo varchar(20) not null,"
                    + "Precio float not null,"
                    + "Autor varchar(9) not null,"
                    + "FOREIGN KEY(Autor) REFERENCES Autores(dni)"
                    + " ON DELETE CASCADE "
                    + " ON UPDATE CASCADE)";

            statement.execute("CREATE DATABASE IF NOT EXISTS " + databaseName + ";");
            statement.execute("USE " + databaseName + ";");
            statement.execute(authorsTable);
            statement.execute(booksTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

