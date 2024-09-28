package edu.teis.examen3aEvaluacion.Metodos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {

    static Scanner sc = new Scanner(System.in);

    public static void mainBorrar(Statement sentencia, Scanner sc) {
        int opcion = 0;

        do {
            opcion = Menu.menuBorrar(sc);

            switch (opcion) {
                case 1:
                    borrarMascota(sentencia);
                    break;
                case 2:
                    borrarVeterinario(sentencia);
                    break;

            }
        } while (opcion != 3);
    }

    /**
     * Este método permite al usuario eliminar una mascota de la base de datos basado en el nombre de la mascota.
     *
     * @param sentencia El objeto Statement SQL para ejecutar consultas.
     */
    public static void borrarMascota(Statement sentencia) {
        // Solicitar al usuario que ingrese el nombre de la mascota que se desea eliminar
        System.out.println("Introduce el nombre de la mascota que quieres borrar: ");
        String nombreMascota = sc.nextLine();

        try {
            // Ejecutar consulta SQL para seleccionar la id de la mascota basada en el nombre
            ResultSet rs = sentencia.executeQuery("SELECT idMascota FROM Mascotas WHERE nombreMasc = '" + nombreMascota + "'");

            // Verificar si la mascota existe
            if (rs.next()) {
                // Solicitar confirmación para eliminar la mascota
                System.out.println("¿Seguro que deseas eliminar la mascota? y/n");
                String confirmar = sc.nextLine();

                // Si se confirma, eliminar la mascota
                if (confirmar.equals("y")) {
                    sentencia.executeUpdate("DELETE FROM Mascotas WHERE nombreMasc = '" + nombreMascota + "'");
                    System.out.println("Mascota eliminada...");
                } else {
                    System.out.println("Operación finalizada");
                }
            } else {
                System.out.println("La mascota '" + nombreMascota + "' no se encontró en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este método se utiliza para eliminar un veterinario de la base de datos.
     * Primero verifica si el veterinario existe en la base de datos y luego lo elimina.
     * También maneja el caso en el que el veterinario no existe en la base de datos.
     *
     * @param sentencia El objeto de declaración SQL utilizado para ejecutar las consultas.
     */
    private static void borrarVeterinario(Statement sentencia) {
        // Solicitar al usuario que ingrese el nombre del veterinario que desea eliminar
        System.out.println("Dame el nombre del veterinario que deseas eliminar");
        String nombreVeterinario = sc.nextLine();

        try {
            // Ejecutar una consulta SQL para verificar si el veterinario existe en la base de datos
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM Veterinarios WHERE nombreVet = '" + nombreVeterinario + "'");

            if (resultado.next()) {
                // Obtener el DNI del veterinario
                String veterinarioDNI = resultado.getString("DNI");

                // Eliminar al veterinario de la base de datos
                sentencia.executeUpdate("DELETE FROM Veterinarios WHERE nombreVet = '" + nombreVeterinario + "'");
                System.out.println("Veterinario eliminado.");
            } else {
                // Si el veterinario no existe en la base de datos, imprimir un mensaje de error
                System.out.println("Error: El veterinario '" + nombreVeterinario + "' no existe en la base de datos.");
            }
        } catch (SQLException e) {
            // Si ocurre una excepción durante la eliminación del veterinario, imprimir un mensaje de error
            System.err.println("Se ha producido un error al eliminar el veterinario.");
            System.out.println(e.getMessage());
        }
    }


}
