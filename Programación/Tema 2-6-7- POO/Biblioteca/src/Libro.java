public class Libro extends Biblioteca implements Prestable {

    //Una clase que implementa una interfaz debe implementar todos los métodos de dicha interfaz, o ser declarada abstracta
    private boolean esPrestado;

    public Libro(String codigo, String titulo, int anhoPublicacion) {
        super(codigo, titulo, anhoPublicacion);
        this.esPrestado = false;
    }

    /*Tanto las revistas como los libros deben tener (aparte de los constructores) un método toString()
     que devuelve el valor de todos los atributos en una cadena de caracteres.
     */

    @Override
    public String toString() {
        return super.toString() + ", es prestado?: " + esPrestado;
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
        // Lógica para prestar un libro
        System.out.println("Libro prestado");
    }

    @Override
    public void devolver() {
        // Lógica para devolver un libro
        System.out.println("Libro devuelto");
    }
}
