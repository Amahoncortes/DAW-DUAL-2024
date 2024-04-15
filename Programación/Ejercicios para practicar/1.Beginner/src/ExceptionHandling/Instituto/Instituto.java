package ExceptionHandling.Instituto;

/*
*
Por último, desarrolla una clase ejecutable que realice lo siguiente:
• Elaborar un menú que dé las opciones de dar altas, bajas o consultas sobre los
miembros existentes en el listado.
• Cuando se introduzcan los datos de los objetos para realizar las altas, deberá hacerse
por teclado, capturando las excepciones que puedan producirse por la utilización del
flujo de entrada de datos, así como por introducción de datos en formato incorrecto.
En caso de que se produzca alguna de estas circunstancias, deberá mostrarse por
pantalla un error y volver a solicitar el dato.
• El menú deberá proporcionar también las siguientes funcionalidades:
▪ Mostrar por pantalla la edad media de los profesores.
▪ Calcular la nota media obtenida por los alumnos del ciclo DAM.
▪ Calcular el salario medio de los profesores.
*
* */

import ExceptionHandling.Instituto.Persona.Alumno;
import ExceptionHandling.Instituto.Persona.Miembro;
import ExceptionHandling.Instituto.Persona.Profesor;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Instituto {
    //• Cree un listado de miembros.

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Miembro> miembros = new ArrayList<>(6);


        //• Elaborar un menú que dé las opciones de dar altas, bajas o consultas sobre los
        //miembros existentes en el listado.

        //****************MENU****************
        Scanner opcion = new Scanner(System.in);
        boolean exit = false;
        int option;


        while (!exit) {

            try {
                System.out.println("*********************");
                System.out.println("1.Dar de alta");
                System.out.println("2.Dar de baja");
                System.out.println("3.Consulta de informacion");
                System.out.println("4.Mostrar la edad media de los profesores");
                System.out.println("5.Calcular la nota media obtenida por los alumnos del ciclo DAM");
                System.out.println("6.Calcular el salario medio de los profesores");
                System.out.println("7.Salir");
                System.out.println("*********************");

                System.out.println("Escribe una de las opciones:");
                option = opcion.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("""
                                Elige perfil para dar de alta:
                                1.Alumno
                                2.Profesor""");
                        option = opcion.nextInt();
                        switch (option) {
                            case 1:
                                System.out.println("Creando alumno...");
                                miembros.add(crearAlumno());
                                break;
                            case 2:
                                System.out.println("Creando profesor...");
                                miembros.add(crearProfesor());
                                break;
                        }
                        break;

                    case 2:
                        System.out.println("Dame un DNI: ");
                        boolean encontrado = false;
                        String dni = sc.next();

                        Iterator<Miembro> iterator = miembros.iterator(); //Los iteradores permiten borrar un elemento de un bucle
                        //mientras se está iterando sobre el.
                        while (iterator.hasNext()) {
                            Miembro miembro = iterator.next();
                            if (miembro.getDni().equalsIgnoreCase(dni)) {
                                System.out.println("Dni encontrado. Borrando elemento...");
                                iterator.remove();
                                System.out.println("Elemento borrado.");
                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("El dni no existe.");
                        }

                        break;
                    case 3:
                        System.out.println("Consultando información");
                        for (Miembro miembro : miembros) {
                            String info = miembro.toString();
                            System.out.println(info);
                        }
                        break;
                    case 4:
                        int edadTotal = 0;
                        int contEdadMediaProfesores = 0;

                        System.out.println("Mostrando edad media de los profesores...");
                        for (Miembro miembro : miembros) {
                            if (miembro instanceof Profesor) {
                                edadTotal += miembro.getEdad();
                                contEdadMediaProfesores++;
                            }
                        }
                        System.out.println("Edad media " + edadTotal / contEdadMediaProfesores);

                        break;

                    case 5:
                        double notaTotal = 0;
                        int contNotaMediaAlumnosDAM = 0;
                        System.out.println("Mostrando nota media de los alumnos...");
                        for (Miembro miembro : miembros) {
                            if (miembro instanceof Alumno && ((Alumno) miembro).getCiclo().equalsIgnoreCase("dam")) {
                                notaTotal += ((Alumno) miembro).getMediaNotas();
                                contNotaMediaAlumnosDAM++;
                            }
                        }
                        System.out.println("Nota media " + notaTotal / contNotaMediaAlumnosDAM);


                        break;

                    case 6:
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Introduce un número entre 1 y 7");
                }
                //****************FIN DE MENU****************
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                opcion.next();
            }
        }
    }
}