package edu.teis.examen3aEvaluacion.Metodos;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Insert {
    static Scanner scanner = new Scanner(System.in);

    public static void mainInsertar(Statement sentencia, Scanner sc, Connection connection) {
        int opcion = 0;
        do {
            try {
                opcion = Menu.menuInsertar(scanner);
                switch (opcion) {
                    case 1:
                        Insert.nuevoVeterinario(connection);
                        break;
                    case 2:
                        Insert.nuevaMascota(sentencia);
                        break;
                    case 3:
                        System.out.println("Saliendo del menú de insertar...");
                        break;
                    default:
                        System.out.println("Opcion incorrecta.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 3);
    }

    private static void nuevoVeterinario(Connection connection) {
        try {
            System.out.println("Dame el dni del veterinario");
            String dni = scanner.nextLine();

            System.out.println("Dame el nombre del veterinario");
            String nombre = scanner.nextLine();

            System.out.println("Dame la edad del veterinario");
            int edad = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Dame la direccion del veterinario");
            String direccion = scanner.nextLine();

            System.out.println("Dame el sueldo mensual del veterinario");
            double sueldoMensual = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Dame la especialidad del veterinario");
            String especialidad = scanner.nextLine();

            System.out.println("Dame la fecha de contratacion del veterinario");
            LocalDate fechaContratacion = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            //Crear sentencia SQL para insertar
            String sql = "INSERT INTO Veterinarios VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Establecer los valores de la sentencia SQL
            preparedStatement.setString(1, dni);
            preparedStatement.setString(2, nombre);
            preparedStatement.setInt(3, edad);
            preparedStatement.setString(4, direccion);
            preparedStatement.setDouble(5, sueldoMensual);
            preparedStatement.setString(6, especialidad);
            preparedStatement.setDate(7, Date.valueOf(fechaContratacion));

            //Ejecutar sentencia SQL
            preparedStatement.executeUpdate();

            //Mostrar mensaje de exito
            System.out.println("Veterinario insertado en la base de datos...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void nuevaMascota(Statement sentencia) {
        System.out.println("Dame la id de la mascota");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Dame el nombre de la mascota");
        String nombre = scanner.nextLine();

        System.out.println("Dame la especie de la mascota");
        String especie = scanner.nextLine();

        if (!especie.equalsIgnoreCase("perro") && !especie.equalsIgnoreCase("gato") && !especie.equalsIgnoreCase("ave") && !especie.equalsIgnoreCase("exotico")) {
            throw new IllegalArgumentException("Tipo de mascota inválido");
        }

        System.out.println("Dame la raza de la mascota");
        String raza = scanner.nextLine();

        System.out.println("Dame la fecha de nacimiento");
        LocalDate fechaNac = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Dame la fecha de registro en la plataforma");
        LocalDate fechaAlta = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Dame el veterinario asignado");
        String veterinarioNombre = scanner.nextLine();
        try {
            //Consulta SQL para encontrar DNI del veterinario basado en su nombre
            ResultSet rs = sentencia.executeQuery("SELECT dni FROM Veterinarios WHERE nombreVet = '" + veterinarioNombre + "'");
            //Si se encuentra
            if (rs.next()) {
                String dni = rs.getString("dni");
                sentencia.executeUpdate("INSERT INTO Mascotas(idMascota, nombreMasc, especie, raza, fechaNac, fechaAlta, veterinario) VALUES ('" + id + "', '" + nombre + "', '" + especie+"', '" + raza + "' , '" + fechaNac + "', '" + fechaAlta + "', '" + dni + "')");
                //Mostrar mensaje de exito
                System.out.println("Mascota insertada en la base de datos...");
            } else {
                System.out.println("Veterinario no encontrado");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
