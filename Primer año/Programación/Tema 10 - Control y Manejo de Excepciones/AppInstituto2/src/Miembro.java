import java.util.Date;

public class Miembro extends Persona{

    private Date fechaIncorporacion;

    public Miembro() {
        this.fechaIncorporacion = new Date();
    }
    public Miembro(String dni, String nombre, int edad, String direccion) {
        super(dni, nombre, edad, direccion);
    }

}
