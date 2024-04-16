package ExceptionHandling.Hospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//la fecha de incorporación, el área sanitaria en la
//que trabaja, su cargo en el hospital y su salario
public class Trabajador extends Persona {
    private LocalDate fechaIncorporacion;
    private Area areaSanitaria;
    private String cargoHospital;
    private double salario;

    public Trabajador() {
        this.fechaIncorporacion = LocalDate.now();
        this.areaSanitaria = new Area();
        this.cargoHospital = "celador";
        this.salario = 1500;
    }

    public Trabajador(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion, Area areaSanitaria, String cargoHospital, double salario) {
        super(dni, nombre, edad, direccion);
        this.fechaIncorporacion = fechaIncorporacion;
        this.areaSanitaria = areaSanitaria;
        this.cargoHospital = cargoHospital;
        this.salario = salario;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Area getAreaSanitaria() {
        return areaSanitaria;
    }

    public void setAreaSanitaria(Area areaSanitaria) {
        this.areaSanitaria = areaSanitaria;
    }

    public String getCargoHospital() {
        return cargoHospital;
    }

    public void setCargoHospital(String cargoHospital) {
        this.cargoHospital = cargoHospital;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcularCosteAnual(ArrayList<Persona> personas) {
        double costeTotal = 0;
        for (Persona persona : personas) {
            if (persona instanceof Trabajador) {
                costeTotal = ((Trabajador) persona).getSalario() * 14;
                double plus = costeTotal * 0.05;
                costeTotal += plus;
                System.out.println(persona.getNombre() + " :" + " Coste anual de: " + costeTotal + " euros.");
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
                "Area sanitaria: " + areaSanitaria + "\n" +
                "Cargo que ocupa: " + cargoHospital + "\n" +
                "Salario: " + salario;
    }
}
