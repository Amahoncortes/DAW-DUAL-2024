import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Archivo {
    public static void main(String[] args) {
        // Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Define las rutas de los archivos y directorios
        File practicandoArchivos = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\InformacionArchivos\\src\\practicandoArchivos.txt");
        File directorio = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\InformacionArchivos");

        try {
            // Crea un nuevo archivo
            if (practicandoArchivos.createNewFile()) {
                System.out.println("Se ha creado el archivo correctamente");
            } else {
                System.out.println("El fichero ya existe");
            }

            // Escribe contenido en el archivo
            if (practicandoArchivos.exists()) {
                FileWriter writer = new FileWriter(practicandoArchivos);
                writer.write("Este es el contenido del archivo");
                writer.close(); // Es importante cerrar el FileWriter después de escribir en el archivo
                System.out.println("El fichero se ha creado correctamente");
                System.out.println("Nombre del archivo: " + practicandoArchivos.getName());
            } else {
                System.out.println("No se ha podido crear el fichero");
            }

            // Comprueba si el directorio existe y lista los archivos en él
            System.out.println("El objeto File directorio  representa un directorio? Si es así, devuelve true: " + directorio.isDirectory());
            System.out.println("El objeto File archivo2 representa un archivo? Si lo es, devuelve true: " + practicandoArchivos.isFile());
            if (directorio.exists()) {
                File[] archivos = directorio.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        System.out.println("Nombre del archivo: " + archivo.getName());
                    }
                }
            }

            // Pregunta al usuario si desea borrar el archivo
            System.out.println("¿Quieres borrar el archivo?: Y/N");
            String entrada = sc.nextLine();
            if (entrada.equalsIgnoreCase("Y")) {
                // Intenta borrar el archivo
                boolean deleted = practicandoArchivos.delete();
                if (deleted) {
                    System.out.println("El archivo ha sido borrado correctamente.");
                } else {
                    System.out.println("No se pudo borrar el archivo.");
                }
            } else {
                System.out.println("Fin del programa.");
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
