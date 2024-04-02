import java.io.File;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        File directorio = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\InformacionArchivos");
        for (File archivo : Objects.requireNonNull(directorio.listFiles())) {
            System.out.println("Nombre de archivo: " + archivo.getName());
        }
    }
}
