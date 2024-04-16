package ExceptionHandling.Hospital;

import java.time.LocalDate;
import java.util.HashMap;

//En el caso de los pacientes, se almacenarán los datos propios de persona (el DNI,
//el nombre, la edad y la dirección), la fecha de ingreso, patología actual y áreas en
//las que ha sido ingresado a lo largo del tiempo. Dicho registro deberá realizarse
//empleando una estructura que emplee un identificador como clave y un valor que
//contenga fecha de ingreso, fecha de salida y área en la que ha sido ingresado.
public class Paciente extends Persona {
    private LocalDate fechaIngreso;
    private String patologia;
    private HashMap<Integer, Ingreso> registro;

    public Paciente() {
        this.fechaIngreso = LocalDate.now();
        this.patologia = "gripe";
        this.registro = new HashMap<>();
    }

    public Paciente(String dni, String nombre, int edad, String direccion, LocalDate fechaIngreso, String patologia, HashMap<Integer, Ingreso> registro) {
        super(dni, nombre, edad, direccion);
        this.fechaIngreso = fechaIngreso;
        this.patologia = patologia;
        this.registro = registro;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public HashMap<Integer, Ingreso> getRegistro() {
        return registro;
    }

    public void setRegistro(HashMap<Integer, Ingreso> registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Fecha de ingreso: " + fechaIngreso + "\n" +
                "Patología: " + patologia + "\n" +
                "Registro: " + registro;
    }
}
