package Examen_Recuperacion_2daAvaliacion;

public abstract class Persona {
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
        return STR."\{this.getClass().getSimpleName()}\nDNI: \{dni}\nNombre: \{nombre}\nEdad: \{edad}\nDireccion: \{direccion}";
    }

}
