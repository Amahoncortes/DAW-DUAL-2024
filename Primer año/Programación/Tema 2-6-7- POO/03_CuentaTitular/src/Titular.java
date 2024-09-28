
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


public class Titular {

    //Atributos: nombre, fecha de nacimiento, DNI, sexo y direccion.
    private String nombre;
    private Date fechaNacimiento;
    private String dni;
    private String sexo;
    private String direccion;


    /*Asignar valores por defecto a todos los atributos segun su tipo.
     * Sexo será hombre por defecto, se deberá usar una constante*/

    /*Constructores:
     * Uno por defecto.*/
    public Titular() {
        this.nombre = "";
        this.fechaNacimiento = new Date();
        this.dni = "";
        this.sexo = "H";
        this.direccion = "";
    }

    //Uno que reciba nombre, fecha de nacimiento y sexo, resto por defecto.
    public Titular(String nombre, Date fechaNacimiento, String sexo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = "";
        comprobarSexo(sexo);
        this.direccion = "";
    }

    //Otro con todos los atributos como parámetro

    public Titular(String nombre, Date fechaNacimiento, String dni, String sexo, String direccion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        comprobarSexo(sexo);
        this.direccion = direccion;
    }

    //Métodos

    //GETTERS Y SETTERS


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /*boolean esMayorDeEdad()*/
    public boolean esMayorDeEdad() {
        int edad = calcularDiferenciaFechas(this.fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        return edad >= 18;
    }


    public static int calcularDiferenciaFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        Period periodo = Period.between(fechaInicio, fechaFin);
        return periodo.getYears();
    }

    /*void comprobarSexo(char sexo): comprueba que el sexo introducido sea correcto.Si es incorrecto, asignar  H.
     */
    public void comprobarSexo(String sexo) {
        if (sexo != null && (sexo.equals("H") || sexo.equals("M"))) {
            //Si quiero reasignarle el valor a this.sexo, NO puede ser una constante, asi que la cambio a variable normal.
            this.sexo = sexo;
        } else {
            this.sexo = "H";
        }
    }

    @Override
    public String toString() {
        return "Titular{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", dni='" + dni + '\'' +
                ", sexo='" + sexo + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
