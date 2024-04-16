package ExceptionHandling.Hospital;

//De las áreas hay que almacenar su identificador y su nombre de especialidad
//médica.
public class Area {
    private String id;
    private String especialidad;

    public Area() {
        this.id = "5";
        this.especialidad = "Pediatría";
    }

    public Area(String id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\n" +
                "ID: " + id + "\n" +
                "Especialidad: " + especialidad;
    }

    /*
Para ambos casos, trabajadores y pacientes, deberá calcularse el coste que ha supuesto
en el año en curso, una persona (trabajador o paciente) para el hospital. En el caso
de un trabajador, el coste será el resultado de multiplicar su sueldo por 14 pagas y
sumarle un plus de un 5% al total, para contar asuntos imprevistos. En el caso de los
pacientes, será el número de días que ha sido ingresado en cada área multiplicado
por 700€. Además, en el caso de que el ingreso sea en el área de traumatología,
habrá que sumarle un plus de un 2%.
Por último, desarrolla una clase ejecutable que realice lo siguiente:
 Cree una lista de trabajadores y pacientes del hospital.
 Asigna a cada posición un objeto de las clases anteriores, haciendo uso de
los distintos constructores de cada clase. Se deberá comprobar la validez de
los datos introducidos y lanzar una excepción informando de lo sucedido en
los siguientes casos:
 En caso de que la edad introducida sea un número negativo.
 En caso de que el DNI no posea una longitud de 9 caracteres.
 En caso de que la fecha de salida de cada ingreso sea anterior a la de
entrada.
 En caso de que el nombre del área sea distinto a las que posee el
hospital: cardiología, pediatría, traumatología, neumología y oncología.
 Muestra por pantalla el salario medio del personal de enfermería, así como el
salario máximo de los médicos del área de cardiología.
 Calcula el tiempo total en días que ha estado ingresado cada paciente en el
hospital.
 Muestra por pantalla el área sanitaria que más coste anual ha supuesto en el
año en curso.

    * */
}
