package ExceptionHandling.Hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static ExceptionHandling.Hospital.Operaciones.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        ArrayList<Persona> personas = new ArrayList<>();
        ArrayList<Area> especialidad = new ArrayList<>();

        inicializarAreas(especialidad);

        do {
            mostrarMenuPrincipal();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    gestionarAltas(sc, personas, especialidad);
                    break;
                case 2:
                    consultarInformacion(sc, personas);
                    break;
                case 3:
                    calcularSalarioMedioEnfermeria(personas);
                    break;
                case 4:
                    calcularSalarioMaximoCardiologia(personas);
                    break;
                case 5:
                    calcularTiempoTotalIngreso(personas);
                    break;
                case 6:
                    mostrarAreaMasCosteAnual(especialidad, personas);
                    break;
            }
        } while (opcion != 7);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("*********************");
        System.out.println("MENU DEL HOSPITAL");
        System.out.println("*********************");
        System.out.println("1.Dar de alta");
        System.out.println("2.Consulta de informacion");
        System.out.println("3.Mostrar salario medio de los enfermeros");
        System.out.println("4.Mostrar el salario maximo de los cardiologos");
        System.out.println("5.Mostrar tiempo total de ingreso de cada paciente");
        System.out.println("6.Mostrar Área Sanitaria con mayor coste anual este año");
        System.out.println("7.Salir");
        System.out.println("*********************");
    }

    private static void mostrarMenuAltas() {
        System.out.println("""
                ¿Deseas dar de alta a un trabajador o a un paciente?
                1.Trabajador
                2.Paciente
                3.Salir""");
    }

    private static void mostrarMenuConsultas() {
        System.out.println("Consulta de información");
        System.out.println("Seleccione el tipo de información a consultar:");
        System.out.println("1. Información de trabajadores");
        System.out.println("2. Información de pacientes");
    }

    /**
     * Inicializa la lista de areas con valores por defecto
     *
     * @param areas La lista de áreas a inicializar
     */

    private static void inicializarAreas(List<Area> areas) {
        Area a0 = new Area(1, "Cardiología");
        Area a1 = new Area(2, "Pediatría");
        Area a2 = new Area(3, "Traumatología");
        Area a3 = new Area(4, "Neumología");
        Area a4 = new Area(5, "Oncología");

        areas.add(a0);
        areas.add(a1);
        areas.add(a2);
        areas.add(a3);
        areas.add(a4);
    }

    private static void gestionarAltas(Scanner sc, List<Persona> personas, ArrayList<Area> especialidad) {
        int opcionAltas;
        do {
            mostrarMenuAltas();
            opcionAltas = sc.nextInt();
            switch (opcionAltas) {
                case 1:
                    personas.add(Operaciones.crearTrabajador(especialidad));
                    break;
                case 2:
                    personas.add(Operaciones.crearPaciente());
                    break;
            }
        } while (opcionAltas != 3);
    }

    private static void consultarInformacion(Scanner sc, ArrayList<Persona> personas) {
        mostrarMenuConsultas();
        int opcionConsultas = sc.nextInt();
        switch (opcionConsultas) {
            case 1:
                consultarTrabajadores(personas);
                break;
            case 2:
                consultarPacientes(personas);
                break;
        }
    }
}
