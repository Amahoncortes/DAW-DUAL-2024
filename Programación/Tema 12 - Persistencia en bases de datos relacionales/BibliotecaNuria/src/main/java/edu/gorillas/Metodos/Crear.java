package edu.gorillas.Metodos;


import java.sql.*;

public class Crear {

    public static void crearBase(Statement sentencia)
    {
        try{
            //Nombre de la base de datos
            String bd = "BibliotecaBD";

            //Creacion de la base de datos
            sentencia.execute("CREATE DATABASE IF NOT EXISTS"+bd);
            //Usar la base de datos
            sentencia.execute("USE "+bd);
            //Creacion de la tabla Autores
            sentencia.execute("CREATE TABLE IF NOT EXISTS Autores"
            +"(dni char(9) primary key not null,"
            +"Nombre varchar(20) not null,"
            +"Nacionalidad varchar(20) not null)");

            //Creacion de la tabla Libros
            sentencia.execute("CREATE TABLE IF NOT EXISTS Libros"
            +"(IdLibro int(5) primary key auto_increment not null,"
            +"Titulo varchar(20) not null,"
            +"Precio float not null,"
            +"Autor varchar(9) not null,"
            +"FOREIGN KEY(Autor) REFERENCES Autores(dni))"
            +"ON DELETE CASCADE ON UPDATE CASCADE");

            //Creacion de la tabla Prestamos
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
