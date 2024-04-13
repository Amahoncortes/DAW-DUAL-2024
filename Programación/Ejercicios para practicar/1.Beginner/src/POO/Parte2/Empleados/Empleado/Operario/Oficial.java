package POO.Parte2.Empleados.Empleado.Operario;
import java.time.LocalDate;

public class Oficial extends Operario {
    private String lineaDeFabricacion;

    public Oficial(String nombre, double salario, LocalDate fechaIncorporacion, String area, String nave, String lineaDeFabricacion) {
        super(nombre, salario, fechaIncorporacion, area, nave);
        this.lineaDeFabricacion = lineaDeFabricacion;
    }

    public String getLineaDeFabricacion() {
        return lineaDeFabricacion;
    }

    public void setLineaDeFabricacion(String lineaDeFabricacion) {
        this.lineaDeFabricacion = lineaDeFabricacion;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Linea de fabricacion: " + lineaDeFabricacion;
    }
}
