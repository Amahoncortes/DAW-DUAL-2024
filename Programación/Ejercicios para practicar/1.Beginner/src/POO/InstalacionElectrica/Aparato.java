package POO.InstalacionElectrica;

/*
 * Implementar un programa que modele el consumo de energía de una instalación eléctrica.
 * Habrá una clase genérica "Aparato" que representará los dispositivos conectados a la instalación.
 * Cada aparato tendrá un consumo eléctrico determinado.
 * Al encender un aparato eléctrico, el consumo de energía total se incrementará en la potencia de dicho aparato.
 * Al apagarlo, se decrementará el consumo.
 * Por defecto, al crearse, todos los aparatos estarán apagados.
 * Deberá ser posible consultar el consumo total de la instalación.
 * */

public abstract class Aparato {
    private double consumo;
    private double potencia;
    private boolean apagado = true;

    private double consumoTotalInstalacion;

    public Aparato() {
    }

    public Aparato(double consumo, double potencia) {
        this.consumo = consumo;
        this.potencia = potencia;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getConsumoTotalInstalacion() {
        return consumoTotalInstalacion;
    }

    public void setConsumoTotalInstalacion(double consumoTotalInstalacion) {
        this.consumoTotalInstalacion = consumoTotalInstalacion;
    }

    public void encender() {
        apagado = !apagado;
        consumoTotalInstalacion += getPotencia();
    }

    public void apagar() {
        if (apagado) {
            System.out.println("Error. Aparato ya apagado");
        } else {
            System.out.println("Apagando aparato..." + "\n"
                    + "Aparato apagado.");
        }
    }



}