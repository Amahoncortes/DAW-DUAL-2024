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

import ExceptionHandling.Instituto.Persona.Miembro;

import java.util.ArrayList;
import java.util.Scanner;

public class Instituto {
    //• Cree un listado de miembros.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        ArrayList<Miembro> miembros = new ArrayList<>();
        ArrayList<Especialidad> espec = new ArrayList<>();
        espec.add(new Especialidad(1, "Informatica"));
        espec.add(new Especialidad(2, "Biologia"));
        espec.add(new Especialidad(3, "Fisica"));

        //• Elaborar un menú que dé las opciones de dar altas, bajas o consultas sobre los
        //miembros existentes en el listado.


        do {
            menu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    int opcionAltas;
                    do {
                        menuAltas();
                        opcionAltas = sc.nextInt();
                        switch (opcionAltas) {
                            case 1:
                                miembros.add(Operaciones.crearAlumno());
                                break;
                            case 2:
                                miembros.add(Operaciones.crearProfesor(espec));
                                break;
                        }
                    } while (opcionAltas != 3);
                    break;
                case 2:
                    System.out.println("Introduce DNI a eliminar: ");
                    String dni = sc.nextLine(); // POSIBLE PUNTO DE FALLO
                    miembros.removeIf(miembro -> miembro.getDni().equalsIgnoreCase(dni));
                    break;
                case 3:
                    menuConsultas();
                    Operaciones.consultas(sc.nextInt(), miembros);
                    break;
                case 4:
                    Operaciones.edadMediaProfesores(miembros);
                    break;
                case 5:
                    Operaciones.notaMediaAlumnos(miembros);
                    break;

                case 6:
                    Operaciones.sueldoMedioProfesores(miembros);
                    break;
            }
        } while (opcion != 7);
    }


    private static void menu() {
        //encabezado
        System.out.println("*********************");
        System.out.println("MENU DEL INSTITUTO");
        System.out.println("*********************");
        System.out.println("1.Dar de alta");
        System.out.println("2.Dar de baja");
        System.out.println("3.Consulta de informacion");
        System.out.println("4.Mostrar la edad media de los profesores");
        System.out.println("5.Calcular la nota media de los alumnos de DAM");
        System.out.println("6.Calcular el salario medio de los profesores");
        System.out.println("7.Salir");
        System.out.println("*********************");
    }

    private static void menuAltas() {
        System.out.println("""
                ¿Deseas dar de alta a un alumno o a un profesor?
                1.Alumno
                2.Profesor
                3.Salir""");
    }

    private static void menuConsultas() {
        //Encabezado
        System.out.println("--------------------");
        System.out.println("Menú de Consultas");
        System.out.println("--------------------");

        System.out.println("¿Deseas consultar alumnos o profesores?");
        System.out.println("1: Alumnos");
        System.out.println("2: Profesores");
    }
}