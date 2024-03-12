import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Paciente extends Persona {
    private Date fechaIngreso;
    private String patologiaActual;

    private HashMap<String, IngresoPaciente> areasIngresado;

    
    //Constructor


    public Paciente(String dni, String nombre, int edad, String direccion, Date fechaIngreso, String patologiaActual, String areasIngresado) {
        super(dni, nombre, edad, direccion);
        this.fechaIngreso = fechaIngreso;
        this.patologiaActual = patologiaActual;
        this.areasIngresado = new HashMap <>();
    }



    /*Para ambos casos, médicos y pacientes, deberá calcularse el coste
     que ha supuesto en el año en curso, una persona (trabajador o paciente)
     para el hospital*/

    /* En el caso de los pacientes,
     será el número de días que ha sido ingresado en cada área
     multiplicado por 700€.
     Además, en el caso de que el ingreso sea en el área de traumatología,
     habrá que sumarle un plus de un 2%.*/

    //Método para calcular el coste anual
    public double costeAnual() {


    }


}
