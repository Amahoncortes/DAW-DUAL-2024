public class Persona {
    private String dni;
    private String nombre;
    private int edad;
    private String direccion;

    public Persona(String dni, String nombre, int edad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Persona() {
        this.dni = "3946407T";
        this.nombre = "";
    }
}
