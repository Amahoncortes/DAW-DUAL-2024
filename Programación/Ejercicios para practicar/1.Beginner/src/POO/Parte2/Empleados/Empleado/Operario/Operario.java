package POO.Parte2.Empleados.Empleado.Operario;

import POO.Parte2.Empleados.Empleado.Empleado;

import java.util.Date;


public class Operario extends Empleado {
    private String area;
    private String nave;

    public Operario(String nombre, double salario, Date fechaIncorporacion, String area, String nave) {
        super(nombre, salario, fechaIncorporacion);
        this.area = area;
        this.nave = nave;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNave() {
        return nave;
    }

    public void setNave(String nave) {
        this.nave = nave;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Area: " + area + "\n" +
                "Nave: " + nave;
    }
}
