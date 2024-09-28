import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ArrayList<Veterinario> veterinarios = new ArrayList<>();
        ArrayList<Especialidad> especialidad = new ArrayList<>();
        inicializarEspecialidades(especialidad);

        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                   veterinarios.add(Operaciones.altaVeterinario(especialidad));
                    break;
                case 2:
                    Operaciones.eliminarDermatologia(veterinarios);
                    break;
                case 3:
                    Operaciones.calcularSalarioMedio(veterinarios);
                    break;
                case 4:
                    //listarMascotasSenior(veterinarios);
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

    private static void inicializarEspecialidades(ArrayList<Especialidad> especialidades){
        Especialidad e0 = new Especialidad(1, "Cardiología");
        Especialidad e1 = new Especialidad(2, "Dermatología");
        Especialidad e2 = new Especialidad(3, "Cardiología");
        Especialidad e3 = new Especialidad(4, "Traumatología");
        Especialidad e4 = new Especialidad(5, "Oncología");

        especialidades.add(e0);
        especialidades.add(e1);
        especialidades.add(e2);
        especialidades.add(e3);
        especialidades.add(e4);
    }
}
