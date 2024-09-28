import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Hospital {

    private final Map<String, IngresoPaciente> registroPacientes;

    public Hospital() {
        this.registroPacientes = new HashMap<>();
    }

    public void ingresarPaciente(String dni, Date fechaIngreso, String area) {
        IngresoPaciente ingreso = new IngresoPaciente(fechaIngreso, area);
        registroPacientes.put(dni, ingreso);
    }

    public void darAltaPaciente(String dni, Date fechaSalida) {
        if (registroPacientes.containsKey(dni)) {
            IngresoPaciente ingreso = registroPacientes.get(dni);
            ingreso.setFechaSalida(fechaSalida);
        }
    }

    //Clase interna para representar el ingreso de un paciente
    private static class IngresoPaciente {
        private Date fechaIngreso;
        private Date fechaSalida;
        private String areaIngreso;

        public IngresoPaciente(Date fechaIngreso, String areaIngreso) {
            this.fechaIngreso = fechaIngreso;
            this.areaIngreso = areaIngreso;
        }

        public void setFechaSalida(Date fechaSalida) {
            this.fechaSalida = fechaSalida;
        }
    }
}
