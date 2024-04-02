import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BoletinFicheros {
    public static void main(String[] args) {

        /*
        * 1. A partir de un array con nombres de persona,
        *escribir en un fichero denominado “datos.txt”
        dichos nombres, cada uno en una línea.
        *A continuación, leer los datos de nuevo del fichero y
        mostrarlos por pantalla, indicando el índice de la posición que ocupa.
        *Ejemplo de ejecución:
        1. Juan
        2. María
        3. Paco
        * */

        String[] nombres = {"Juan, María, Paco"};
        File directorio = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\InformacionArchivos");
        File datosTxt = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\InformacionArchivos\\src\\datos.txt");
        try {
            //Creamos un nuevo archivo
            if (datosTxt.createNewFile()) {
                System.out.println("Se ha creado el archivo correctamente");
            } else {
                System.out.println("El fichero ya existe");
            }
            //Escribir el contenido en el archivo
            if (datosTxt.exists()) {
                FileWriter writer = new FileWriter(datosTxt);
                for (int i = 0; i < nombres.length; i++) {
                    writer.write(i + 1 + " . " + nombres[i] + '\n');

                }
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
