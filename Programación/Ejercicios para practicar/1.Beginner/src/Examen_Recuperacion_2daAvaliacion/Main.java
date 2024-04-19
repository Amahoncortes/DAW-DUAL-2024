package Examen_Recuperacion_2daAvaliacion;

import java.util.*;

import static Examen_Recuperacion_2daAvaliacion.Operaciones.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        List<Veterinario> veterinarios = new ArrayList<>();
        List<Especialidad> especialidad = new ArrayList<>();
        inicializarEspecialidades(especialidad);

        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                   veterinarios.add(crearVeterinario(especialidad));
                    break;
                case 2:
                    eliminarDermatologia(veterinarios);
                    break;
                case 3:
                    calcularSalarioMedio(veterinarios);
                    break;
                case 4:
                    listarMascotasSenior(veterinarios);
                    break;
            }
        }
        while (opcion != 5);
    }

    private static void mostrarMenuPrincipal() {
        //Encabezado
        System.out.println("-----------------------------");
        System.out.println("Menú de Clinica Veterinaria");
        System.out.println("-----------------------------");

        System.out.println("Seleccione lo que desea realizar:");
        System.out.println("1: Alta veterinarios");
        System.out.println("2: Eliminar dermatologos");
        System.out.println("3: Salario medio traumatologia");
        System.out.println("4: Listar mascotas senior");
        System.out.println("5: Salir");
    }

    private static void inicializarEspecialidades(List<Especialidad> especialidades){
        Examen_Recuperacion_2daAvaliacion.Especialidad e0 = new Examen_Recuperacion_2daAvaliacion.Especialidad(1, "Cardiología");
        Examen_Recuperacion_2daAvaliacion.Especialidad e1 = new Examen_Recuperacion_2daAvaliacion.Especialidad(2, "Dermatología");
        Examen_Recuperacion_2daAvaliacion.Especialidad e2 = new Examen_Recuperacion_2daAvaliacion.Especialidad(3, "Cardiología");
        Examen_Recuperacion_2daAvaliacion.Especialidad e3 = new Examen_Recuperacion_2daAvaliacion.Especialidad(4, "Traumatología");
        Examen_Recuperacion_2daAvaliacion.Especialidad e4 = new Examen_Recuperacion_2daAvaliacion.Especialidad(5, "Oncología");

        especialidades.add(e0);
        especialidades.add(e1);
        especialidades.add(e2);
        especialidades.add(e3);
        especialidades.add(e4);
    }
}
