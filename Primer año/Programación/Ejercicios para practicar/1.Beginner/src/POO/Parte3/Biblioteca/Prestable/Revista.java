package POO.Parte3.Biblioteca.Prestable;

public class Revista extends Publicacion implements Prestable{
    private int numero;

    public Revista(String codigo, String titulo, int anhoPublicacion, int numero) {
        super(codigo, titulo, anhoPublicacion);
        this.numero = numero;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Numero: " + numero;

    }

    @Override
    public void prestar() {
        System.out.println("Revista prestada " +getTitulo());
    }

    @Override
    public void devolver() {
        System.out.println("Revista devuelta " + getTitulo());
    }
}
