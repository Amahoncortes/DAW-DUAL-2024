package ExceptionHandling.Instituto;
import ExceptionHandling.Instituto.Persona.Alumno;
import ExceptionHandling.Instituto.Persona.Miembro;
import ExceptionHandling.Instituto.Persona.Profesor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operaciones {
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Alumno crearAlumno() {
        String dni, nombre, direccion, ciclo;
        int edad;
        double mediaNotas, importeMatricula;

        boolean datosValidos = false;

        do {
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
                sc.nextLine();

                System.out.println("Dame la fecha de incorporacion");

                LocalDate fechaIncorporacion = LocalDate.parse(sc.nextLine(), dtf);

                // Si llegamos aquí, todos los datos son válidos
                datosValidos = true;
                return new Alumno(dni, nombre, edad, direccion, fechaIncorporacion, ciclo, mediaNotas, importeMatricula);
            } catch (DateTimeParseException | InputMismatchException e) {
                datosValidos = false;
                System.out.println("ERROR: Los datos introducidos no son correctos.");
            }
        } while (!datosValidos);
        return null;
    }

    public static Profesor crearProfesor(ArrayList<Especialidad> espec) {

        Scanner sc = new Scanner(System.in);
        String dni, nombre, direccion, tipoJornada;
        int edad, idEsp;
        double sueldo;
        LocalDate fechaIncorporacion;
        boolean datosValidos = false;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            try {
                System.out.println("Dame el dni, el nombre, la edad, y la dirección");
                dni = sc.nextLine();
                nombre = sc.nextLine();
                edad = sc.nextInt();
                direccion = sc.nextLine();


                System.out.println("Dame el tipo de jornada y el sueldo");
                tipoJornada = sc.nextLine();
                sueldo = sc.nextDouble();
                sc.nextLine();

                System.out.println("Especialidades disponibles: " +espec.toString());
                System.out.println("Introducir id de especialidad: ");
                idEsp = sc.nextInt();
                sc.nextLine();

                System.out.println("Introducir fecha de incorporación al centro (dd/MM/yyyy)");
                fechaIncorporacion = LocalDate.parse(sc.nextLine(), dtf);
                datosValidos = true;
                return new Profesor(dni, nombre, edad, direccion, fechaIncorporacion, tipoJornada, sueldo, espec.get(idEsp));

            } catch (DateTimeParseException | InputMismatchException e) {
                datosValidos = false;
                System.out.println("ERROR: Los datos introducidos no son correctos");
            }
        } while (!datosValidos);
        return null;
    }

    public static void consultas(int codigo, ArrayList<Miembro> miembros) {
        for (Miembro miembro : miembros) {
            System.out.println("-----------------");
            if (codigo == 1 && miembro instanceof Alumno) {
                System.out.println(miembro);
            }
            if (codigo == 2 && miembro instanceof Profesor) {
                System.out.println(miembro);
            }
        }
    }

    public static void edadMediaProfesores(ArrayList<Miembro> miembros) {
        int sumaEdad = 0;
        int contProfesores = 0;

        System.out.println("Mostrando edad media de los profesores...");
        for (Miembro miembro : miembros) {
            if (miembro instanceof Profesor) {
                sumaEdad += miembro.getEdad();
                contProfesores++;
            }
        }
        System.out.println("Edad media " + sumaEdad / contProfesores);
    }

    public static void notaMediaAlumnos(ArrayList<Miembro> miembros) {
        double sumaNota = 0;
        int contNotas = 0;
        for (Miembro miembro : miembros) {
            if (miembro instanceof Alumno && ((Alumno) miembro).getCiclo().equalsIgnoreCase("dam")) {
                sumaNota += ((Alumno) miembro).getMediaNotas();
                contNotas++;
            }
        }
        System.out.println("Nota media " + sumaNota / contNotas);
    }

    public static void sueldoMedioProfesores(ArrayList<Miembro> miembros) {
        double sumaSueldo = 0;
        int contSueldos = 0;
        for (Miembro miembro : miembros) {
            if (miembro instanceof Profesor) {
                sumaSueldo += ((Profesor) miembro).getSueldo();
                contSueldos++;
            }
        }
        System.out.println("Sueldo medio " + sumaSueldo / contSueldos);
    }
}
