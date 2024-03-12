import java.util.Date;

public class Trabajador extends Persona {
private Date fechaIncorporacion;
private String areaSanitaria;
private String cargo;
private double salario;

    //Constructor
    public Trabajador() {
        super(); //Implementa todos los de Persona
        this.fechaIncorporacion = new Date(); //fecha actual
        this.areaSanitaria = "";
        this.cargo = "";
        this.salario = 0.0;
    }

    public Trabajador(String dni, String nombre, int edad, String direccion, Date fechaIncorporacion, String areaSanitaria, String cargo, double salario) {
        super(dni, nombre, edad, direccion);
        this.fechaIncorporacion = fechaIncorporacion;
        this.areaSanitaria = areaSanitaria;
        this.cargo = cargo;
        this.salario = salario;
    }

    /*Para ambos casos, médicos y pacientes, deberá calcularse el coste
     que ha supuesto en el año en curso, una persona (trabajador o paciente)
     para el hospital*/

    /*En el caso de un trabajador, el coste será el resultado de multiplicar
     su sueldo por 14 pagas y sumarle un plus de un 5% al total,
     para contar asuntos imprevistos*/

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //Método para calcular el coste anual
    public double costeAnual() {
        return salario * 14 * 1.05;
    }
}
