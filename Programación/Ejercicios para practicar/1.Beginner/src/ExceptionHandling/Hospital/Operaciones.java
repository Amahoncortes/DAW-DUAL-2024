package ExceptionHandling.Hospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Operaciones {
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Trabajador altaTrabajador(ArrayList<Area> area) {
        //Primero le pones los datos
        String dni, nombre, direccion;
        int edad;
        Area areaSelecc;
        int idArea;
        LocalDate fechaIncorporacion;
        String cargoHospital;
        double salario;

        boolean datosValidos;

        do {
            try {
                System.out.println("Proporcione el dni, el nombre, la edad y la direccion");
                dni = sc.nextLine();
                nombre = sc.nextLine();
                edad = sc.nextInt();
                sc.nextLine();
                direccion = sc.nextLine();

                System.out.println("Areas disponibles: " + area.toString());
                System.out.println("Introducir id de area");
                idArea = sc.nextInt();
                sc.nextLine();
                areaSelecc = area.get(idArea);

                System.out.println("Introduzca nueva fecha de incorporacion al hospital: ");
                fechaIncorporacion = LocalDate.parse(sc.nextLine(), dtf);

                System.out.println("Defina nuevo cargo y salario:");
                cargoHospital = sc.nextLine();
                salario = sc.nextDouble();
                sc.nextLine();

                datosValidos = true;
                return new Trabajador(dni, nombre, edad, direccion, fechaIncorporacion, areaSelecc, cargoHospital, salario);
            } catch (DateTimeParseException | InputMismatchException e) {
                datosValidos = false;
                System.out.println("ERROR: los datos introducidos no son correctos.");
            }
        } while (!datosValidos);
        return null;
    }


    public static Paciente altaPaciente(HashMap<Integer, Ingreso> registro) {
        String dni, nombre, direccion, patologia;
        int edad;
        int idRegistro;
        LocalDate fechaIngreso;
        LocalDate fechaSalida;
        boolean datosValidos = false;
        registro = new HashMap<>();

        do {
            try {
                System.out.println("Introduzca el dni, el nombre, la edad y la dirección");
                dni = sc.nextLine();
                nombre = sc.nextLine();
                edad = sc.nextInt();
                sc.nextLine();
                direccion = sc.nextLine();

                System.out.println("Registros disponibles" + registro);
                System.out.println("Introduzca id del registro y la patologia ");
                idRegistro = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer del scanner
                patologia = sc.nextLine();

                System.out.println("Introduzca nueva fecha de incorporacion al hospital: ");
                fechaIngreso = LocalDate.parse(sc.nextLine(), dtf);
                datosValidos = true;

                return new Paciente(dni, nombre, edad, direccion, fechaIngreso, patologia);
            } catch (DateTimeParseException | InputMismatchException e) {
                datosValidos = false;
                System.out.println("ERROR: los datos introducidos no son correctos");
            }
        } while (!datosValidos);
        return null;
    }
}
