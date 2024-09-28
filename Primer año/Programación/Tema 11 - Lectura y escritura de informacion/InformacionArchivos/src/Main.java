import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Amaho\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos";
        File directory = new File(directoryPath);
        File file = new File(directoryPath, "PROG01_Contenidos.pdf");

        try {
            System.out.println("Ejercicio 1: ");
            printNames(directory);

            System.out.println("Ejercicio 2: ");
            getFiles(directory, "pdf");

            System.out.println("Ejercicio 3: ");
            System.out.println(directoryExists(file)); // Devuelve true

            System.out.println("Ejercicio 4: ");
            System.out.println(filePermission(directory));

            System.out.println("Ejercicio 5: ");
            System.out.println(isDirectory(directory));

            System.out.println("Ejercicio 6: ");
            printLastModification(file);

            System.out.println("Ejercicio 7");
            printSize(file);

            System.out.println("Ejercicio 8");
            fileCreation();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * 1. Obtener una lista de todos los nombres de archivos / directorios de una carpeta especificada
     */
    public static void printNames(File directorio) {
        if (directorio != null && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null && archivos.length > 0) {
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
     * 2. Obtener archivos de una extensión específica dentro de una carpeta proporcionada
     */
    public static void getFiles(File directorio, String formato) {
        if (directorio != null && directorio.isDirectory()) {
            File[] archives = directorio.listFiles((dir, name) -> name.toLowerCase().endsWith(formato.toLowerCase()));
            if (archives != null) {
                for (File archive : archives) {
                    System.out.println(archive.getName());
                }
            }
        }
    }

    /*
     * 3. Comprobar si existe o no un archivo o directorio especificado por ruta
     */
    public static boolean directoryExists(File archivo) {
        return archivo.exists();
    }

    /*
     * 4. Comprobar si un archivo o directorio tiene permiso de lectura y escritura
     */
    public static String filePermission(File archivo) {
        return "Archivo: " + archivo.getName() + "\n"
                + "Permiso de lectura: " + archivo.canRead() + "\n"
                + "Permiso de escritura: " + archivo.canWrite() + "\n";
    }

    /*
     * 5. Comprobar si el nombre de una ruta dada es un directorio o un archivo
     */
    public static boolean isDirectory(File archivo) {
        return archivo.isDirectory();
    }

    /*
     * 6. Obtener la última hora de modificación de un archivo y mostrarla
     */
    public static void printLastModification(File archivo) {
        long lastModified = archivo.lastModified();
        Date fechaUltimaModificacion = new Date(lastModified);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = formato.format(fechaUltimaModificacion);
        System.out.println("Ultima modificacion: " + fechaFormateada);
    }

    /*
     * 7. Obtener el tamaño del archivo en bytes y KB y mostrarlo
     */
    public static void printSize(File archivo) {
        long fileSizeBytes = archivo.length();
        long fileSizeKB = fileSizeBytes / 1024;
        System.out.println("Tamaño del archivo: " + fileSizeBytes + " bytes");
        System.out.println("Tamaño del archivo: " + fileSizeKB + " kilobytes");
    }

    /*
     * 8. Crear una carpeta en una ruta especificada, dos archivos en dicha carpeta, listar sus nombres y eliminar uno de ellos
     */
    public static void fileCreation() throws IOException {
        File directorio = new File("C:\\Users\\Amaho\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos\\Ejercicio 8");
        File archivo1 = new File(directorio, "archivo1.txt");
        File archivo2 = new File(directorio, "archivo2.txt");

        if (directorio.mkdirs()) {
            System.out.println("Directorio creado correctamente");
        } else {
            System.out.println("El directorio ya existe");
        }

        if (archivo1.createNewFile()) {
            System.out.println("archivo1 creado correctamente");
        } else {
            System.out.println("El archivo1 ya existe");
        }

        if (archivo2.createNewFile()) {
            System.out.println("archivo2 creado correctamente");
        } else {
            System.out.println("El archivo2 ya existe");
        }

        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                System.out.println("Nombre del archivo: " + archivo.getName());
            }
            System.out.println("Borrando archivo2...");
            archivo2.delete();
        } else {
            System.out.println("El directorio no existe");
        }
    }
}
