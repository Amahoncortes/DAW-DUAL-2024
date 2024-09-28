package ExceptionHandling.Instituto.Persona;

import ExceptionHandling.Instituto.Especialidad;

import java.time.LocalDate;

//Para los profesores se registrará el tipo de jornada (parcial o completa), su sueldo y la
//especialidad que imparte.
public class Profesor extends Miembro {
    private String tipoJornada;
    private double sueldo;
    private Especialidad especialidad;


    public Profesor() {
        super();
        this.tipoJornada = "Completa";
        this.sueldo = 1500;
        this.especialidad = new Especialidad(1, "Fisica Aplicada");
    }

    public Profesor(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion, String tipoJornada, double sueldo, Especialidad especialidad) {
        super(dni, nombre, edad, direccion, fechaIncorporacion);
        this.tipoJornada = tipoJornada;
        this.sueldo = sueldo;
        this.especialidad = especialidad;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tipo de jornada: " + tipoJornada + "\n" +
                "Sueldo: " + sueldo + "\n" +
                "Especialidad: " + especialidad;
    }

    //Existirá un método común a alumnos y profesores, aplicarBonificacion, que en función de la
    //clase sobre la que se implemente, actuará de una manera u otra:
    //• En el caso de profesores, si su incorporación al centro fue hace más de 3 años, su
    //sueldo se incrementará en un 15%.
    @Override
    public void aplicarBonificacion() {
        if (calcularPeriodo().getYears() > 3) {
            double incremento = sueldo * 0.15;
            sueldo += incremento;
        }
    }
}
