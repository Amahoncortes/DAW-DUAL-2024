package ExceptionHandling.Hospital;
import java.time.LocalDate;


public class Ingreso {
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Area area;

    public Ingreso(LocalDate fechaIngreso, LocalDate fechaSalida, Area area) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.area = area;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\n" +
                "Fecha de ingreso: " + fechaIngreso + "\n" +
                "Fecha de salida: " + fechaSalida + "\n" +
                "Area: " + area;
    }
}
