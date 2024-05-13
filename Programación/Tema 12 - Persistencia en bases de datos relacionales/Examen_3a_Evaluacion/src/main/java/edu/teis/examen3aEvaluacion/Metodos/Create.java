package edu.teis.examen3aEvaluacion.Metodos;

import java.sql.SQLException;
import java.sql.Statement;

public class Create {
    public static void crearBase(Statement sentencia) {
        try {
            String bd = "ClinicaVetBD";

            //Consulta SQL para crear Especialidades
            String tablaEspecialidades = "CREATE TABLE IF NOT EXISTS Especialidades("
                    + "idEsp int(3) primary key not null,"
                    + "nombreEsp VARCHAR(30) not null)";

            //Consulta SQL para crear Veterinarios
            String tablaVeterinarios = "CREATE TABLE IF NOT EXISTS Veterinarios("
                    + "dni char(9) primary key not null,"
                    + "nombreVet VARCHAR(30) not null,"
                    + "edad int(3) not null,"
                    + "direccion VARCHAR(30) not null,"
                    + "sueldo float not null,"
                    + "esp int(3) not null,"
                    + "fechaContratacion date null,"
                    + "Foreign key (esp) references Especialidades(idEsp))"
                    ;

            //Consulta para Mascotas
            String tablaMascotas = "CREATE TABLE IF NOT EXISTS Mascotas("
                    + "idMascota INT(5) unsigned zerofill primary key not null auto_increment,"
                    + "nombreMasc VARCHAR(30) not null,"
                    + "especie VARCHAR(30) not null,"
                    + "raza VARCHAR(30) not null,"
                    + "fechaNac date null,"
                    + "fechaAlta date null,"
                    + "veterinario char(9) null,"
                    + "Foreign key (veterinario) references Veterinarios(dni)"
                    + " on delete SET NULL "
                    + "on update SET NULL)"
            ;

            sentencia.execute("CREATE DATABASE IF NOT EXISTS " + bd + ";");
            sentencia.execute("USE " + bd + ";");

            sentencia.execute(tablaEspecialidades);
            sentencia.execute(tablaVeterinarios);
            sentencia.execute(tablaMascotas);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

