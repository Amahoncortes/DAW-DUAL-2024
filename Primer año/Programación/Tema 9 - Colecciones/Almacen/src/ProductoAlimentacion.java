public class ProductoAlimentacion extends Producto {
    //Atributos
    private String categoria;

    private boolean tieneGluten;

    //Constructor
    public ProductoAlimentacion() {
        super();
        this.categoria = "";
        this.tieneGluten = false; //por defecto, no tiene gluten
    }

    //Getters y setters

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isTieneGluten() {
        return tieneGluten;
    }

    public void setTieneGluten(boolean tieneGluten) {
        this.tieneGluten = tieneGluten;
    }
}
