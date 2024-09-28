package POO.Parte2.AlquilerVehiculos.Vehiculo;

public class Deportivo extends Vehiculo {
    private int cilindrada;

    public Deportivo(String matricula, String marca, String modelo, String color, int tarifa, int cilindrada) {
        super(matricula, marca, modelo, color, "Deportivo" , tarifa);
        this.cilindrada = cilindrada;
    }

    @Override
    public String getAtributos() {
        return super.getAtributos() + "\n" +
                "Cilindrada: " + cilindrada;

    }
}
