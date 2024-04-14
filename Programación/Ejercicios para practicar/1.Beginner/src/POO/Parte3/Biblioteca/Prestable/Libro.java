package POO.Parte3.Biblioteca.Prestable;

public class Libro extends Publicacion implements Prestable {
    private boolean prestado;

    public Libro(String codigo, String titulo, int anhoPublicacion) {
        super(codigo, titulo, anhoPublicacion);
        this.prestado = false;
    }

    public Libro(String codigo, String titulo, int anhoPublicacion, boolean prestado) {
        super(codigo, titulo, anhoPublicacion);
        this.prestado = prestado;
    }



    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Es prestado? " + prestado;
    }

    @Override
    public void prestar() {
        prestado = true;
    }

    @Override
    public void devolver() {
        prestado = false;
    }
}
