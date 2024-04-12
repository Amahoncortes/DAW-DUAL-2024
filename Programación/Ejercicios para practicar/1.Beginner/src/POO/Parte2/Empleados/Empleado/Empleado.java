package POO.Parte2.Empleados.Empleado;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {
    private String nombre;
    private double salario;
    private Date fechaIncorporacion;

    public Empleado(String nombre, double salario, Date fechaIncorporacion) {
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

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(fechaIncorporacion);
        return "--------------------------" + "\n" +
                this.getClass().getSimpleName() + "\n" +
                "nombre: " + nombre + "\n" +
                "salario: " + salario + "\n" +
                "fechaIncorporacion: " + fechaFormateada;
    }
}
