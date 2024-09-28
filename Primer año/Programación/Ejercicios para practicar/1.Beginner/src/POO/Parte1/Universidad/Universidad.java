package POO.Parte1.Universidad;

import java.util.ArrayList;

/*
* Se va a implementar una aplicación que gestionará una universidad.
*  Se almacenarán datos sobre los docentes y sobre los alumnos. Se registrarán los nombres, edad, DNI, sexo, peso y altura de ambos tipos de personas.
*  Para todos ellos, al crear un nuevo objeto, se deberá comprobar si la edad introducida es válida y si es mayor de edad, para poder crear el objeto.
*  Además, se comprobará si el sexo introducido es correcto. Existirá un método mostrarInfo(), que imprimirá por pantalla los datos de cada persona.

Los docentes en concreto tendrán un atributo propio: materia, que almacenará la asignatura que este imparte.
En el caso de los alumnos, se almacenarán de manera específica la escuela en la que estudian (dentro de la universidad) y el grado que cursan.
Dentro de alumnos, existirá un tipo concreto, que será el alumnado internacional, para los que se almacenará el país del que proceden.

En el programa ejecutable, crea un array de 7 elementos entre los cuales existan elementos de todas las clases implementadas,
*uno con edad inválida y otro con edad inferior a 18 años. Posteriormente, muestra todos los datos para cada uno de los elementos del array.

* */
public class Universidad {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Abel", 28, "39464067T", 'H', 105, 170, "Montesol", "Primero");
        alumno1.setInternacional(true);
        alumno1.establecerPaisProcedencia("España");

        Alumno alumno2 = new Alumno("Andrea", 35, "38444028A", 'M', 60, 170, "Teis", "Segundo");
        alumno2.setInternacional(true);
        alumno2.establecerPaisProcedencia("Canadá");

        Alumno alumno3 = new Alumno("Sandra", 29, "38444028A", 'M', 60, 170, "Teis", "Tercero");
        alumno2.setInternacional(true);
        alumno2.establecerPaisProcedencia("Vancouver");

        Alumno alumno4 = new Alumno("Alberta", 18, "38444028A", 'M', 60, 170, "Teis", "Tercero");
        Alumno alumno5 = new Alumno("Pedrito", 19, "38444028A", 'H', 60, 170, "Teis", "Tercero");

        Docente docente1 = new Docente("Nuria", 35, "123456789A", 'M', 60, 170, "Programacion");
        Docente docente2 = new Docente("Sancho", 35, "123456789B", 'H', 60, 170, "Bases de Datos");
        Docente docente3 = new Docente("David", 35, "123456789C", 'H', 60, 170, "Contornos de Desarrollo");
        Persona director = new Persona("Alberto", 50, "456789123A", 'H', 60, 170);


        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(alumno1);
        personas.add(alumno2);
        personas.add(alumno3);
        personas.add(alumno4);
        personas.add(alumno5);

        personas.add(docente1);
        personas.add(docente2);
        personas.add(docente3);

        personas.add(director);


        mostrarInfoArray(personas);
    }

    public static void mostrarInfoArray(ArrayList<Persona> personas) {
        String info = "";
        for (Persona persona : personas) {
            info = persona.mostrarInfo();
            System.out.println(info);
        }
    }
}
