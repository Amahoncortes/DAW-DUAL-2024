package POO.Parte2.Empleados.Empleado.Operario;

import java.util.Date;

public class Tecnico extends Operario {
    private String seccion;

    public Tecnico(String nombre, double salario, Date fechaIncorporacion, String area, String nave, String seccion) {
        super(nombre, salario, fechaIncorporacion, area, nave);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Seccion: " + seccion;
    }
}
