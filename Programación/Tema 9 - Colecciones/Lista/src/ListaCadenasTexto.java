import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaCadenasTexto {

    private List<String> listaDeNombres = new ArrayList<>();

    // Implementa un método que cree una lista de cadenas de texto.
    public void crearLista() {
        listaDeNombres = new ArrayList<>();
    }

    // A continuación, implementa un método que cargue la lista con nombres.
    public void cargarNombres(String[] nombres) {
        listaDeNombres.addAll(Arrays.asList(nombres));
    }

    // Deberá existir otro método para visualizar la lista, con el índice de cada posición.
    public void verLista() {
        for (int i = 0; i < listaDeNombres.size(); i++) {
            System.out.println("[" + i + "]" + listaDeNombres.get(i));
        }
    }

    // Implementar un método que busque un nombre y devuelva su posición.
    public int buscarNombre(String nombre) {
        int posicion = listaDeNombres.indexOf(nombre);
        if (posicion != -1) {
            System.out.println("El nombre '" + nombre + "' se encuentra en la posición: " + posicion);
        } else {
            System.out.println("El nombre '" + nombre + "' no se encuentra en la lista.");
        }
        return posicion;
    }

    // Desarrollar un método para eliminar un nombre de la lista.
    public void eliminarNombre(String nombre) {
        boolean removido = listaDeNombres.remove(nombre);
        if (removido) {
            System.out.println("El nombre '" + nombre + "' ha sido eliminado de la lista.");
        } else {
            System.out.println("El nombre '" + nombre + "' no se encontraba en la lista.");
        }
    }

    public static void main(String[] args) {

        ListaCadenasTexto listaDeNombres = new ListaCadenasTexto();

        System.out.println("*****CREANDO LISTA******");
        listaDeNombres.crearLista();

        System.out.println("*****CARGANDO LISTA*****");
        String[] nombres = {"Nuria", "Abel", "Andrea"};
        listaDeNombres.cargarNombres(nombres);

        System.out.println("*****VISUALIZANDO LISTA*****");
        listaDeNombres.verLista();

        System.out.println("*****BUSCANDO NOMBRE*****");
        String nombre = "Abel";
        listaDeNombres.buscarNombre(nombre);

        System.out.println("*****ELIMINANDO NOMBRE*****");
        listaDeNombres.eliminarNombre(nombre);

        System.out.println("*****VISUALIZANDO LISTA ACTUALIZADA*****");
        listaDeNombres.verLista();
    }
}
