public class Consumo {
    private double kms; //Kilometros recorridos por el coche
    private double litros; //Litros de combustible consumidos
    private int vmed; //Velocidad media

    private double pgas; //precio de la gasolina


    //Constructor

    public Consumo(double kms, double litros, int vmed, double pgas) {
        this.kms = kms;
        this.litros = litros;
        this.vmed = vmed;
        this.pgas = pgas;
    }


    //metodos

    /*getTiempo.Indicar tiempo empleado en realizar el viaje*/

    public double getTiempo() {
        return this.kms / this.vmed;
    }

    /*consumoMedio. Consumo medio del vehiculo (en litros cada 100 kilometros).*/
    public double consumoMedio() {return (this.litros / this.kms) * 100;
    }


    /*consumoEuros. Consumo medio del vehiculo (en euros cada 100 kil metros)*/
    public double consumoEuros() {
        return (this.litros / this.kms) * 100 * this.pgas;
    }

}
