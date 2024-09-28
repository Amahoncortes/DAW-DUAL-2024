public class Especialidad {
    private int id;
    private String nombre;

    public Especialidad(int id, String nombre) {
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
        return this.getClass().getSimpleName() + "\n" +
                "ID: " + id + "\n" +
                "Nombre: " + nombre + "\n";
    }
}
