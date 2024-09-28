package edu.gorillas.Metodos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    /**
     * Este método muestra un menú principal al usuario y solicita que ingrese un número.
     * Si el usuario ingresa un número válido, se devuelve ese número. Si el usuario ingresa un valor no válido,
     * se muestra un mensaje de error y se llama recursivamente a la misma función para solicitar al usuario nuevamente.
     *
     * @param sc El objeto Scanner utilizado para leer la entrada del usuario.
     * @return El número ingresado por el usuario.
     */
    public static int menuMain(Scanner sc) {
        System.out.println("****MENU PRINCIPAL****\n"
                + "[1] Insertar\n"
                + "[2] Eliminar\n"
                + "[3] Cambiar\n"
                + "[4] Buscar\n"
                + "[5] Salir\n");
        int opcion;
        try {
            opcion = sc.nextInt();
            sc.nextLine(); // Consume el carácter de nueva línea después del número
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, introduzca un valor numérico.");
            sc.nextLine(); // Limpia el búfer para ignorar la entrada inválida
            opcion = menuMain(sc); // Llama recursivamente a la misma función para solicitar al usuario nuevamente
        }
        return opcion;
    }

    /**
     * Este método muestra un menú al usuario para insertar datos en el sistema.
     * Toma un objeto Scanner como entrada, que se utiliza para leer la entrada del usuario.
     * El método devuelve un entero que representa la elección del usuario.
     *
     * @param sc Un objeto Scanner utilizado para leer la entrada del usuario.
     * @return Un entero que representa la elección del usuario.
     */
    public static int menuInsertar(Scanner sc) {
        // Inicializar la variable para almacenar la elección del usuario
        int opcion = 0;

        // Imprimir el menú en la consola
        System.out.println("****MENU INSERTAR****\n"
                + "[1] Insertar Autores\n"
                + "[2] Insertar Libros\n"
                + "[3] Salir\n");

        // Verificar si la siguiente entrada del usuario es un entero
        if (sc.hasNextInt()) {
            // Si lo es, leer el entero y almacenarlo en la variable
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el carácter de nueva línea dejado por nextInt()
        } else {
            // Si no es un entero, imprimir un mensaje de error y continuar el bucle
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
        }

        // Devolver la elección del usuario
        return opcion;
    }

    /**
     * Esta función muestra un menú al usuario y les pide que elijan una opción para borrar.
     * El usuario puede elegir borrar un libro o un autor.
     *
     * @param sc El objeto Scanner utilizado para leer la entrada del usuario.
     * @return La opción elegida por el usuario.
     */
    public static int menuBorrar(Scanner sc) {
        // Inicializar la variable para almacenar la elección del usuario
        int opcion = 0;

        // Imprimir el menú al usuario
        System.out.println("****MENU BORRAR****\n"
                + "[1] Borrar Libros\n" // Opción para borrar un libro
                + "[2] Borrar Autores\n" // Opción para borrar un autor
                + "[3] Salir\n"); // Opción para salir del menú

        // Verificar si la entrada del usuario es un número entero
        if (sc.hasNextInt()) {
            // Si la entrada es un número entero, leer el número entero y moverse al siguiente carácter
            opcion = sc.nextInt();
            sc.nextLine();
        } else {
            // Si la entrada no es un número entero, imprimir un mensaje de error
            System.out.println("Entrada inválida. Por favor, ingresa un número.");
        }

        // Devolver la elección del usuario
        return opcion;
    }

    /**
     * Este método presenta un menú al usuario para varias consultas y le solicita que seleccione una opción.
     * El usuario puede elegir buscar un libro por título, buscar un libro por autor, listar todos los libros, listar autores con sus libros o salir del menú.
     *
     * @param sc El objeto Scanner utilizado para leer la entrada del usuario.
     * @return La opción elegida por el usuario.
     */
    public static int menuConsultas(Scanner sc) {
        int opcion = 0; // Inicializar la variable para almacenar la elección del usuario

        // Mostrar las opciones del menú de consulta al usuario
        System.out.println(
                "****MENU CONSULTAS****\n"
                        + "[1] Buscar Libro por Título\n" // Opción para buscar un libro por título
                        + "[2] Buscar Libro por Autor\n" // Opción para buscar un libro por autor
                        + "[3] Listar libros\n" // Opción para listar todos los libros
                        + "[4] Listar Autores con sus libros\n" // Opción para listar autores con sus libros
                        + "[5] Salir\n" // Opción para salir del menú
        );

        // Comprobar si la entrada del usuario es un entero
        if (sc.hasNextInt()) {
            opcion = sc.nextInt(); // Si es un entero, leer el entero y pasar al siguiente carácter
            sc.nextLine(); // Consumir el carácter de nueva línea
        } else {
            System.out.println("Entrada inválida. Por favor, ingrese un número."); // Si no es un entero, mostrar un mensaje de error
        }

        return opcion; // Devolver la elección del usuario
    }

    /**
     * Esta función muestra un menú al usuario y le pide que elija una opción.
     * El usuario puede elegir modificar libros, autores o salir del menú.
     *
     * @param sc El objeto Scanner utilizado para leer la entrada del usuario.
     * @return La elección del usuario como entero.
     */
    public static int menuModificar(Scanner sc) {
        int opcion = 0; // Inicializar la variable para almacenar la elección del usuario

        // Mostrar el menú al usuario
        System.out.println("**** MENU MODIFICAR ****\n"
                + "[1] Libros\n" // Opción para modificar libros
                + "[2] Autores\n" // Opción para modificar autores
                + "[3] Salir\n"); // Opción para salir del menú

        // Leer la elección del usuario desde la consola
        opcion = sc.nextInt();
        sc.nextLine(); // Consumir el carácter de nueva línea después del entero

        return opcion; // Devolver la elección del usuario
    }

    /**
     * Este método muestra un menú para modificar los detalles de un libro al usuario y le solicita elegir una opción.
     * Las opciones incluyen modificar el título, el precio, el autor o salir del menú.
     *
     * @param sc El objeto Scanner utilizado para leer la entrada del usuario.
     * @return La opción elegida por el usuario como un entero.
     */
    public static int menuModificarLibros(Scanner sc) {
        // Inicializar la variable para almacenar la opción elegida por el usuario
        int opcion = 0;

        // Mostrar las opciones de menú para modificar los libros
        System.out.println("**** MENU MODIFICAR LIBROS ****\n"
                + "[1] Título\n" // Opción para modificar el título
                + "[2] Precio\n"  // Opción para modificar el precio
                + "[3] Autor\n" // Opción para modificar el autor
                + "[4] Salir\n"); // Opción para salir del menú

        // Leer la opción elegida por el usuario desde la consola
        opcion = sc.nextInt();
        sc.nextLine(); // Consumir el carácter de nueva línea después del entero

        return opcion; // Devolver la opción elegida por el usuario
    }

    /**
     * Este método muestra un menú para modificar los detalles de un autor al usuario y le solicita elegir una opción.
     * Las opciones incluyen modificar el DNI, el nombre o la nacionalidad.
     *
     * @param sc El objeto Scanner utilizado para leer la entrada del usuario.
     * @return La opción elegida por el usuario como un entero.
     */
    public static int menuModAutores(Scanner sc) {
        int opcion = 0; // Inicializar la variable para almacenar la elección del usuario

        // Mostrar las opciones de menú para modificar los autores
        System.out.println("**** MENU MODIFICAR AUTORES ****\n"
                + "[1] DNI\n" // Opción para modificar el DNI
                + "[2] Nombre\n" // Opción para modificar el nombre
                + "[3] Nacionalidad\n" // Opción para modificar la nacionalidad
                + "[4] Salir\n"); // Opción para salir del menú

        // Leer la opción elegida por el usuario desde la consola
        opcion = sc.nextInt();
        sc.nextLine(); // Consumir el carácter de nueva línea después del entero

        return opcion; // Devolver la opción elegida por el usuario
    }


}
