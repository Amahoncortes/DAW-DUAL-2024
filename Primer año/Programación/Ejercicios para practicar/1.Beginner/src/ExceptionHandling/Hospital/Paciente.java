package ExceptionHandling.Hospital;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

//En el caso de los pacientes, se almacenarán los datos propios de persona (el DNI,
//el nombre, la edad y la dirección), la fecha de ingreso, patología actual y áreas en
//las que ha sido ingresado a lo largo del tiempo. Dicho registro deberá realizarse
//empleando una estructura que emplee un identificador como clave y un valor que
//contenga fecha de ingreso, fecha de salida y área en la que ha sido ingresado.
public class Paciente extends Persona {
    private LocalDate fechaIngreso;
    private String patologia;
    private HashMap<Integer, Ingreso> ingreso;

    public Paciente() {
        this.fechaIngreso = LocalDate.now();
        this.patologia = "gripe";
        this.ingreso = new HashMap<>();
    }

    public Paciente(String dni, String nombre, int edad, String direccion, LocalDate fechaIngreso, String patologia) {
        super(dni, nombre, edad, direccion);
        this.fechaIngreso = fechaIngreso;
        this.patologia = patologia;
        this.ingreso = new HashMap<>();
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public void setIngreso(Integer id, Ingreso ingreso){
        this.ingreso.put(id,ingreso);
    }

    public HashMap<Integer, Ingreso> getIngreso() {
        return ingreso;
    }

    /**
     * Calcula el coste anual para una lista de pacientes.
     *
     * @param  personas  La lista de pacientes cuyo coste hay que calcular.
     * @return El coste anual total para todos los pacientes.
     */
    public double calcularCosteAnual(ArrayList<Persona> personas) {
        double costeTotal = 0;
        for (Persona persona : personas) {
            if (persona instanceof Paciente paciente) {
                HashMap<Integer, Ingreso> registro = paciente.getIngreso();
                for (Ingreso ingreso : registro.values()) {
                    double coste = calcularPeriodo(ingreso);
                    costeTotal += coste * 700;
                    if (ingreso.getArea().getNombre().equalsIgnoreCase("Traumatología")) {
                        costeTotal += costeTotal * 0.02;
                    }
                }
                System.out.println(persona.getNombre() + " :" + "Coste anual de :" + costeTotal + " euros.");
            }
        }
        return costeTotal;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Fecha de ingreso: " + fechaIngreso + "\n" +
                "Patología: " + patologia + "\n" +
                "Registro: " + ingreso;
    }


    public static long calcularPeriodo(Ingreso ingreso) {
        LocalDate fechaDeEntrada = ingreso.getFechaIngreso();
        LocalDate fechaDeSalida = ingreso.getFechaSalida();
        return ChronoUnit.DAYS.between(fechaDeEntrada, fechaDeSalida);
    }
}