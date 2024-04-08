package POO.Consumo;

public class Main {
    public static void main(String[] args) {

        Consumo vehiculo1 = new Consumo(100, 50, 30, 3.0);
        vehiculo1.consumoEuros();
        vehiculo1.consumoMedio();
        vehiculo1.getTiempo();
    }
}
