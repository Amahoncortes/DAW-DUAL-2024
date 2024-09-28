public class Profesor extends Miembro {
    private String tipoJornada;
    private double sueldo;
    private Especialidad especialidad;

    public Profesor() {
        this.tipoJornada = "";
        this.sueldo = 550.5;
        this.especialidad = new Especialidad();
    }

    public Profesor(String dni, String nombre, int edad, String direccion, String tipoJornada, double sueldo, Especialidad especialidad) {
        super(dni, nombre, edad, direccion);
        this.tipoJornada = tipoJornada;
        this.sueldo = sueldo;
        this.especialidad = especialidad;
    }
}
