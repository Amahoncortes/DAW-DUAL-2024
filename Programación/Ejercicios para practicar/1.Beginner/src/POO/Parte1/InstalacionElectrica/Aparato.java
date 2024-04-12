package POO.Parte1.InstalacionElectrica;

/*
 * Implementar un programa que modele el consumo de energía de una instalación eléctrica.
 * Habrá una clase genérica "Aparato" que representará los dispositivos conectados a la instalación.
 * Cada aparato tendrá un consumo eléctrico determinado.
 * Al encender un aparato eléctrico, el consumo de energía total se incrementará en la potencia de dicho aparato.
 * Al apagarlo, se decrementará el consumo.
 * Por defecto, al crearse, todos los aparatos estarán apagados.
 * Deberá ser posible consultar el consumo total de la instalación.
 * */

public class Aparato {
    private static double consumoTotal; //Se usa static para que la variable pertenezca
    //a la clase, en lugar de a sus instancias (todas las instancias comparten el valor de
    //dicha variable)
    private final double potencia;
    private final String unidadEnergia;

    //Por defecto, el aparato está apagado
    private boolean estado = false;

    public Aparato(double potencia, String unidadEnergia) {
        this.potencia = potencia;
        this.unidadEnergia = unidadEnergia;
    }

    public String getUnidadEnergia() {
        return unidadEnergia;
    }

    //Métodos


    public boolean isOn() {
        return estado;
    }

    public void cambiarEstado() {
        this.estado = !this.estado;
        if (this.isOn()) {
            consumoTotal += this.potencia;
        } else {
            consumoTotal -= this.potencia;
        }
    }

    public double calcularConsumoTotal() {
        return consumoTotal;
    }

}