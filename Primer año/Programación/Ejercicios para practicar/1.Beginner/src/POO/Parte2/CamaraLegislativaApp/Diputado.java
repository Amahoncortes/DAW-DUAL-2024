package POO.Parte2.CamaraLegislativaApp;

public class Diputado extends Legislador {

    public Diputado() {
    }

    public Diputado(String dni, String nombre, String apellidos, int edad, String provinciaRepresentada, String camara, boolean nacional, int anhosResidencia) {
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
