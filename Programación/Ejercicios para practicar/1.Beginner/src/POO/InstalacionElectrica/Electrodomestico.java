package POO.InstalacionElectrica;

public class Electrodomestico extends Aparato {

    private double consumo;
    private double potencia;
    private boolean apagado = true;

    private double consumoTotalInstalacion;
    public Electrodomestico() {
    }

    public Electrodomestico(double consumo, double potencia,  double consumoTotalInstalacion) {
        super(consumo, potencia);
        this.consumo = consumo;
        this.potencia = potencia;
        this.consumoTotalInstalacion = consumoTotalInstalacion;
    }
}
