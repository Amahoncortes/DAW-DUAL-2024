import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        File directorio = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos");
        File archivo = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos\\1.JS - Intro DOM.pdf");
        System.out.println("Ejercicio 1: ");
        imprimirNombres(directorio);

        System.out.println("Ejercicio 2: ");
        //System.out.println(obtenerTipoArchivo("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos\\1.JS - Intro DOM.pdf"));
        obtenerArchivos(directorio, "application/pdf");

        System.out.println("Ejercicio 3: ");
        System.out.println(existeDirectorio(archivo)); //Devuelve true

        System.out.println("Ejercicio 4: ");
        System.out.println(filePermission(directorio));

        System.out.println("Ejercicio 5: ");
        System.out.println(esDirectorio(directorio));

        System.out.println("Ejercicio 6: ");
        Date fechaUltimaModificacion = ultimaModificacion(archivo);
        //Modificar la fecha utilizando SimpleDateFormat
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = formato.format(fechaUltimaModificacion);
        System.out.println("Ultima modificacion: " + fechaFormateada);

        System.out.println("Ejercicio 7");
        System.out.println("Tamaño del archivo: " + obtenerTamanho(archivo) + " bytes"); //Tamaño en bytes
        System.out.println("Tamaño del archivo: " + obtenerTamanho(archivo) * 1000 + " kilobytes"); //Tamaño en kilobytes

        System.out.println("Ejercicio 8");
        creacionArchivos();
    }

    /*
     * 1. Escribir un programa Java para obtener una lista de todos los nombres de archivos / directorios de una carpeta especificada
     * */

    public static void imprimirNombres(File directorio) {
        if (directorio != null && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    System.out.println("Nombre de archivo: " + archivo.getName());
                }
                System.out.println("Nombre del directorio: " + directorio.getAbsolutePath());
            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("El directorio no existe o no es válido.");
        }
    }


    /*
     * 2. Escribir un programa Java para obtener archivos de una extensión específica dentro de una carpeta proporcionada.
     * */


    public static void obtenerArchivos(File directorio, String formato) {
        if (directorio != null && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    String tipoArchivo = obtenerTipoArchivo(archivo.getName());
                    if (tipoArchivo != null && tipoArchivo.equalsIgnoreCase(formato)){
                        System.out.println(archivo.getName());
                    }
                }
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

    public static Date ultimaModificacion(File archivo) {
        long tiempo = archivo.lastModified();
        return new Date(tiempo);
    }

    /*
     * 7) Escribir un programa Java para obtener el tamaño del archivo en bytes y KB.
     * */

    public static long obtenerTamanho(File archivo) {
        return archivo.length();
    }

    /*
     *Programa que cree una carpeta en una ruta especificada,
     *y dos archivos en dicha carpeta.
     *A continuación listar sus nombres y eliminar uno de ellos.
     * */

    public static void creacionArchivos() throws IOException {
        File directorio = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos\\Ejercicio 8");
        File archivo1 = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos\\Ejercicio 8\\archivo1.txt");
        File archivo2 = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos\\Ejercicio 8\\archivo2.txt");

        try {
            if (directorio.mkdir()) {
                System.out.println("Directorio creado correctamente");
            } else {
                System.out.println("El directorio ya existe");
            }

            if(archivo1.createNewFile()){
                System.out.println("archivo1 creado correctamente");
            } else {
                System.out.println("El archivo ya existe");
            }

            if(archivo2.createNewFile()){
                System.out.println("archivo2 creado correctamente");
            } else {
                System.out.println("El archivo ya existe");
            }

            if (directorio.exists()) {
                File[] archivos = directorio.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        System.out.println("Nombre del archivo: " + archivo.getName());
                    }
                    System.out.println("Borrando archivo2...");
                    archivo2.delete();

                }
            } else {
                System.out.println("El directorio no existe");
            }
        } catch (IOException ioException) {
            System.out.println("Ha ocurrido un error al crear el archivo");
            ioException.printStackTrace();
        }


    }
}