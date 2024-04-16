package ExceptionHandling.Hospital;

//De las áreas hay que almacenar su identificador y su nombre de especialidad
//médica.
public class Area {
    private int id;
    private String especialidad;

    public Area() {
        this.id = 5;
        this.especialidad = "Pediatría";
    }

    public Area(int id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
