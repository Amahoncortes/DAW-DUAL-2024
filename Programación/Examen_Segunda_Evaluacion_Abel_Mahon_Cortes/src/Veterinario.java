import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Veterinario extends Persona implements ClinicaInterface {
    private double sueldoMensual;
    private Especialidad especialidad;
    private LocalDate fechaContratacion;

    private HashMap<Integer, Mascota> registro;

    public Veterinario(String dni, String nombre, int edad, String direccion, double sueldoMensual, Especialidad especialidad, LocalDate fechaContratacion, HashMap<Integer, Mascota> registro) {
        super(dni, nombre, edad, direccion);
        this.sueldoMensual = sueldoMensual;
        this.especialidad = especialidad;
        this.fechaContratacion = fechaContratacion;
        this.registro = registro;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public HashMap<Integer, Mascota> getRegistro() {
        return registro;
    }

    public void setRegistro(HashMap<Integer, Mascota> registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = dtf.format(fechaContratacion);
        return super.toString() + "\n" +
                "Sueldo mensual: " + sueldoMensual + "\n" +
                "Especialidad: " + especialidad + "\n" +
                "Fecha de contratacion: " + fechaFormateada;
    }

    @Override
    public void calcularCoste(ArrayList<Veterinario> veterinarios) {
        double costeTotal = 0;
        for (Veterinario veterinario : veterinarios) {
            if (veterinario.getEdad() > 40) {
                double costeParcial = veterinario.getSueldoMensual() * 14;
                double plus = costeParcial * 0.10;
                costeTotal += costeParcial + plus;
                System.out.println(veterinario.getNombre() + " : " + " Coste anual de: " + costeTotal + "euros");
            }
        }


    }

}
