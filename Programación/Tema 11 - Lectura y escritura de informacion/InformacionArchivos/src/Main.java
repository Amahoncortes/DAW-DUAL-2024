import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        File directorio = new File("C:\\Users\\Amaho\\Desktop\\DAW Dual 2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos");
        File archivo = new File("C:\\Users\\Amaho\\Desktop\\DAW Dual 2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos\\1.JS - Intro DOM.pdf");
        System.out.println("Ejercicio 1: ");
        imprimirNombres(directorio);

        System.out.println("Ejercicio 2: ");
        obtenerArchivos(directorio, "video/mp4");

        System.out.println("Ejercicio 3: ");
        System.out.println(existeDirectorio(archivo)); //Devuelve true

        System.out.println("Ejercicio 4: ");
        System.out.println(filePermission(directorio));

        System.out.println("Ejercicio 5: ");
        System.out.println(esDirectorio(archivo));

        System.out.println("Ejercicio 6: ");
        System.out.println("Hora de ultima modificacion del archivo: " +ultimaModificacion(archivo) + " horas.");
    }

    /*
     * 1. Escribir un programa Java para obtener una lista de todos los nombres de archivos / directorios de una carpeta especificada
     * */

    public static void imprimirNombres(File directorio) {
        for (File archivo : Objects.requireNonNull(directorio.listFiles())) {
            System.out.println("Nombre de archivo: " + archivo.getName());
        }
        System.out.println("Nombre del directorio: " + directorio.getAbsolutePath());
    }

    /*
     * 2. Escribir un programa Java para obtener archivos de una extensión específica dentro de una carpeta proporcionada.
     * */


    public static void obtenerArchivos(File directorio, String formato) {
        for (File archivo : Objects.requireNonNull(directorio.listFiles())) {
            if (obtenerTipoArchivo(archivo.getName()).equalsIgnoreCase(formato)) {
                System.out.println(archivo.getName());
            }
        }
    }

    public static String obtenerTipoArchivo(String nombreArchivo) {
        String tipoArchivo = "No determinado.";
        final File archivo = new File(nombreArchivo);
        try {
            tipoArchivo = Files.probeContentType(archivo.toPath());
        } catch (IOException ioException) {
            System.out.println("Tipo de archivo no detectado para " + nombreArchivo);
        }
        return tipoArchivo;
    }

    /*
     * 3) Escribir un programa Java para comprobar si existe o no un archivo o directorio especificado por ruta.
     * */

    public static boolean existeDirectorio(File directorio) {
        return directorio.exists();
    }

    /*
     * 4) Escribir un programa Java para comprobar si un archivo o directorio tiene permiso de lectura y escritura.
     * */

    public static String filePermission(File archivo) {
        return "Archivo: " + archivo.getName() + "\n"
                + "Permiso de lectura: " + archivo.canRead() + "\n"
                + "Permiso de escritura: " + archivo.canWrite() + "\n";

    }

    /*
     * 5) Escribir un programa Java para comprobar si el nombre de una ruta dada es un directorio o un archivo.
     * */

    public static boolean esDirectorio(File directorio) {
        return directorio.isDirectory();
    }

    /*
    * 6) Escribir un  programa Java para obtener la última hora de modificación de un archivo.
    * */

    public static Date ultimaModificacion (File archivo){
        long tiempo =  archivo.lastModified();

    }


}