package ExceptionHandling.Instituto.Persona;
import java.time.LocalDate;
public class Alumno extends Miembro {
    //En el caso de los alumnos, se almacenará el ciclo que se encuentra realizando, su media de
    //notas y el importe de su matrícula.
    private String ciclo;
    private double mediaNotas;
    private double importeMatricula;


    public Alumno() {
        super();
        this.ciclo = "Desarrollo de Aplicaciones Web";
        this.mediaNotas = 6.5;
        this.importeMatricula = 3000;
    }

    public Alumno(String dni, String nombre, int edad, String direccion, LocalDate fechaIncorporacion, String ciclo, double mediaNotas, double importeMatricula) {
        super(dni, nombre, edad, direccion, fechaIncorporacion);
        this.ciclo = ciclo;
        this.mediaNotas = mediaNotas;
        this.importeMatricula = importeMatricula;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public double getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public double getImporteMatricula() {
        return importeMatricula;
    }

    public void setImporteMatricula(double importeMatricula) {
        this.importeMatricula = importeMatricula;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Ciclo: " + ciclo + "\n" +
                "Media de notas: " + mediaNotas + "\n" +
                "Importe de la matrícula: " + importeMatricula;
    }

    //Existirá un método común a alumnos y profesores, aplicarBonificacion, que en función de la
    //clase sobre la que se implemente, actuará de una manera u otra:
    //• En el caso de los alumnos, si el alumno se ha incorporado al centro hace más de 2
    //años, el importe de su matrícula se verá reducido en un 10%.
    @Override
    public void aplicarBonificacion() {
        if (calcularPeriodo().getYears() > 2) {
            double descuento = importeMatricula * 0.1; //10% del valor original
            importeMatricula -= descuento;
        }
    }

}
