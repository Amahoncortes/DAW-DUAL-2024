package edu.teis.examen3aEvaluacion.Metodos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class Change {
    static Scanner sc = new Scanner(System.in);


    public static void mainCambiar(Statement sentencia, Scanner sc) {
        int opcion = 0;

        // Repetir el bucle hasta que el usuario elija salir
        do {
            opcion = Menu.menuModificar(sc); // Mostrar el menú de modificación y obtener la elección del usuario
            switch (opcion) {
                case 1:
                    ModificarSalarioDeVeterinarioPorDNI(sentencia);
                    break;

                case 2:
                    modificarVeterinarioDeMascota(sentencia);
                    break;
            }
        } while (opcion != 3); // Continuar hasta que el usuario elija salir
    }


    private static void ModificarSalarioDeVeterinarioPorDNI(Statement sentencia) {

        System.out.println("Introduce el DNI del veterinario cuyo salario quieres cambiar: ");
        String dniVeterinario = sc.nextLine();

        try {
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Veterinarios WHERE dni = '" + dniVeterinario + "'");

            if (rs.next()) {
                System.out.println("Introduce el nuevo salario del veterinario: ");
                double nuevoSalarioVeterinario = sc.nextDouble();
                sc.nextLine();

                sentencia.executeUpdate("UPDATE Veterinarios SET sueldo = '" + nuevoSalarioVeterinario + "' WHERE dni = '" + dniVeterinario + "'");


                System.out.println("Salario del veterinario con dni " + dniVeterinario + " cambiado correctamente...");
            } else {
                System.out.println("No existe un veterinario con el dni '" + dniVeterinario + "'.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void modificarVeterinarioDeMascota(Statement sentencia) {
        System.out.println("Introduce el nombre de la mascota que quieres cambiar: ");
        String nombreMascota = sc.nextLine();

        System.out.println("Introduce la especie de la mascota que quieres cambiar");
        String especieMascota = sc.nextLine();

        try {


            // Ejecutar una consulta para obtener todos los datos de la mascota con el nombre y la especie dadas
            ResultSet rs = sentencia.executeQuery("SELECT * FROM Mascotas WHERE nombreMasc= '" + nombreMascota + "' " +
                    "AND especie = '" + especieMascota + "';");

            if (rs.next()) {
                System.out.println("Mascotas encontradas");

                do {
                    nombreMascota = rs.getString("nombreMasc");
                    especieMascota = rs.getString("especie");

                    //obtener dni de veterinario
                    String dniVeterinario = rs.getString("veterinario");

                    //Segunda consulta para obtener datos pertinentes del veterinario
                    ResultSet rs2 = sentencia.executeQuery("SELECT veterinario FROM Mascotas " +
                            "WHERE veterinario = '" + dniVeterinario + "'");

                    if (rs2.next()) {
                        System.out.println("Introduce el nuevo DNI del veterinario: ");
                        String veterinarioNuevo = sc.nextLine();
                        sentencia.executeUpdate("UPDATE Mascotas SET veterinario = '" + veterinarioNuevo + "' WHERE veterinario ='" + dniVeterinario + "'");
                        System.out.println("Veterinario modificado correctamente para la mascota " + nombreMascota);
                    } else {
                        System.out.println("No se encontraron veterinarios para la mascota " + nombreMascota + " de especie " + especieMascota);
                    }
                } while (rs.next());
            } else {
                System.out.println("No se encontraron mascotas en la base de datos");
            }
        } catch (SQLException e) {
            // Si ocurre una excepción durante las operaciones en la base de datos, imprime el mensaje de error
            System.out.println(e.getMessage());
        }
    }
}

