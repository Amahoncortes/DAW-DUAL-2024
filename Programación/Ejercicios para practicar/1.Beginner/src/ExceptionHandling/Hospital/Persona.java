package ExceptionHandling.Hospital;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

//datos propios de persona (el DNI,
//el nombre, la edad y la dirección)
public abstract class Persona {
    private String dni;
    private String nombre;
    private int edad;
    private String direccion;

    //En cuanto a los constructores, en cada clase deberá existir uno por defecto que
    //asigne valores a todos los atributos, propios y heredados; y otro parametrizado con
    //todos los atributos.


    public Persona() {
        this.dni = "39464067T";
        this.nombre = "Abel";
        this.edad = 28;
        this.direccion = "CC45";
    }

    public Persona(String dni, String nombre, int edad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\n" +
                "Dni: " + dni + "\n" +
                "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Direccion: " + direccion;
    }


    public abstract double calcularCosteAnual(ArrayList<Persona> personas);
}
