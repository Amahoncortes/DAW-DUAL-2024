public class Alumno extends Miembro {

    private String cicloActual;
    private double mediaNotas;
    private double importeMatricula;


    public Alumno() {
        this.cicloActual = "";
        this.mediaNotas = 8.5;
        this.importeMatricula = 20.5;
    }

    public Alumno(String dni, String nombre, int edad, String direccion, String cicloActual, double mediaNotas, double importeMatricula) {
        super(dni, nombre, edad, direccion);
        this.cicloActual = cicloActual;
        this.mediaNotas = mediaNotas;
        this.importeMatricula = importeMatricula;
    }
}
