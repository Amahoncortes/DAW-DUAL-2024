package POO.Finanzas;

 /*
    *Realiza una clase finanzas que convierta dólares a euros y viceversa.
    *Codifica los métodos dolaresToEuros y eurosToDolares.
    *Prueba que dicha clase funciona correctamente haciendo conversiones entre euros y dólares.
    *La clase tiene que tener:
    Un constructor finanzas() por defecto, el cual establecerá el cambio Dólar-Euro en 1.36.
    Un constructor finanzas(double), el cual permitirá configurar el cambio dólar-euro.
    * */

public class Finanzas {
    private float ratioConversion;

    public Finanzas() {
        this.ratioConversion = 17.74F;
    }


    public Finanzas(float ratioConversion) {
        this.ratioConversion = ratioConversion;
    }

    public float pesosToEuros(float pesos) {
        return pesos / ratioConversion;
    }

    public float eurosToPesos(float euros) {
        return euros * ratioConversion;
    }

}
