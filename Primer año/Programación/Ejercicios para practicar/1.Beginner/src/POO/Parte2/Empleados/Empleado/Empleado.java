package POO.Parte2.Empleados.Empleado;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Empleado {
    private String nombre;
    private double salario;
    private LocalDate fechaIncorporacion;

    public Empleado(String nombre, double salario, LocalDate fechaIncorporacion) {
        this.nombre = nombre;
        this.salario = salario;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaIncorporacion.format(formatter);
        return "--------------------------" + "\n" +
                this.getClass().getSimpleName() + "\n" +
                "nombre: " + nombre + "\n" +
                "salario: " + salario + "\n" +
                "fechaIncorporacion: " + fechaFormateada;
    }
}
