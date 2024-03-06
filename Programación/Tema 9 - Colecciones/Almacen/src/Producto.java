public class Producto {

/*De todos los productos nos interesa saber su identificador,
 nombre, precio, marca y localizacion.
*/

    private String id;
    private String nombre;
    private double precio;
    private String marca;
    private String localizacion;

    //Constructor
    public Producto() {
        this.id = "";
        this.nombre = "";
        this.precio = 0.0;
        this.marca = "";
        this.localizacion = "";
    }

    //Métodos

    //getters y setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    //Métodos específicos

    public double calcularPrecio() {
        return getPrecio();
    }
}
