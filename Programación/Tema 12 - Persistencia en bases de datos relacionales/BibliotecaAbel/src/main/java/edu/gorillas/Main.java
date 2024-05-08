package edu.gorillas;

import edu.gorillas.Metodos.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Statement sentencia = null;
        Connection conexion = null;

        int opcion = 0;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mariadb://localhost:3306/?user=root&password=";

        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("No hay ningún driver que reconozca la URL especificada");
        } catch (Exception e) {
            System.out.println("Se ha producido algún otro error");
        }

        try {
            assert conexion != null;
            sentencia = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Error");
        }

        assert sentencia != null;
        Crear.crearBase(sentencia);


        do {
            opcion = Menu.menuMain(sc);
            switch (opcion) {
                case 1:
                    Insertar.mainInsertar(sentencia, sc);
                    break;
                case 2:
                    Borrar.mainBorrar(sentencia, sc);
                    break;
                case 3:
                    // Modificar.modificarLibro(sentencia);
                    break;
                case 4:
                    //Consultar.consultarLibros(sentencia);
                    break;
                case 5:
                    System.out.println("Hasta pronto");
                    break;
            }
        } while (opcion != 5);


    }
}