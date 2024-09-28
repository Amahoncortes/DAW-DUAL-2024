package POO.Parte2.CamaraLegislativaApp;

import java.time.LocalDate;

public class Senador extends Legislador{

    public Senador() {
    }

    public Senador(String dni, String nombre, String apellidos, int edad, String provinciaRepresentada, String camara, boolean nacional, int anhosResidencia) {
        super(dni, nombre, apellidos, edad, provinciaRepresentada, camara, nacional, anhosResidencia);
    }

    @Override
    public String getCamaraEnQueTrabaja() {
        return super.getCamaraEnQueTrabaja();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
