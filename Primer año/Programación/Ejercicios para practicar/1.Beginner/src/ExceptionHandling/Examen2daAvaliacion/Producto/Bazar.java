package ExceptionHandling.Examen2daAvaliacion.Producto;

public class Bazar extends Producto {
    private String tipo;

    public Bazar() {
        this.tipo = "Baratija";
    }

    public Bazar(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Tipo: " + tipo;
    }
}
