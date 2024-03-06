public class Especialidad {
    /*De las especialidades hay que almacenar su
    identificador y su nombre.*/
    private String  ID;
    private String nombre;

    public Especialidad() {
    }

    public Especialidad(String ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
