public class Main{
    public static void main(String[] args) {

        //Crear instancia de la clase
        Agenda agenda = new Agenda();
        //Agregar contactos
        agenda.agregarContacto(1, "Andrea", "644745589");
        agenda.agregarContacto(2, "Sandra", "986232423");
        agenda.agregarContacto(3, "Abel", "649118124");
        //Buscar un contacto por nombre
        agenda.mostrarContacto("Andrea");
        //Eliminar contacto por nombre
        agenda.eliminarContacto("Andrea");
        //Listar todos los contactos
        agenda.listarContactos();
        //Listar todos los contactos que comienzan por una determinada letra
        agenda.listarContactosPorLetra('A');

    }
}
