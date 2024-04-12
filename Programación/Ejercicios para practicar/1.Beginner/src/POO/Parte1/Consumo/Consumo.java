package POO.Parte1.Consumo;

public class Consumo {
        /*
        Implementa una clase consumo, la cual forma parte de la centralita electrónica de un coche y tiene las siguientes características:
        Atributos:
          kms. Kilómetros recorridos por el coche.
          litros. Litros de combustible consumido.
          vmed. Velocidad media.
          pgas. Precio de la gasolina.
        Métodos:
          getTiempo. Indicar el tiempo empleado en realizar el viaje.
          consumoMedio. Consumo medio del vehículo (en litros cada 100 kilómetros).
          consumoEuros. Consumo medio del vehículo (en euros cada 100 kilómetros).
        No olvides crear un constructor para la clase que establezca el valor de los atributos. Elige el tipo de datos más apropiado para cada atributo.
        * */

    private double kms; //kilometros recorridos por el coche
    private double litros; //Litros de combustible consumido
    private double vmedia; //Velocidad media
    private double pgas; //Precio de la gasolina


    public Consumo(double kms, double litros, double vmedia, double pgas) {
        this.kms = kms;
        this.litros = litros;
        this.vmedia = vmedia;
        this.pgas = pgas;
    }

    public Consumo(double kms) {

    }

    public void getTiempo() {
        //Tiempo = distancia/velocidad
        System.out.println("Tiempo empleado en realizar el viaje: " + this.kms / this.vmedia + " horas");
    }

    public void consumoMedio() {
        //litros cada 100 km
        System.out.println("Consumo medio del vehiculo: " + (this.litros * this.kms) / 100 + " litros.");
    }

    //consumoEuros. Consumo medio del vehículo (en euros cada 100 kilómetros).

    public void consumoEuros() {
        //Euros cada 100 km
        System.out.println("Consumo medio del vehiculo: " + (this.pgas * this.kms) / 100 + " euros.");
    }

    @Override
    public String toString() {
        return "Consumo: " + "\n" +
                "kms: " + kms + "\n" +
                "litros: " + litros + "\n" +
                "vmedia: " + vmedia + "\n" +
                "pgas: " + pgas;
    }
}
