package ExceptionHandling.Hospital;

//De las áreas hay que almacenar su identificador y su nombre de especialidad
//médica.
public class Area {
    private int id;
    private String nombre;

    public Area() {
        this.id = 5;
        this.nombre = "Pediatría";
    }

    public Area(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "\n" + "ID: " + id + "\n" +
                "Especialidad: " + nombre;
    }
}
