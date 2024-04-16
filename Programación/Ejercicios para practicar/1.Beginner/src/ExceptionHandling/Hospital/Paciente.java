package ExceptionHandling.Hospital;

import java.time.LocalDate;
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
    private HashMap<Integer, Ingreso> registro;

    public Paciente() {
        this.fechaIngreso = LocalDate.now();
        this.patologia = "gripe";
        this.registro = new HashMap<>();
    }

    public Paciente(String dni, String nombre, int edad, String direccion, LocalDate fechaIngreso, String patologia) {
        super(dni, nombre, edad, direccion);
        this.fechaIngreso = fechaIngreso;
        this.patologia = patologia;
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

    public void setRegistro(HashMap<Integer, Ingreso> registro) {
        this.registro = registro;
    }

    public HashMap<Integer, Ingreso> getRegistro() {
        return registro;
    }

    public double calcularCosteAnual(ArrayList<Persona> personas) {
        double costeTotal = 0;
        for (Persona persona : personas) {
            if (persona instanceof Paciente) {
                HashMap<Integer, Ingreso> registro = ((Paciente) persona).getRegistro();
                for (int i = 0; i < registro.size(); i++) {
                    Ingreso ingreso = registro.get(i);
                    costeTotal = calcularPeriodo(ingreso);
                    costeTotal *= 700;
                    if (ingreso.getArea().getEspecialidad().equalsIgnoreCase("Traumatología")) {
                        double plus = costeTotal * 0.02;
                        costeTotal += plus;
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
                "Registro: " + registro;
    }

}