public class Persona {
    private String dni;
    private String nombre;
    private int edad;
    private String direccion;

    /*En cuanto a los constructores, en cada clase deberá existir uno por defecto
     que asigne valores a todos los atributos, propios y heredados;
     y otro parametrizado con todos los atributos. */

    //Constructor por defecto que asigna valores a todos los atributos
    public Persona() {
        this.dni = "";
        this.nombre = "";
        this.edad = 0;
        this.direccion = "";
    }

    public Persona(String dni, String nombre, int edad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }
}
