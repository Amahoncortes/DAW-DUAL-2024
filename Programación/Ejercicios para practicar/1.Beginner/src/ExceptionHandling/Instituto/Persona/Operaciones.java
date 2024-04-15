package ExceptionHandling.Instituto.Persona;

import ExceptionHandling.Instituto.Especialidad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operaciones {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static Scanner sc = new Scanner(System.in);

    private static Alumno crearAlumno() {
        String dni, nombre, direccion, ciclo;
        int edad;
        double mediaNotas, importeMatricula;
        LocalDate fechaIncorporacion;
        boolean datosValidos;

        do {
            datosValidos = true; // Inicializamos como verdadero en cada iteración
            try {
                System.out.println("Dame el dni, el nombre, la edad, y la direccion");
                dni = sc.nextLine();
                nombre = sc.nextLine();
                edad = sc.nextInt();
                sc.nextLine(); // Limpiamos el buffer
                direccion = sc.nextLine();

                System.out.println("Introduzca ahora ciclo, nota media, importe de matrícula");
                ciclo = sc.nextLine();
                mediaNotas = sc.nextDouble();
                importeMatricula = sc.nextDouble();

                System.out.println("Dame la fecha de incorporacion");
                fechaIncorporacion = LocalDate.parse(sc.nextLine(), dtf);

                // Si llegamos aquí, todos los datos son válidos
                return new Alumno(dni, nombre, edad, direccion, fechaIncorporacion, ciclo, mediaNotas, importeMatricula);
            } catch (DateTimeParseException | InputMismatchException e) {
                datosValidos = false;
                System.out.println("ERROR: Los datos introducidos no son correctos.");
                sc.nextLine(); // Limpiamos el buffer para evitar un bucle infinito
            }
        } while (!datosValidos);
        return null;
    }

    private static Profesor crearProfesor() {

        Scanner sc = new Scanner(System.in);
        String dni, nombre, direccion, tipoJornada;
        int edad, idEsp;
        double sueldo;
        Date fechaInc;
        boolean datosValidos = false;

        do{
        try {
            System.out.println("Dame el dni");
            dni = sc.next(); // Leer el DNI
            sc.nextLine(); // Limpiar el búfer de entrada

            System.out.println("Dame el nombre");
            nombre = sc.nextLine();

            System.out.println("Dame la edad");
            edad = sc.nextInt();
            sc.nextLine(); // Limpiar el búfer de entrada

            System.out.println("Dame la direccion");
            direccion = sc.nextLine();

            System.out.println("Dame la fecha de incorporacion");
            fechaIncorporacion = LocalDate.parse(sc.next(), dtf);
            sc.nextLine();

            System.out.println("Dame el tipo de jornada");
            tipoJornada = sc.next();
            sc.nextLine();

            System.out.println("Dame el sueldo");
            sueldo = sc.nextDouble();
            sc.nextLine();

            System.out.println("Creando especialidad... ");
            System.out.println("Introduce id: ");
            String id = sc.next();
            sc.nextLine();

            System.out.println("Introduce un nombre");
            String nombreEspecialidad = sc.nextLine();
            especialidad = new Especialidad(id, nombreEspecialidad);

        } catch (DateTimeParseException dt) {
            System.out.println("Formato de fecha incorrecto");
        } catch (InputMismatchException e) {
            System.out.println("Formato de entrada incorrecto");
        }

        return new Profesor(dni, nombre, edad, direccion, fechaIncorporacion, tipoJornada, sueldo, especialidad);
    }
}
