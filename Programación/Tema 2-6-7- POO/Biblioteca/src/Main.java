import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Crear una instancia de libro
        Libro libro = new Libro("LVP", "La vida de Pi", 2024); //Libro 1
        //LLamar al método String de libro
        System.out.println("*********************LIBRO*********************");
        System.out.println("Codigo: " + libro.getCodigo() + "\n"
                + "Titulo: " + libro.getTitulo() + "\n"
                + "Año de publicacion: " + libro.getAnhoPublicacion() + "\n"
                + "es prestado? : " + libro.isPrestado());
        System.out.println("****************************************");

        Revista hola = new Revista("HLA", "Hola", 1790, 10);
        System.out.println("*********************REVISTA*********************");
        System.out.println("Codigo: " + hola.getCodigo() + "\n"
                + "Titulo: " + hola.getTitulo() + "\n"
                + "Año de publicacion: " + hola.getAnhoPublicacion() + "\n"
                + "Numero: " + hola.getNumero());
        System.out.println("****************************************");
    }
}
