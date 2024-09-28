package ExceptionHandling.Examen2daAvaliacion;

import ExceptionHandling.Examen2daAvaliacion.Producto.Producto;

import java.util.ArrayList;
import java.util.Scanner;

import static ExceptionHandling.Examen2daAvaliacion.Operaciones.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Comercial> comerciales = new ArrayList<>();

        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    gestionarAltas(productos, comerciales);
                    break;
                case 2:
                    eliminarLimpieza(productos);
                    break;
                case 3:
                    mostrarCategoriaComercial(comerciales);
                    break;
                case 4:
                    calcularCosteMedio(productos);
                    break;
                case 5:
                     mostrarFechaCaducidad(comerciales);
                    break;
            }
        } while (opcion != 6);

    }

    private static void gestionarAltas(ArrayList<Producto> productos, ArrayList<Comercial> comerciales) {
        Scanner scanner = new Scanner(System.in);
        int opcionAltas;
        do {
            mostrarMenuAltas();
            opcionAltas = scanner.nextInt();
            switch (opcionAltas) {
                case 1:
                   productos.add(altaProducto());
                    break;
                case 2:
                    comerciales.add(altaComercial());
                    break;
            }
        } while (opcionAltas != 3);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("*********************");
        System.out.println("MENU DEL ALMACÉN");
        System.out.println("*********************");
        System.out.println("1. Dar de alta productos o comerciales");
        System.out.println("2. Eliminar productos de limpieza");
        System.out.println("3. Mostrar por pantalla la categoría de producto especial de cada comercial");
        System.out.println("4. Calcular coste medio de los productos comestibles");
        System.out.println("5. Mostrar por pantalla productos con fecha de caducidad inferior a 5 dias");
        System.out.println("6. Salir");
        System.out.println("*********************");
    }

    private static void mostrarMenuAltas() {
        System.out.println("Deseas dar de alta un producto o a un comercial?");
        System.out.println("1. Producto");
        System.out.println("2. Comercial");
        System.out.println("3. Salir");
    }
}
