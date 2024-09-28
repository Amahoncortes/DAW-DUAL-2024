package POO.Parte3.Biblioteca;

import POO.Parte3.Biblioteca.Prestable.Libro;
import POO.Parte3.Biblioteca.Prestable.Prestable;
import POO.Parte3.Biblioteca.Prestable.Revista;

public class Biblioteca {
    public static void main(String[] args) {

        Prestable[] biblioteca = new Prestable[3];

        biblioteca[0] = new Libro("AMC4519", "Persona 5", 2012);
        biblioteca[1] = new Revista("ACCN4$U4", "Conan Exiles", 2013, 12);
        biblioteca[2] = new Libro("SEG29", "Palia", 2024);

        biblioteca[0].prestar();

        for(Prestable publicacion : biblioteca){
            System.out.println(publicacion.toString());
        }

        biblioteca[0].devolver();
    }
}
