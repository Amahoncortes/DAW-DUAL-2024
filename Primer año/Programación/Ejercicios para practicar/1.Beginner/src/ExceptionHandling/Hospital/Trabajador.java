package ExceptionHandling.Hospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//la fecha de incorporación, el área sanitaria en la
//que trabaja, su cargo en el hospital y su salario
public class Trabajador extends Persona {
    private LocalDate fechaIncorporacion;
    private Area area;
    private String cargo;
    private double sueldo;

    public Trabajador() {
        this.fechaIncorporacion = LocalDate.now();
        this.area = new Area();
        this.cargo = "celador";
        this.sueldo = 1500;
    }

    public Trabajador(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion, Area area, String cargo, double sueldo) {
        super(dni, nombre, edad, direccion);
        this.fechaIncorporacion = fechaIncorporacion;
        this.area = area;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }


    /**
     * Calcula el coste anual para una lista de empleados
     * @param  personas  La lista de empleados cuyo coste hay que calcular.
     * Se supone que la lista contiene solo objetos de tipo Trabajador
     * @return El coste total anual para todos los empleados.
     */
    @Override
    public double calcularCosteAnual(ArrayList<Persona> personas) {
        double costeTotal = 0;
        for (Persona persona : personas) {
            if (persona instanceof Trabajador trabajador) {
                double costeParcial = trabajador.getSueldo() * 14;
                double plus = costeParcial * 0.05;
                costeTotal += costeParcial + plus;
                System.out.println(persona.getNombre() + ":" + " Coste anual de: " + costeTotal + " euros.");
            }
        }
        return costeTotal;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = dtf.format(fechaIncorporacion);
        return super.toString() + "\n" +
                "Fecha de incorporación: " + fechaFormateada + "\n" +
                "Area sanitaria: " + area + "\n" +
                "Cargo que ocupa: " + cargo + "\n" +
                "Salario: " + sueldo;
    }
}
