import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Definimos el array
        String[] nombres = {"Juan", "María", "Paco", "Lola", "Pepe"};
        String[] productos = {"Libro", "Pantalla", "Teclado", "Mouse", "Cable de Red"};
        int[] precios = {1, 2, 3, 4, 5};
        File archivoNombres = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos\\nombres.txt");
        File archivoProductos = new File("C:\\Users\\a20abelmc\\Desktop\\DAW-DUAL-2024\\Programación\\Tema 11 - Lectura y escritura de informacion\\Archivos\\productos.txt");

        if (!archivoNombres.exists()) {
            try {
                archivoNombres.createNewFile();
                System.out.println("Archivo creado exitosamente");
            } catch (IOException e) {
                System.out.println("No se ha podido crear el archivo");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo ya existe");
        }

        if(!archivoProductos.exists()) {
            try {
                archivoProductos.createNewFile();
                System.out.println("Archivo creado exitosamente");
            } catch (IOException e) {
                System.out.println("No se ha podido crear el archivo");
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo ya existe");
        }
        escribirEnArchivo(nombres, archivoNombres);
        escribirEnFichero(productos, precios, archivoProductos);
    }


    // TODO:
        /*
        *1. A partir de un array con nombres de persona, escribir en un fichero denominado “datos.txt”
        dichos nombres, cada uno en una línea. A continuación, leer los datos de nuevo del fichero y
        mostrarlos por pantalla, indicando el índice de la posición que ocupa. Ejemplo de ejecución:
        1. Juan
        2. María
        3. Paco
        *
        **/

    public static void escribirEnArchivo(String[] nombres, File archivo) {
        //Escribiendo en el archivo
        try (FileWriter fw = new FileWriter(archivo)) {
            // Creamos un StringBuilder para almacenar el texto formateado.
            StringBuilder sb = new StringBuilder();
            // Recorremos el array de nombres. Cada elemento se agrega al StringBuilder con un salto de línea.
            for (int i = 0; i < nombres.length; i++) {
                // Agregamos el indice, el nombre y un salto de linea al StringBuilder.
                sb.append(i + 1).append(". ").append(nombres[i]).append("\n");
                // Imprimimos el indice y el nombre por pantalla.
                System.out.println(i + 1 + ". " + nombres[i]);
            }
            // Escribimos el StringBuilder en el archivo.
            fw.write(sb.toString());
        } catch (IOException e) {
            // Manejamos las excepciones IO
            System.out.println("Error al escribir en el archivo");
            e.printStackTrace();
        } catch (Exception e) {
            // Manejamos las excepciones generales
            System.out.println("Ocurrió un error inesperado");
            e.printStackTrace();
        }
    }



        /*2. Desarrolla un programa que lea datos de 2 arrays, uno con nombres de productos y el otro
        con sus precios. Almacenar dicho contenido en un fichero, donde cada línea constará de
        nombre de producto y precio.
        **/

    public static void escribirEnFichero(String [] nombres, int [] precios, File archivo) {
        //Escribiendo en el archivo
        try (FileWriter fw = new FileWriter(archivo)) {
            // Creamos un StringBuilder para almacenar el texto formateado.
            StringBuilder sb = new StringBuilder();
            // Recorremos el array de nombres. Cada elemento se agrega al StringBuilder con un salto de línea.
            for (int i = 0; i < nombres.length; i++) {
                // Agregamos el indice, el nombre, el precio, y un salto de linea al StringBuilder.
                sb.append(i+1).append(".").append(nombres[i]).append(".").append(precios[i]).append("\n");
                //Imprimimos el indice, el nombre y el precio por pantalla.
                System.out.println(i+1 + "." + nombres[i] + ". " + precios[i] + " euros.");
            }
            //Escribimos el StringBuilder en el archivo.
            fw.write(sb.toString());
        } catch(IOException e) {
            // Manejamos las excepciones IO
            System.out.println("Error al escribir en el archivo");
            e.printStackTrace();
        } catch(Exception e) {
            // Manejamos las excepciones generales
            System.out.println("Ocurrió un error inesperado");
            e.printStackTrace();
        }
    }



        /*3. A partir del ejercicio anterior, implementa un método que solicite un nombre de producto al
        usuario y lo elimine del listado (del fichero). Deberá mostrar también su información por
        pantalla (nombre y precio)
        */



        /*4. Implementar un programa que gestione registros (de 3 campos) almacenados en un fichero.
        Cada registro deberá tener nombre, dirección y teléfono, y el programa, a través de un
        menú, deberá permitir añadir registros al fichero, listarlos, buscar uno en concreto por
        nombre (en caso de que encuentre el contacto, deberá mostrarlo por pantalla, nombre y
        teléfono) y borrar.
        */



        /*5. Implementa los ejercicios 2, 3 y 4 empleando la persistencia de objetos en ficheros.
         *
         *
         */



        /*
        *6. Desarrolla un programa que lea los datos de un fichero de texto y que vuelque en otro
        fichero todas las líneas del primero cuyo contenido esté en mayúsculas.
        *
        */



        /*7. Se desea implementar un programa para gestionar la información de los alumnos de un
        colegio. Entre los datos a almacenar de cada alumno está el nombre, apellidos y edad.
        a. Se permitirá añadir nuevos alumnos, consultar modificar y eliminar datos de un
        alumno en una posición determinada en el fichero.
        b. La información de cada alta, baja o modificación debe ser persistente, lo que implica
        que debe realizarse sobre el fichero.
        c. La aplicación deberá permitir obtener un listado de los alumnos, en el orden en el
        que fueron dados de alta.
        */
}


