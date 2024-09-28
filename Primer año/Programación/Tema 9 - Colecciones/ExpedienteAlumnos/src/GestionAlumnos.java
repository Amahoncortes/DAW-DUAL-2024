import java.util.HashMap;
import java.util.Scanner;

public class GestionAlumnos {
    private static final Scanner sc = new Scanner(System.in);

    static HashMap<Integer, Alumno> alumnos = new HashMap<>();
    Alumno alumno1 = new Alumno("39464067T", "Abel", 28, "Calle Cañiza");
    Alumno alumno2 = new Alumno("39464067T", "Andrea", 35, "Calle Robleda");
    Alumno alumno3 = new Alumno("39464067T", "Sandra", 29, "Calle Pontecaldelas");

    //utilizar un hashmap para obtener los datos de mis compañeros de clase
    private void insercionAlumnos() {
        alumnos.put(4519, alumno1);
        alumnos.put(4520, alumno2);
        alumnos.put(4521, alumno3);

    }

    //obtener el numero de alumnos
    private int obtenerNumeroAlumnos() {
        return alumnos.size();
    }

    private static void buscarAlumnoPorExpediente(){
        System.out.println("introduce un expediente: ");
        int nExpediente = sc.nextInt();

        Alumno alumno = alumnos.get(nExpediente);
        if(alumno != null){
            System.out.println("El alumno es " +alumno.getNombre() + " con numero de expediente: " +nExpediente);
        } else {
            System.out.println("No se encontró ningún alumno con el numero de expediente "  + nExpediente);
        }
    }

    private static void eliminarAlumno(){
        System.out.println("Introduce el numero de expediente del alumno que deseas eliminar: ");
        int nExpedienteEliminar = sc.nextInt();

        if(alumnos.containsKey(nExpedienteEliminar)){
            Alumno alumnoEliminado = alumnos.remove(nExpedienteEliminar);
            System.out.println("Se ha eliminado al alumno " +alumnoEliminado.getNombre()+ " con expediente " +nExpedienteEliminar);
        }
    }

    private static void mostrarListaAlumnos(){
        System.out.println("Lista de alumnos: ");
        for (HashMap.Entry<Integer, Alumno> alumno:alumnos.entrySet()) {
            System.out.println("Nº expediente: " +alumno.getKey() + ", Nombre: " +alumno.getValue().getNombre());
        }
    }

    public static void main(String[] args) {
        GestionAlumnos gestionAlumnos = new GestionAlumnos();
        gestionAlumnos.insercionAlumnos();
        int numAlumnos = gestionAlumnos.obtenerNumeroAlumnos();
        System.out.println("Número de alumnos: " + numAlumnos);
        buscarAlumnoPorExpediente();
        eliminarAlumno();
        mostrarListaAlumnos();
    }
}





