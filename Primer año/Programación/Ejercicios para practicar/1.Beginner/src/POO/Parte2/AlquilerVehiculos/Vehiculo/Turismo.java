package POO.Parte2.AlquilerVehiculos.Vehiculo;

public class Turismo extends Vehiculo {
    private int numPuertas;
    private boolean automatico;

    public Turismo(String matricula, String marca, String modelo, String color, int tarifa, int numPuertas, boolean automatico) {
        super(matricula, marca, modelo, color, "Turismo", tarifa);
        this.numPuertas = numPuertas;
        this.automatico = automatico;
    }

    @Override
    public String getAtributos() {
        return super.getAtributos() + "\n" +
                "numero de puertas: " + numPuertas + "\n" +
                "Es automatico? : " + automatico;
    }
}
