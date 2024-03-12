import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Crear una instancia de libro
        Libro libro = new Libro("LVP", "La vida de Pi", 2024);
        //LLamar al método String de libro
        System.out.println("Codigo: " + libro.getCodigo() + "\n"
                + "Titulo: " + libro.getTitulo() + "\n"
                + "Año de publicacion: " + libro.getAnhoPublicacion());
    }
}
