package POO.Parte2.Empleados.Empleado;

import POO.Parte2.Empleados.Empleado.Operario.Oficial;
import POO.Parte2.Empleados.Empleado.Operario.Operario;
import POO.Parte2.Empleados.Empleado.Operario.Tecnico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;


public class GestionEmpleados {
    public static void main(String[] args) {
        //Para definir una fecha:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Crear un array de 7 elementos
        Empleado[] emp = new Empleado[7];

        LocalDate d = LocalDate.parse("01/01/1970", formatter);
        emp[0] = new Empleado("Abel", 1500, LocalDate.parse("05/07/1995", formatter));
        emp[1] = new Operario("Rubén", 2000, LocalDate.parse("02/08/1992", formatter), "Area 1", "nave 1");
        emp[2] = new Oficial("Jose Luis", 2500, LocalDate.parse("19/10/1962", formatter), "Area 2", "nave 2", "linea 1");
        emp[3] = new Directivo("María Dolores", 3000, LocalDate.parse("02/01/1962", formatter), "Jefa", "Departamento 3");
        emp[4] = new Empleado("Abelardo", 1500, LocalDate.parse("05/07/1995", formatter));
        emp[5] = new Operario("Ruperto", 2000, LocalDate.parse("03/10/1962", formatter), "Area 1", "nave 1");
        emp[6] = new Tecnico("Pilar", 3000, LocalDate.parse("02/01/1962", formatter), "Area 5", "Nave 3", "Seccion 1");

        for (Empleado empleado : emp) {
            String info = empleado.toString();
            System.out.println(info);
        }
    }
}
