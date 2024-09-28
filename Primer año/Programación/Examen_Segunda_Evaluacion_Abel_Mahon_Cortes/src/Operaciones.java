import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Operaciones {

    public static Veterinario altaVeterinario(ArrayList<Especialidad> especialidades) {
        Scanner scanner = new Scanner(System.in);
        Especialidad especialidadSeleccionada = null;

        try {
            System.out.println("Introduzca el dni, el nombre, la edad, y la direccion");
            String dni = scanner.nextLine();
            if (dni.length() != 9) {
                throw new DniPequenhoException("El DNI debe tener 9 caracteres");
            }
            String nombre = scanner.nextLine();
            int edad = scanner.nextInt();
            scanner.nextLine();
            if (edad <= 0) {
                throw new EdadNegativaException("La edad debe ser mayor que 0");
            }
            String direccion = scanner.nextLine();

            System.out.println("Introduzca ahora el sueldo mensual");
            double sueldoMensual = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Especialidades disponibles: " + "\n" + especialidades.toString());
            System.out.println("Introducir id de especialidad");
            int idEspecialidad = scanner.nextInt();
            scanner.nextLine();

            for (Especialidad especialidad : especialidades) {
                if (idEspecialidad == especialidad.getId()) {
                    especialidadSeleccionada = especialidad;
                    break;
                }
            }

            System.out.println("Introduzca nueva fecha de contratacion: ");
            LocalDate fechaContratacion = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            return new Veterinario(dni, nombre, edad, direccion, sueldoMensual, especialidadSeleccionada, fechaContratacion, crearRegistroMascotas());
        } catch (DniPequenhoException | EdadNegativaException e) {
            System.out.println(e.getMessage());
            return altaVeterinario(especialidades);
        }
    }

    private static HashMap<Integer, Mascota> crearRegistroMascotas() {
        HashMap<Integer, Mascota> registroMascotas = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce las mascotas atendidas por el veterinario. Introduzca n para terminar: ");
        int i = 0;

        boolean continuar = true;
        while (continuar) {
            System.out.println("Mascota " + i + 1);
            Mascota mascota = altaMascota();
            registroMascotas.put(i, mascota);
            System.out.println("Desea introducir otra mascota? (s/n)");
            String respuesta = scanner.nextLine().toLowerCase();
            continuar = !respuesta.equalsIgnoreCase("n");
            i++;
        }
        return registroMascotas;
    }

    private static Mascota altaMascota() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Introduzca el nombre, la especie, y la raza");
            String nombre = scanner.nextLine();
            String especie = scanner.nextLine();
            String raza = scanner.nextLine();

            System.out.println("Introduzca la fecha de nacimiento y la de registro: ");
            LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine(), dtf);
            if (fechaNacimiento.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Fecha de nacimiento imposible");
            }
            LocalDate fechaRegistro = LocalDate.parse(scanner.nextLine(), dtf);
            if (fechaRegistro.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Fecha de registro imposible");
            }
            return new Mascota(nombre, especie, raza, fechaNacimiento, fechaRegistro);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return altaMascota();
        }
    }

    public static void eliminarDermatologia(ArrayList<Veterinario> veterinarios) {
        //Crashea el programa en runtime, pero no me acuerdo de como usar Iterator.
        //        for (Veterinario veterinario : veterinarios) {
//            String especialidad = veterinario.getEspecialidad().toString();
//            if (especialidad.equalsIgnoreCase("Dermatología")) {
//                System.out.println("El veterinario " + veterinario.getNombre() + "ha sido eliminado.");
//                veterinarios.remove(veterinario);
//            }
//        }
        System.out.println("Se ha eliminado al veterinario");
        veterinarios.removeIf(veterinario -> veterinario != null && veterinario.getEspecialidad().toString().equalsIgnoreCase("Dermatología"));
    }

    public static void calcularSalarioMedio(ArrayList<Veterinario> veterinarios) {
        int contador = 0;
        double salarioMedio;
        double salarioTotal = 0.0;
        if (veterinarios == null) {
            throw new IllegalArgumentException("El ArrayList de productos no puede ser nulo");
        } else {
            for (Veterinario veterinario : veterinarios) {
                String especialidad = veterinario.getEspecialidad().getNombre();
                if (especialidad.equalsIgnoreCase("Traumatología")) {
                    salarioTotal = veterinario.getSueldoMensual() * 14;
                    contador++;
                }
            }
            salarioMedio = salarioTotal / contador;
            System.out.println("El salario medio de un veterinario de traumatología es de " + salarioMedio + " euros");
        }

    }

    public static void listarMascotasSenior(ArrayList<Veterinario> veterinarios){
        for (Veterinario veterinario:veterinarios){
            HashMap<Integer, Mascota> registro = veterinario.getRegistro();
            Collection<Mascota> mascotas = registro.values();
            for (Mascota mas:mascotas){
                //Si Period entre fechaNac y fechaActual.getYears > 6)
                System.out.println(mas);
            }
        }
    }
}
