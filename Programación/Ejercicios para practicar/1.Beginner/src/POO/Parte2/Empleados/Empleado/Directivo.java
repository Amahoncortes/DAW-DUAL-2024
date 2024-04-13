package POO.Parte2.Empleados.Empleado;


import java.time.LocalDate;
import java.util.Date;

public class Directivo extends Empleado {

    private String cargo;
    private String departamento;

    public Directivo(String nombre, double salario, LocalDate fechaIncorporacion, String cargo, String departamento) {
        super(nombre, salario, fechaIncorporacion);
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Cargo: " + cargo + "\n" +
                "Departamento: " + departamento;
    }
}
