package Examen_Recuperacion_2daAvaliacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Mascota implements ClinicaInterface {
    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fechaNac;
    private LocalDate fechaRegistro;

    public Mascota(String nombre, String especie, String raza, LocalDate fechaNac, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechaNac = fechaNac;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimientoFormateada = dtf.format(fechaNac);
        String fechaRegistroFormateada = dtf.format(fechaRegistro);
        return this.getClass().getSimpleName() + "\n" +
                "Nombre: " + nombre + "\n" +
                "Especie: " + especie + "\n" +
                "Raza: " + raza + "\n" +
                "Fecha de nacimiento: " + fechaNacimientoFormateada + "\n" +
                "Fecha de registro: " + fechaRegistroFormateada;
    }

    @Override
    public void calcularCoste(ArrayList<Veterinario> veterinarios) {
        long costeTotal = 0;
        long costeParcial = 0;
        costeParcial = calcularPeriodo(fechaRegistro, LocalDate.now());
        costeTotal = costeParcial * 150;
        System.out.println("Coste total de la mascota: " + costeTotal);
    }

    public static long calcularPeriodo(LocalDate fechaRegistro, LocalDate fechaActual) {
        return ChronoUnit.YEARS.between(fechaRegistro, fechaActual);
    }
}
