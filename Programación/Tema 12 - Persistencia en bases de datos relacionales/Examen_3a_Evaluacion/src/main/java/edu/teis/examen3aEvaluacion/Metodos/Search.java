package edu.teis.examen3aEvaluacion.Metodos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
                    buscarMascotaPorNombreVeterinario(sentencia); // Llamar al método para buscar mascota por nombre veterinario
                    break;
                case 2:
                    buscarVeterinarioPorDatosMascota(sentencia); //Método para buscar veterinario a partir de datos de mascota
                    break;
                case 3:
                    exportarAFicheroDeTexto(sentencia);
                    break;
                case 4:
                    System.out.println("Hasta pronto...");
                    break;
            }
        } while (opcion != 4); // Repetir el bucle hasta que el usuario elija salir
    }

    /**
     * Este método solicita al usuario que introduzca el nombre de un veterinario que desea buscar,
     * y luego realiza una consulta en la base de datos para encontrar a las mascotas del veterinario con ese nombre.
     * Si Las encuentra, imprime sus atributos. Si no se encuentran, imprime un mensaje indicándolo.
     *
     * @param sentencia El objeto de declaración SQL utilizado para ejecutar la consulta.
     */


    // Este método permite buscar mascota por nombre veterinario
    public static void buscarMascotaPorNombreVeterinario(Statement sentencia) {
        // Solicitar al usuario que ingrese el nombre del veterinario que desea buscar
        System.out.println("Introduce el nombre del veterinario cuyas mascotas quieras buscar: ");
        String nombreVeterinario = sc.nextLine();

        try {
            // Ejecutar una consulta para obtener el DNI (identificador del veterinario) del veterinario con el nombre dado
            ResultSet rs = sentencia.executeQuery("SELECT dni FROM Veterinarios WHERE nombreVet = '" + nombreVeterinario + "'");

            // Verificar si se encontró un veterinario coincidente
            if (rs.next()) {
                // Obtener el DNI del veterinario
                String dniVeterinario = rs.getString("dni");

                // Ejecutar una consulta para obtener todas las mascotas del veterinario cuyo DNI hemos obtenido
                ResultSet rs2 = sentencia.executeQuery("SELECT * FROM Mascotas WHERE veterinario = '" + dniVeterinario + "'");

                // Verificar si se encontraron mascotas
                if (rs2.next()) {
                    // Imprimir un mensaje indicando las mascotas encontradas:
                    System.out.println("Mascotas del veterinario " + nombreVeterinario + ":");
                    do {
                        // Obtener los datos de las mascotas
                        int idMascota = rs2.getInt("idMascota");
                        String nombreMascota = rs2.getString("nombreMasc");
                        String especieMascota = rs2.getString("especie");
                        String razaMascota = rs2.getString("raza");
                        LocalDate fechaNacMascota = rs2.getDate("fechaNac").toLocalDate();
                        LocalDate fechaAltaMascota = rs2.getDate("fechaAlta").toLocalDate();
                        System.out.println("ID mascota: " + idMascota + "\n" +
                                "nombreMascota: " + nombreMascota + "\n" +
                                "especieMascota: " + especieMascota + "\n" +
                                "razaMascota: " + razaMascota + "\n" +
                                "fecha de nacimiento mascota: " + fechaNacMascota + "\n" +
                                "fecha de alta mascota: " + fechaAltaMascota);
                    } while (rs2.next());
                } else {
                    //Imprimir mensaje indicando que no se encontraron mascotas para el veterinario
                    System.out.println("No se encontrar mascotas del veterinario " + nombreVeterinario + ".");
                }
            } else {
                System.out.println("No se encontró ningun veterinario llamado " + nombreVeterinario);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar mascota por veterinario: " + e.getMessage());
        }
    }

    public static void buscarVeterinarioPorDatosMascota(Statement sentencia) {
        try {

            // Solicitar al usuario que ingrese el nombre y la especie de la mascota cuyo veterinario  desea buscar
            System.out.println("Introduce el nombre de la mascota");
            String nombreMascota = sc.nextLine();
            System.out.println("Introduce la especie de la mascota");
            String especieMascota = sc.nextLine();

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
                    ResultSet rs2 = sentencia.executeQuery("SELECT nombreVet, fechaContratacion FROM Veterinarios " +
                            "WHERE dni = '" + dniVeterinario + "'");

                    if (rs2.next()) {
                        String nombreVeterinario = rs2.getString("nombreVet");
                        LocalDate fechaContratacion = rs2.getDate("fechaContratacion").toLocalDate();

                        System.out.println("Mascota: " + nombreMascota + "\n" +
                                "Especie: " + especieMascota + "\n" +
                                "Veterinario: " + nombreVeterinario + "\n" +
                                "Antiguedad: " + calcularPeriodo(fechaContratacion, LocalDate.now()) + " años.");
                    } else {
                        System.out.println("No se encontraron veterinarios para la mascota " + nombreMascota);

                    }
                } while (rs.next());
            } else {
                System.out.println("No se encontraron mascotas en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void exportarAFicheroDeTexto(Statement sentencia) {
        //Me faltó estudiar el tema 11
    }

    public static long calcularPeriodo(LocalDate fechaRegistro, LocalDate fechaActual) {
        return ChronoUnit.YEARS.between(fechaRegistro, fechaActual);
    }
}
