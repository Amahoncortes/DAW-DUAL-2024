package ExceptionHandling.Instituto.Persona;

public abstract class Persona {
    private String dni;
    private String nombre;
    private int edad;
    private String direccion;

    public Persona() {
        this.dni = "39464067T";
        this.nombre = "Abel Mahon Cortes";
        this.edad = 28;
        this.direccion = "Calle Cañiza 45";
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

    abstract double calcularCosteAnual();

    @Override
    public String toString() {
        return "------------------------------" + "\n"
                + this.getClass().getSimpleName() + "\n" +
                "Dni: " + dni + "\n" +
                "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Direccion: " + direccion;
    }


}
