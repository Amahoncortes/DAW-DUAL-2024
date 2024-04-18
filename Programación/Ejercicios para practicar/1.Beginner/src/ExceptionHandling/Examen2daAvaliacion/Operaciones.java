package ExceptionHandling.Examen2daAvaliacion;

import ExceptionHandling.Examen2daAvaliacion.Producto.Bazar;
import ExceptionHandling.Examen2daAvaliacion.Producto.Comestible;
import ExceptionHandling.Examen2daAvaliacion.Producto.Producto;
import ExceptionHandling.Examen2daAvaliacion.Producto.ZonaInvalidaException;
import ExceptionHandling.Hospital.Ingreso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Operaciones {

    /**
     * Un método para crear un nuevo producto.
     * Pide un prompt al usuario para el nombre, precio y categoria del producto.
     * Si la categoría es "Comestible", pide un prompt para la fecha de caducación y crea un objeto Comestible.
     * Si la categoría es "Bazar", pide un prompt para el tipo de producto y crea un objeto Bazar.
     * Si la categoría no es ni "Comestible" ni "Bazar", lanza un else y pide un prompt para validar la categoría de nuevo.
     *
     * @return Producto El producto creado con la información introducida por el usuario.
     */
    public static Producto altaProducto() {
        Scanner scanner = new Scanner(System.in);
        Producto producto;
        String categoria;
        try {
            System.out.println("Introduzca el nombre, y el precio");
            String nombre = scanner.nextLine();
            double precio = scanner.nextDouble();
            scanner.nextLine();

            if (precio <= 0) {
                throw new PrecioNegativoException("El precio debe ser mayor que 0");
            }

            System.out.println("Introduzca la categoria. Comestible o Bazar");
            categoria = scanner.nextLine();

            if (categoria.equalsIgnoreCase("Comestible")) {
                System.out.println("Introduzca la fecha de caducidad");
                LocalDate fechaCaducidad = validarFechaCaducidad(scanner.nextLine());
                producto = new Comestible(nombre, precio, fechaCaducidad);
            } else if (categoria.equalsIgnoreCase("Bazar")) {
                System.out.println("Introduzca el tipo de producto");
                String tipo = scanner.nextLine();
                return new Bazar(nombre, precio, tipo);
            } else {
                System.out.println("Categoria no valida. Empezar de nuevo");
                return altaProducto();
            }
        } catch (PrecioNegativoException | InputMismatchException e) {
            System.out.println(e.getMessage());
            return altaProducto();
        }
        return producto;
    }


    /**
     * Un método para crear un nuevo Comercial basado en input de usuario para el nombre, apellidos, edad y zona.
     *
     * @return Comercial El Comercial creado con la información introducida por el usuario.
     */
    public static Comercial altaComercial() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduzca el nombre, apellidos, edad, y zona");
            String nombre = scanner.nextLine();
            String apellidos = scanner.nextLine();
            int edad = scanner.nextInt();
            scanner.nextLine();
            String zona = scanner.nextLine();
            if (!zona.equalsIgnoreCase("Zona 1") && !zona.equalsIgnoreCase("Zona 2") && !zona.equalsIgnoreCase("Zona 3")) {
                throw new ZonaInvalidaException("La zona debe ser Zona 1, Zona 2 o Zona 3");
            }
            if (edad <= 0 || edad > 70) {
                throw new EdadNegativaException("La edad debe ser mayor que 0 y menor que 70");
            }
            return new Comercial(nombre, apellidos, edad, zona, crearRegistroComercial());

        } catch (InputMismatchException | ZonaInvalidaException | EdadNegativaException e) {
            System.out.println("Error. Vuelva a introducir los datos");
            return altaComercial();
        }
    }

    /**
     * Crea un registro de productos de un comercial.
     *
     * @return un HashMap que contiene los productos del comercial con sus respectivas IDs.
     */

    private static HashMap<Integer, Producto> crearRegistroComercial() {
        HashMap<Integer, Producto> registroComercial = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca los productos al registro del comercial. Introduzca n para terminar:");
        int i = 0;
        boolean continuar = true;
        while (continuar) {
            System.out.println(STR."Producto #\{i + 1}");
            Producto producto = altaProducto();
            registroComercial.put(i, producto);
            System.out.println("Desea introducir otro producto? (s/n)");
            String respuesta = scanner.nextLine().toLowerCase();
            continuar = !respuesta.equals("n");
            i++;
        }
        return registroComercial;
    }

    /**
     * Elimina todos los productos de limpieza de una lista de productos.
     *
     * @param productos La lista de productos de la cual eliminamos los productos de limpieza.
     */
    public static void eliminarLimpieza(ArrayList<Producto> productos) {
        productos.removeIf(producto -> producto instanceof Bazar b && b.getTipo().equals("Limpieza"));
    }

    /**
     * Un método para enseñar la categoría comercial basado en los productos en los que los Comerciales se especializan.
     *
     * @param comerciales Un Arraylist de comerciales que representan diferentes entidades comerciales.
     */
    public static void mostrarCategoriaComercial(ArrayList<Comercial> comerciales) {
        int contProdBazar = 0, contProdComestible = 0;

        for (Comercial comercial : comerciales) {
            HashMap<Integer, Producto> stock = comercial.getStock();

            Collection<Producto> productos = stock.values();
            for (Producto p : productos) {
                if (p instanceof Comestible) {
                    contProdComestible++;
                }
                if (p instanceof Bazar) {
                    contProdBazar++;
                }
            }
            System.out.println(STR."El comercial \{comercial.getNombre()} \{comercial.getApellidos()} está especializado en \{contProdComestible >= contProdBazar ? "Comestibles" : "Bazar"}");
        }
    }

    /**
     * Valida la fecha de expiracion de un producto.
     *
     * @param fechaCaducidad La fecha de expiracion de un producto en formato "dd/MM/yyyy".
     * @return La fecha de expiracion parseada.
     * @throws DateTimeParseException Si la fecha de expiración no está en el formato correcto.
     */
    private static LocalDate validarFechaCaducidad(String fechaCaducidad) {
        Scanner scanner = new Scanner(System.in);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaFormateada = LocalDate.parse(fechaCaducidad, formatter);

            if (fechaFormateada.isBefore(fechaActual)) {
                throw new CaducidadAnteriorException("El producto está caducado. No se puede registrar.");
            }
            return fechaFormateada;
        } catch (CaducidadAnteriorException | DateTimeParseException e) {
            System.out.println(STR."\{e.getMessage()} Vuelva a introducir la fecha de expiración");
            return validarFechaCaducidad(scanner.nextLine());
        }
    }


    /**
     * Calcula el coste medio de los productos comestibles en la lista de productos dada.
     *
     * @param productos La lista de productos de la cual se calculará el coste medio.
     */
    public static void calcularCosteMedio(ArrayList<Producto> productos) {
        if (productos == null) {
            throw new IllegalArgumentException("El ArrayList de productos no puede ser nulo");
        }

        double costeTotal = 0.0;
        int contador = 0;
        for (Producto p : productos) {
            if (p instanceof Comestible) {
                costeTotal += p.getPrecio();
                contador++;
            }
            if (contador == 0) {
                System.out.println("No se encontraron productos comestibles");
                return;
            }
            double costeMedio = costeTotal / contador;
            System.out.println(STR."Coste medio de \{p.getNombre()} : \{costeMedio} euros.");
        }
    }

    public static void mostrarFechaCaducidad(ArrayList<Producto> productos) {
        for (Producto p : productos) {
            if (p instanceof Comestible && caducidadMenor5(((Comestible) p).getFechaCaducidad(), LocalDate.now())) {
                System.out.println(STR."Productos con fecha de caducidad inferior a 5 días: \{p}");
            }
        }
    }

    public static boolean caducidadMenor5(LocalDate fechaExpiracion, LocalDate fechaActual) {
        return ChronoUnit.DAYS.between(fechaExpiracion, fechaActual) < 5;
    }

}
