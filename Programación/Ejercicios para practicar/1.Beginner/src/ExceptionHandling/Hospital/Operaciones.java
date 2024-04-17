package ExceptionHandling.Hospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static ExceptionHandling.Hospital.Paciente.calcularPeriodo;

public class Operaciones {

    /**
     * Crea una instancia de Trabajador con los datos proporcionados por el usuario.
     * Valida los datos y asegura que la información es correcta antes de crear el objeto Trabajador.
     *
     * @param areas Un ArrayList de objetos Area representando las Areas del Hospital.
     * @return El Paciente recién creado con la información proporcionada. Si no se pudo crear, se devuelve null.
     * @throws IllegalArgumentException Si el DNI no tiene 9 caracteres, si la edad es menor o igual a 0, si la fecha de incorporación
     *                                  no tiene el formato correcto, si el area seleccionada no existe, o la fecha de incorporación es incorrecta.
     */
    public static Trabajador crearTrabajador(ArrayList<Area> areas) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();
        Area areaSeleccionada = null;
        boolean datosValidos;

        do {
            try {
                System.out.println("Introduzca el dni, el nombre, la edad y la dirección");
                String dni = scanner.nextLine();
                if (dni.length() != 9) {
                    throw new IllegalArgumentException("El DNI tiene que tener 9 caracteres ");
                }

                String nombre = scanner.nextLine();
                int edad = scanner.nextInt();
                scanner.nextLine();
                if (edad <= 0) {
                    throw new IllegalArgumentException("La edad debe ser un número válido y mayor que 0");
                }
                String direccion = scanner.nextLine();

                System.out.println("Defina nuevo cargo y salario:");
                String cargoHospital = scanner.nextLine();
                double salario = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Áreas disponibles: " + areas.toString());
                System.out.println("Introducir id de area");
                int idArea = scanner.nextInt();
                scanner.nextLine();

                for (Area area : areas) {
                    // Áreas existentes en el hospital
                    if (idArea == area.getId()) {
                        areaSeleccionada = area;
                        break;
                    }
                }
                if (areaSeleccionada == null) {
                    datosValidos = false;
                    throw new IllegalArgumentException("El área seleccionada no coincide con ninguna de las existentes.");
                }


                System.out.println("Introduzca nueva fecha de incorporacion al hospital: ");
                LocalDate fechaIncorporacion = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                if (fechaActual.isBefore(fechaIncorporacion)) {
                    datosValidos = false;
                    throw new IllegalArgumentException("Fecha de incorporación incorrecta.");
                }

                datosValidos = true;
                return new Trabajador(dni, nombre, edad, direccion, fechaIncorporacion, areas.get(idArea - 1), cargoHospital, salario);
            } catch (DateTimeParseException | InputMismatchException e) {
                datosValidos = false;
                System.out.println("ERROR: los datos introducidos no son correctos.");
            }
        } while (!datosValidos);
        return null;
    }


    /**
     * Un método para crear una instancia de Paciente con los datos proporcionados por el usuario.
     * Valida los datos y asegura que la información es correcta antes de crear el objeto Paciente.
     *
     * @return Paciente El Paciente recién creado con la información proporcionada. Si no se pudo crear, se devuelve null.
     * @throws IllegalArgumentException Si el DNI no tiene 9 caracteres, si la edad es menor o igual a 0, si la fecha de incorporación
     *                                  no tiene el formato correcto,  o la fecha de incorporación es incorrecta.
     */
    public static Paciente crearPaciente() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaIngreso = null;


        boolean datosValidos = false;

        do {
            try {
                System.out.println("Introduzca dni, nombre, edad y dirección");
                String dni = scanner.nextLine();
                if (dni.length() != 9) {
                    throw new IllegalArgumentException("El DNI debe tener 9 caracteres ");
                }

                String nombre = scanner.nextLine();
                int edad = scanner.nextInt();
                scanner.nextLine();
                if (edad <= 0) {
                    throw new IllegalArgumentException("La edad debe ser un número válido y mayor que 0");
                }
                String direccion = scanner.nextLine();

                System.out.println("Introduzca la condición médica:");
                String condicionMedica = scanner.nextLine();


                System.out.println("Introduzca el numero de ingresos del paciente:");
                int numIngresos = scanner.nextInt();
                scanner.nextLine();
                HashMap<Integer, Ingreso> ingresos = new HashMap<>();

                for (int i = 0; i < numIngresos; i++) {
                    System.out.println("Introduzca la fecha de incorporación al hospital (dd/MM/yyyy):");
                    fechaIngreso = LocalDate.parse(scanner.nextLine(), dateFormatter);

                    if (fechaActual.isBefore(fechaIngreso)) {
                        throw new IllegalArgumentException("La fecha de ingreso no puede ser posterior a la fecha actual");
                    }

                    Area area = new Area();

                    ingresos.put(i, new Ingreso(fechaIngreso, fechaActual, area));
                }
                datosValidos = true;
                Paciente paciente = new Paciente(dni, nombre, edad, direccion, fechaIngreso, condicionMedica);
                ingresos.forEach(paciente::setIngreso); // Añadir ingresos al paciente
                return paciente;
            } catch (DateTimeParseException | InputMismatchException e) {
                datosValidos = false;
                System.out.println("ERROR: los datos introducidos no son correctos");
            }
        } while (!datosValidos);
        return null;
    }

    /**
     * Enseña información sobre los trabajadores en el sistema.
     *
     * @param personas La lista de personas, conteniendo pacientes y trabajadores
     */
    public static void consultarTrabajadores(ArrayList<Persona> personas) {
        for (Persona persona : personas) {
            if (persona instanceof Trabajador trabajador) {
                System.out.println(trabajador);
            }
        }
    }

    /**
     * Imprime la información de todos los pacientes en la lista de personas.
     *
     * @param personas La lista de personas, conteniendo pacientes y trabajadores
     */
    public static void consultarPacientes(ArrayList<Persona> personas) {
        for (Persona persona : personas) {
            if (persona instanceof Paciente paciente) {
                System.out.println(paciente);
            }
        }
    }

    /**
     * Calcula el salario medio de los trabajadores que sean enfermeros
     *
     * @param personas La lista de gente de la cual calcular el salario medio
     */
    public static void calcularSalarioMedioEnfermeria(ArrayList<Persona> personas) {
        int countEnfermeros = 0;
        double salarioTotal = 0;

        for (Persona persona : personas) {
            if (persona instanceof Trabajador) {
                if (((Trabajador) persona).getCargo().equalsIgnoreCase("Enfermero")) {
                    countEnfermeros++;
                    salarioTotal += ((Trabajador) persona).getSueldo();
                }
            }
        }
        System.out.println("Salario medio de enfermería: " + salarioTotal / countEnfermeros);
    }


    /**
     * Calcula el salario máximo para los trabajadores de la especialidad Cardiologia
     *
     * @param personas una lista de personas representando a los trabajadores
     */

    public static void calcularSalarioMaximoCardiologia(ArrayList<Persona> personas) {
        double maxSalario = 0;
        for (Persona persona : personas) {
            if (persona instanceof Trabajador trabajador) {
                if (trabajador.getCargo().equalsIgnoreCase("Medico") &&
                        trabajador.getArea().getNombre().equalsIgnoreCase("Cardiología") &&
                        trabajador.getSueldo() > maxSalario) {
                    maxSalario = trabajador.getSueldo();
                }
            }
        }
        System.out.println("Salario maximo de cardiologia: " + maxSalario);

    }


    /**
     * Calcula la duración total de la permanencia del paciente, cogiéndolo de una lista de personas.
     *
     * @param personas Una lista de objetos de tipo Persona, que contiene objetos de Paciente
     * @return void. Imprime la duración total de la estancia para cada objeto Paciente.
     */
    public static void calcularTiempoTotalIngreso(ArrayList<Persona> personas) {
        for (Persona persona : personas) {
            if (persona instanceof Paciente paciente) {
                HashMap<Integer, Ingreso> ingresos = paciente.getIngreso();
                long diasTotales = 0;

                // Calcula la duración total de cada ingreso y lo añade al total
                for (Ingreso ingreso : ingresos.values()) {
                    diasTotales += calcularPeriodo(ingreso);
                }

                System.out.println("Estancia total del paciente " + paciente.getNombre() + ": " + diasTotales + " dias.");
            }
        }
    }

    /**
     * Calcula el area con el coste más alto y lo imprime.
     *
     * @param  areas  La lista de áreas a considerar
     * @param  personas La lista de personas a considerar
     * @throws IllegalArgumentException si cualquiera de las áreas devuelve null
     * @throws IllegalStateException Si no se encuentran áreas
     */

    public static void mostrarAreaMasCosteAnual(ArrayList<Area> areas, ArrayList<Persona> personas) {
        if (areas == null || personas == null) {
            throw new IllegalArgumentException("Las listas no pueden ser nulas");
        }
        double maxCoste = 0;
        Area maxArea = null;

        HashMap<Area, Double> costesArea = new HashMap<>();

        for (Area area : areas) {
            double coste = calcularCosteArea(area, personas);
            costesArea.put(area, coste);
            if (coste > maxCoste) {
                maxCoste = coste;
                maxArea = area;
            }
        }
        if (maxArea == null) {
            throw new IllegalStateException("Áreas no encontradas");
        }
        System.out.println("El area con mayor coste anual es: " + maxArea.getNombre() + " con un coste anual de: " + maxCoste);
    }


    /**
     * Calcula el coste total para un área específica en base a las personas asociadas.
     *
     * @param  area     El área para la que se va a calcular el coste.
     * @param  personas La lista de personas asociadas al área.
     * @return          El coste total calculado para el área especificada.
     */
    private static double calcularCosteArea(Area area, ArrayList<Persona> personas) {
        double coste = 0;
        for (Persona persona : personas) {
            if (persona instanceof Paciente paciente) {
                if (paciente.getIngreso().values().iterator().next().getArea().getNombre().equalsIgnoreCase(area.getNombre())) {
                    coste += paciente.calcularCosteAnual(personas);
                }
            } else if (persona instanceof Trabajador trabajador) {
                if (trabajador.getArea().getNombre().equalsIgnoreCase(area.getNombre())) {
                    coste += trabajador.calcularCosteAnual(personas);
                }
            }
        }
        return coste;
    }
}