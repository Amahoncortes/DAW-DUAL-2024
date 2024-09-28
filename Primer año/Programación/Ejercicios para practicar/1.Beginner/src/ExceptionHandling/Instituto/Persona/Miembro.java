package ExceptionHandling.Instituto.Persona;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Miembro extends Persona {
    //Sobre los miembros del instituto se deberán almacenar los datos propios de persona (el DNI,
    //el nombre, la edad y la dirección) y la fecha de incorporación al centro como atributo propio.
    private LocalDate fechaIncorporacion;



    //En cuanto a los constructores, en cada clase deberá existir uno por defecto que asigne
    //valores a todos los atributos, propios y heredados; y otro parametrizado con todos los
    //atributos.
    public Miembro() {
        super();
        this.fechaIncorporacion = LocalDate.parse("05/05/1995");
    }

    public Miembro(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion) {
        super(dni, nombre, edad, direccion);
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = dtf.format(fechaIncorporacion);
        return super.toString() + "\n" +
                "Fecha de incorporación: " + fechaFormateada;
    }

    public abstract void aplicarBonificacion();

    /*
     * Calcula la diferencia entre dos fechas, la fecha de incorporación y la actual
     * */
    public Period calcularPeriodo() {
        LocalDate fechaIncorporacion = this.fechaIncorporacion;
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaIncorporacion, fechaActual);
    }
}
