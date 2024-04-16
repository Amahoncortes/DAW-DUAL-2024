package ExceptionHandling.Hospital;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class Operaciones {
    public void costeAnual(ArrayList<Persona> personas) {
        double costeTotal = 0;

        for (Persona persona : personas) {
            if (persona instanceof Trabajador) {
                costeTotal = ((Trabajador) persona).getSalario() * 14;
                double plus = costeTotal * 0.05;
                costeTotal += plus;
                System.out.println(persona.getNombre() + "Coste anual de: " + costeTotal + " euros.");
            }

            if (persona instanceof Paciente) {
                HashMap<Integer, Ingreso> registro = ((Paciente) persona).getRegistro();
                for (int i = 0; i < registro.size(); i++) {
                    Ingreso ingreso= registro.get(i);
                    costeTotal = calcularPeriodo(ingreso);
                    costeTotal *= 700;

                    if (ingreso.getArea().getEspecialidad().equalsIgnoreCase("traumatologia")) {
                        double plus = costeTotal * 0.02;
                        costeTotal += plus;
                    }
                }
                System.out.println(persona.getNombre() + "Coste anual de: " + costeTotal + " euros.");
            }
        }
    }

    public long calcularPeriodo(Ingreso ingreso) {
        LocalDate fechaDeEntrada = ingreso.getFechaIngreso();
        LocalDate fechaDeSalida = ingreso.getFechaSalida();
        Period p = Period.between(fechaDeEntrada, fechaDeSalida);
        return ChronoUnit.DAYS.between(fechaDeEntrada, fechaDeSalida);
    }


}
