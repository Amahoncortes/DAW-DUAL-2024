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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Instituto {
    //• Cree un listado de miembros.
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
                        int contador = 0;

                        System.out.println("Mostrando edad media de los profesores...");
                        for (int i = 0; i < miembros.size() ; i++) {
                            if(miembros.get(i).getClass().getSimpleName().equalsIgnoreCase("profesor")){
                                edadTotal += miembros.get(i).getEdad();
                                contador++;
                            }
                        }
                        System.out.println("Edad media " +edadTotal/contador);

                        break;

                    case 5:
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

    private static Alumno crearAlumno() {
        String dni = "";
        String nombre = "";
        int edad = 0;
        String direccion = "";
        LocalDate fechaIncorporacion = null;
        String ciclo = "";
        double mediaNotas = 0.0;
        double importeMatricula = 0.0;


        try {
            System.out.println("Dame el dni");
            dni = sc.next(); // Leer el DNI
            sc.nextLine(); // Limpiar el búfer de entrada

            System.out.println("Dame el nombre");
            nombre = sc.nextLine();

            System.out.println("Dame la edad");
            edad = sc.nextInt();
            sc.nextLine(); // Limpiar el búfer de entrada

            System.out.println("Dame la direccion");
            direccion = sc.nextLine();

            System.out.println("Dame la fecha de incorporacion");
            fechaIncorporacion = LocalDate.parse(sc.next(), dtf);
            sc.nextLine();

            System.out.println("Dame el ciclo");
            ciclo = sc.next();
            sc.nextLine();

            System.out.println("Dame la media de notas");
            mediaNotas = sc.nextDouble();

            System.out.println("Dame el importe de la matricula");
            importeMatricula = sc.nextDouble();

        } catch (DateTimeParseException dt) {
            System.out.println("Formato de fecha incorrecto");
        } catch (InputMismatchException e) {
            System.out.println("Formato de entrada incorrecto");
        }
        return new Alumno(dni, nombre, edad, direccion, fechaIncorporacion, ciclo, mediaNotas, importeMatricula);
    }


    private static Profesor crearProfesor() {

        String dni = "";
        String nombre = "";
        int edad = 0;
        String direccion = "";
        LocalDate fechaIncorporacion = null;
        String tipoJornada = "";
        double sueldo = 0.0;
        Especialidad especialidad = null;
        try {
            System.out.println("Dame el dni");
            dni = sc.next(); // Leer el DNI
            sc.nextLine(); // Limpiar el búfer de entrada

            System.out.println("Dame el nombre");
            nombre = sc.nextLine();

            System.out.println("Dame la edad");
            edad = sc.nextInt();
            sc.nextLine(); // Limpiar el búfer de entrada

            System.out.println("Dame la direccion");
            direccion = sc.nextLine();

            System.out.println("Dame la fecha de incorporacion");
            fechaIncorporacion = LocalDate.parse(sc.next(), dtf);
            sc.nextLine();

            System.out.println("Dame el tipo de jornada");
            tipoJornada = sc.next();
            sc.nextLine();

            System.out.println("Dame el sueldo");
            sueldo = sc.nextDouble();
            sc.nextLine();

            System.out.println("Creando especialidad... ");
            System.out.println("Introduce id: ");
            String id = sc.next();
            sc.nextLine();

            System.out.println("Introduce un nombre");
            String nombreEspecialidad = sc.nextLine();
            especialidad = new Especialidad(id, nombreEspecialidad);

        } catch (DateTimeParseException dt) {
            System.out.println("Formato de fecha incorrecto");
        } catch (InputMismatchException e) {
            System.out.println("Formato de entrada incorrecto");
        }

        return new Profesor(dni, nombre, edad, direccion, fechaIncorporacion, tipoJornada, sueldo, especialidad);
    }

//miembros.add(new Profesor("23456789B", "Carlos Sánchez Martínez", 30, "Avenida Libertad 24", LocalDate.parse("10/10/1992", dtf), "completo", 8.0, "Ciencias Ambientales"));
}