package ExceptionHandling.Hospital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

    /*

Por último, desarrolla una clase ejecutable que realice lo siguiente:
 Cree una lista de trabajadores y pacientes del hospital.
 Asigna a cada posición un objeto de las clases anteriores, haciendo uso de
los distintos constructores de cada clase. Se deberá comprobar la validez de
los datos introducidos y lanzar una excepción informando de lo sucedido en
los siguientes casos:
 En caso de que la edad introducida sea un número negativo.
 En caso de que el DNI no posea una longitud de 9 caracteres.
 En caso de que la fecha de salida de cada ingreso sea anterior a la de
entrada.
 En caso de que el nombre del área sea distinto a las que posee el
hospital: cardiología, pediatría, traumatología, neumología y oncología.
 Muestra por pantalla el salario medio del personal de enfermería, así como el
salario máximo de los médicos del área de cardiología.
 Calcula el tiempo total en días que ha estado ingresado cada paciente en el
hospital.
 Muestra por pantalla el área sanitaria que más coste anual ha supuesto en el
año en curso.

    * */


public class Hospital {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        ArrayList<Persona> personas = new ArrayList<>();
        ArrayList<Area> area = new ArrayList<>();
        HashMap<Integer, Ingreso> registro = new HashMap<>();

        area.add(new Area(1, "Pediatría"));
        area.add(new Area(2, "Oncología"));
        area.add(new Area(3, "Obstetricia"));

        registro.put(1, new Ingreso(LocalDate.parse("05/07/1995", dtf), LocalDate.parse("10/07/1995", dtf), area.get(1)));



        personas.add(new Paciente("1", "Abel", 28, "CC45", LocalDate.parse("05/07/1995", dtf), "gripe", registro));
        do {
            //menu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    int opcionAltas;
                    do {
                        menuAltas();
                        opcionAltas = sc.nextInt();
                        switch (opcionAltas) {
                            case 1:
                                personas.add(Operaciones.altaTrabajador(area));

                        }
                    }

            }
        }

    }
}
