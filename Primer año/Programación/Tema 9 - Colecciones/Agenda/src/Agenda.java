import java.util.HashMap;
import java.util.Map;

/*implementar una agenda de telefonos donde cada contacto tenga como clave un numero entero y como valor un nombre y un telefono.
  Desarrollar metodos para insertar una nueva entrada en la agenda,
  buscar un contacto por nombre,
  mostrando por pantalla un numero de telefono asociado,
  eliminar un contacto por nombre, listar todos los contactos,
  y listar todos aquellos contactos que comienzan por una determinada letra.
*/
public class Agenda {
    private final HashMap<Integer, Contacto> agendaContactos = new HashMap<>();

    //Método para insertar nueva entrada en la agenda
    public void agregarContacto(int idContacto, String nombre, String telefono) {
        Contacto nuevoContacto = new Contacto(nombre, telefono);
        agendaContactos.put(idContacto, nuevoContacto);

    }

    //Método para borrar un contacto por nombre
    public void mostrarContacto(String nombre) {
        boolean encontrado = false;
        for (Map.Entry<Integer, Contacto> entry : agendaContactos.entrySet()) {
            if (entry.getValue().getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                System.out.println("El telefono de " + nombre + " : " + entry.getValue().getTlf());
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con el nombre " + nombre);
        }
    }

    //Método para borrar un contacto por nombre
    public void eliminarContacto(String nombre){
        boolean eliminado = false;
        for (Map.Entry<Integer,Contacto> entry:agendaContactos.entrySet()) {
            if(entry.getValue().getNombre().equalsIgnoreCase(nombre)){
                agendaContactos.remove(entry.getKey());
                eliminado = true;
                System.out.println("El contacto: " + nombre + " ha sido eliminado de la agenda.");
            break;
            }
        }
        if (!eliminado) {
            System.out.println("No se encontró ningún contacto con el nombre " + nombre);
        }
    }

    //Método para listar todos los contactos
    public void listarContactos(){
        for (Map.Entry<Integer,Contacto> entry:agendaContactos.entrySet()){
            System.out.println("ID: " +entry.getKey() + " , Nombre: " + entry.getValue().getNombre() + ", Telefono: " +entry.getValue().getTlf());
        }
    }

    //Método para listar todos aquellos que empiezan por una determinada letra

    public void listarContactosPorLetra(char letra){
        boolean encontrado = false;
       for (Map.Entry<Integer,Contacto> entry:agendaContactos.entrySet()){
           if(entry.getValue().getNombre().charAt(0) == letra || entry.getValue().getNombre().charAt(0) == Character.toUpperCase(letra)){
               System.out.println("ID: " +entry.getKey() + " , Nombre: " + entry.getValue().getNombre() + ", Telefono: " +entry.getValue().getTlf());
               encontrado = true;
           }
       }
        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con la letra " + letra);
        }
    }
}
