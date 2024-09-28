package POO.Parte2.CamaraLegislativaApp;


public  class Legislador extends Persona {
    private String provinciaRepresentada;
    private String camara;
    private boolean nacional;
    private int anhosResidencia;

    public Legislador() {
    }

    public Legislador(String dni, String nombre, String apellidos, int edad, String provinciaRepresentada, String camara, boolean nacional, int anhosResidencia) {
        super(dni, nombre, apellidos, edad);
        this.provinciaRepresentada = provinciaRepresentada;
        this.camara = camara;
        this.nacional = nacional;
        this.anhosResidencia = anhosResidencia;
    }

    public String getProvinciaRepresentada() {
        return provinciaRepresentada;
    }

    public void setProvinciaRepresentada(String provinciaRepresentada) {
        this.provinciaRepresentada = provinciaRepresentada;
    }

    public String getCamaraEnQueTrabaja(){
        return camara;
    };

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public boolean isNacional() {
        return nacional;
    }

    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }

    public int getAnhosResidencia() {
        return anhosResidencia;
    }

    public void setAnhosResidencia(int anhosResidencia) {
        this.anhosResidencia = anhosResidencia;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "provinciaRepresentada: " + provinciaRepresentada + "\n" +
                "camara: " + camara + "\n" +
                "Es nacional?: " + nacional + "\n" +
                "Años de residencia: " + anhosResidencia;
    }
}
