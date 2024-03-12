import java.util.Date;

public class Revista extends Biblioteca implements Prestable {
    private int numero;

    public Revista(String codigo, String titulo, int anhoPublicacion, int numero) {
        super(codigo, titulo, anhoPublicacion);
        this.numero = numero;
    }

    /*Tanto las revistas como los libros deben tener (aparte de los constructores) un método toString()
     que devuelve el valor de todos los atributos en una cadena de caracteres.
     */

    @Override
    public String toString() {
        return super.toString() + ", Número: " + numero;
    }

    /*Tambien tienen un método que devuelve el año de publicación, y otro el código*/
    public int getAnhoPublicacionLibro(){
        return getAnhoPublicacion();
    }

    public String getCodigoLibro(){
        return getCodigo();
    }

    // Implementación de los métodos Prestable
    @Override
    public void prestar() {
        // Lógica para prestar una revista
        System.out.println("Revista prestada");
    }

    @Override
    public void devolver() {
        // Lógica para devolver una revista
        System.out.println("Revista devuelta");
    }

}
