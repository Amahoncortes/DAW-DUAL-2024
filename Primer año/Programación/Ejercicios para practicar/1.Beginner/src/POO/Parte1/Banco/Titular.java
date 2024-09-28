package POO.Parte1.Banco;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


/*Vamos a crear una clase Titular.
Atributos: nombre, fecha de nacimiento, DNI, sexo y direccion. Asignar valores por defecto a todos los atributos seg�n su tipo.
 * Sexo ser� hombre por defecto, se deber� usar una constante para ello.

Constructores:
 * Uno por defecto.
 * Uno que reciba nombre, fecha de nacimiento y sexo, resto por defecto.
 * Otro con todos los atributos como par�metro.
M�todos:
 * boolean esMayorDeEdad()
  * void comprobarSexo(char sexo): comprueba que el sexo introducido sea correcto.Si es incorrecto, asignar� H.
 * toString()

A continuaci�n, sustituye en la clase Cuenta todas las referencias al titular, para que, en vez de
gestionar sus datos a trav�s de atributos, lo realice mediante un objeto de tipo Titular.*/
public class Titular {
    private final String nombre;
    private final String fechaNac;
    private final String dni;
    private char sexo = 'H';
    private final String direccion;


    //Constructor por defecto
    public Titular() {
        this.nombre = "";
        this.fechaNac = "";
        this.dni = "";
        this.direccion = "";
    }

    //Uno que reciba nombre, fecha de nacimiento y sexo, resto por defecto.


    public Titular(String nombre, String fechaNac, char sexo) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.dni = "";
        this.direccion = "";
    }

    //Otro con todos los atributos
    public Titular(String nombre, String fechaNac, String dni, char sexo, String direccion) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.sexo = sexo;
        this.direccion = direccion;
    }


    public String getNombre() {
        return nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getDni() {
        return dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    // Método público que devuelve un booleano que indica si la persona es mayor de edad.
    public boolean esMayorDeEdad() {
        // Obtiene la fecha actual en formato local.
        LocalDate fechaLocalActual = LocalDate.now();
        // Define un formateador de fecha para el patrón dd/MM/yyyy.
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Convierte la fecha de nacimiento de la persona (almacenada en un String) en un objeto LocalDate utilizando el formateador definido anteriormente.
        LocalDate fechaNac = LocalDate.parse(this.fechaNac, dtf);
        // Calcula el período entre la fecha de nacimiento y la fecha actual.
        Period periodo = Period.between(fechaNac, fechaLocalActual);
        // Devuelve true si la diferencia en años entre la fecha de nacimiento y la fecha actual es mayor o igual a 18, indicando que la persona es mayor de edad.
        return periodo.getYears() >= 18;
    }


    /*
     * void comprobarSexo(char sexo): comprueba que el sexo introducido sea correcto.Si es incorrecto, asignar� H.
     */

    public void comprobarSexo(char sexo){
        if(sexo != 'H' && sexo != 'M'){
            System.out.println("Error. Sexo introducido incorrecto.");
            this.sexo = 'H';
        }
    }

    @Override
    public String toString() {
        return "Titular" +
                "Nombre: " + nombre + "\n" +
                "fechaNac: " + fechaNac + "\n" +
                "dni: " + dni + "\n" +
                "sexo: " + sexo + "\n" +
                "direccion: " + direccion + "\n";
    }
}
