package Examen_Recuperacion_2daAvaliacion;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Operaciones {

    /**
     * Esta función coge un ArrayList de especialidades y pide al usuario
     * que introduzca los datos necesarios para crear un nuevo veterinario.
     * La función valida la entrada y maneja cualquier excepción posible.
     *
     * @param especialidades un Arraylist de especialidades
     * @return un nuevo objeto Veterinario
     */
    public static Veterinario crearVeterinario(List<Especialidad> especialidades) {
        Scanner scanner = new Scanner(System.in);
        Especialidad especialidadSeleccionada = null;

        try {
            System.out.println("Introduzca el dni, el nombre, la edad, y la direccion");
            String dni = scanner.nextLine();
            validarDni(dni);

            String nombre = scanner.nextLine();
            int edad = scanner.nextInt();
            scanner.nextLine();
            validarEdad(edad);

            String direccion = scanner.nextLine();

            System.out.println("Introduzca ahora el sueldo mensual");
            double sueldoMensual = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Especialidades disponibles: ");
            ensenharEspecialidades(especialidades);

            System.out.println("Introducir id de especialidad");
            int idEspecialidad = scanner.nextInt();
            scanner.nextLine();

            especialidadSeleccionada = buscarEspecialidadPorId(especialidades, idEspecialidad);


            System.out.println("Introduzca nueva fecha de contratacion en formato dd/MM/yyyy");
            LocalDate fechaContratacion = parseDate(scanner.nextLine());

            return new Veterinario(dni, nombre, edad, direccion, sueldoMensual, especialidadSeleccionada, fechaContratacion, crearRegistroMascotas());
        } catch (DniPequenhoException | EdadNegativaException e) {
            System.out.println(e.getMessage());
            return crearVeterinario(especialidades);
        }
    }

    /**
     * Crea un HashMap de mascotas, donde la clave es un entero que representa el índice de la Mascota en el HashMap
     * y el valor es la Mascota. El HashMap se rellena pidiéndole al usuario que introduzca los datos de cada Mascota.
     * hasta que el usuario decide parar mediante la introducción de "n" por teclado cuando se les pregunta si quieren
     * añadir otra Mascota.
     *
     * @return un HashMap de mascotas, que contiene las Mascotas introducidas por el usuario.
     */
    private static HashMap<Integer, Mascota> crearRegistroMascotas() {
        HashMap<Integer, Mascota> registroMascotas = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce las mascotas atendidas por el veterinario. Introduzca n para terminar: ");
        int indiceMascotas = 0;

        boolean anhadirMasMascotas = true;
        while (anhadirMasMascotas) {
            System.out.println(STR."Mascota \{indiceMascotas + 1}");
            Mascota nuevaMascota = crearMascota();
            registroMascotas.put(indiceMascotas, nuevaMascota);
            System.out.println("Desea añadir otra mascota? (s/n)");
            String respuesta = scanner.nextLine().toLowerCase();
            anhadirMasMascotas = !respuesta.equalsIgnoreCase("n");
            indiceMascotas++;
        }
        return registroMascotas;
    }

    /**
     * Crea una nueva Mascota pidiéndole al usuario que introduzca nombre, especie y raza, además
     * de la fecha de nacimiento y de registro. Si el usuario introduce una fecha en un formato inválido, o
     * una fecha del futuro, se lanza una excepción y se pide al usuario que introduzca una nueva fecha. The function
     * La función se repite hasta que el usuario introduce una fecha correcta.
     *
     * @return un objeto Mascota con la información introducida por el usuario.
     */
    private static Mascota crearMascota() {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.println("Introduzca el nombre, la especie, y la raza");
            String nombre = input.nextLine();
            String especie = input.nextLine();
            String raza = input.nextLine();

            System.out.println("Introduzca la fecha de nacimiento y la de registro: ");
            LocalDate fechaNacimiento = LocalDate.parse(input.nextLine(), dateFormat);
            if (fechaNacimiento.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Fecha de nacimiento imposible");
            }
            LocalDate fechaRegistro = LocalDate.parse(input.nextLine(), dateFormat);
            if (fechaRegistro.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Fecha de registro imposible");
            }
            return new Mascota(nombre, especie, raza, fechaNacimiento, fechaRegistro);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return crearMascota();
        }
    }

    /**
     * Elimina a todos los veterinarios que tengan la especialidad de Dermatología del ArrayList de veterinarios.
     *
     * @param veterinarios El ArrayList de veterinarios del cual se borran los que sean dermatólogos
     * @throws IllegalArgumentException si el ArrayList dado es nulo
     */
    public static void eliminarDermatologia(List<Veterinario> veterinarios) {
        if (veterinarios == null) {
            throw new IllegalArgumentException("El ArrayList de veterinarios no puede ser nulo");
        }
        System.out.println("Se ha eliminado al veterinario");
        veterinarios.removeIf(veterinario -> veterinario != null && veterinario.getEspecialidad() != null && veterinario.getEspecialidad().toString().equalsIgnoreCase("Dermatología"));
    }


    /**
     * Calcula el salario médio de los veterinarios que tengan la especialidad de Traumatología.
     *
     * @param  veterinarios  La lista de veterinarios de los cuales calculamos el salario.
     * @throws IllegalArgumentException Si la lista de veterinarios devuelve null
     */
    public static void calcularSalarioMedio(List<Veterinario> veterinarios) {
        ;
        if (veterinarios == null) {
            throw new IllegalArgumentException("El ArrayList de productos no puede ser nulo");
        }
        double salarioTotal = 0;
        int contador = 0;
        for (Veterinario veterinario : veterinarios) {
            if (veterinario.getEspecialidad() != null && veterinario.getEspecialidad().toString().equalsIgnoreCase("Traumatología")) {
                salarioTotal += veterinario.getSueldoMensual() * 14;
                contador++;
            }
        }
        if (contador > 0) {
            double salarioMedio = (salarioTotal / contador);
            System.out.println(STR."El salario medio de un veterinario de traumatología es de \{salarioMedio} euros");
        } else {
            System.out.println("No se encontró ningún veterinario de traumatología");
        }

    }

    /**
     * Lista las mascotas con una edad mayor que 6 meses que han sido registradas en el registro de cada veterinario.
     *
     * @param  veterinarios  La lista de veterinarios.
     */
    public static void listarMascotasSenior(List<Veterinario> veterinarios) {
        if(veterinarios == null) {
            throw new IllegalArgumentException("El ArrayList de veterinarios no puede ser nulo");
        }

        for (Veterinario veterinario : veterinarios) {
            if(veterinario == null || veterinario.getRegistro() == null) {
                continue;
            }
            Map<Integer, Mascota> registro = veterinario.getRegistro();
            for (Mascota mas : registro.values()) {
                if (mas == null || mas.getFechaNac() == null) {
                    continue;
                }
                if (Period.between(mas.getFechaNac(), LocalDate.now()).getYears() > 6) {
                    System.out.println(mas);
                }
            }
        }
    }

    /**
     * Valida el DNI dado por el usuario. Se asegura de que el DNI tenga exactamente 9 caracteres.
     *
     * @param  dni  El dni a validar
     * @throws DniPequenhoException  si el DNI no tiene 9 caracteres.
     */
    private static void validarDni(String dni) throws DniPequenhoException {
        if (dni.length() != 9) {
            throw new DniPequenhoException("El dni debe tener 9 caracteres");
        }
    }

    /**
     * Valida la edad dada por el usuario. Se asegura de que la edad sea mayor que 0
     *
     * @param  edad  La edad a validar
     * @throws EdadNegativaException  Si la edad es menor o igual que 0
     */
    private static void validarEdad(int edad) throws EdadNegativaException {
        if (edad <= 0) {
            throw new EdadNegativaException("La edad debe ser mayor que 0");
        }
    }

    /**
     * Imprime cada elemento de una lista de Especialidades
     *
     * @param  especialidades  La lista de especialidades a imprimir
     */
    private static void ensenharEspecialidades(List<Especialidad> especialidades) {
        especialidades.forEach(especialidad -> System.out.println(especialidad.toString()));
    }

    /**
     * Busca por un objeto Especialidad concreto en una lista de Especialidades con la id dada
     *
     * @param  especialidades  La lista de Especialidades en la que buscar
     * @param  id              La id con la que buscar el objeto Especialidad
     * @return                 La especialidad con la id dada o null si no existe
     */
    private static Especialidad buscarEspecialidadPorId(List<Especialidad> especialidades, int id) {
        for (Especialidad especialidad : especialidades) {
            if (especialidad.getId() == id) {
                return especialidad;
            }
        }
        return null;
    }

    /**
     * Analiza el formato de una fecha dada y devuelve una LocalDate
     *
     * @param  fecha  La representación de la fecha a analizar.
     * @return        Un objeto LocalDate parseado desde la fecha dada
     */
    private static LocalDate parseDate(String fecha) {
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
