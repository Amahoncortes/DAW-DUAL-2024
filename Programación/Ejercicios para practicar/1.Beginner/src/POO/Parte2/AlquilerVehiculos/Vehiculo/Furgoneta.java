package POO.Parte2.AlquilerVehiculos.Vehiculo;

public class Furgoneta extends Vehiculo {
    private int kilos;
    private int volumen;

    public Furgoneta(String matricula, String marca, String modelo, String color, int tarifa, int kilos, int volumen) {
        super(matricula, marca, modelo, color, "Furgoneta" ,  tarifa);
        this.kilos = kilos;
        this.volumen = volumen;
    }

    @Override
    public String getAtributos() {
        return super.getAtributos()  +
                "Kilos de peso: " + kilos +
                "Volumen: " +volumen;
    }
}
