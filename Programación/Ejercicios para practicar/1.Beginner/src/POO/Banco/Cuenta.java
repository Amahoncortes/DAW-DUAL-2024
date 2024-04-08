package POO.Banco;

/*
* Crea una clase Cuenta que tendr� los siguientes atributos:
titular
cantidad (puede tener decimales).

El titular ser� obligatorio y la cantidad opcional.
Crea dos constructores que cumpla lo anterior.

Crea sus m�todos get, set y toString.

Tendr� dos m�todos especiales:

ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se har� nada.
retirar(double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.*/

public class Cuenta {
    Titular titular;
    double cantidad;

    public Cuenta(Titular titular) {
        this.titular = titular;
        this.cantidad = 0d;
    }

    public Cuenta(Titular titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Cuenta: " + "\n" +
                "Titular: " + titular + "\n" +
                "Cantidad:" + cantidad
                ;
    }

    //ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se har� nada.

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }

    //retirar(double cantidad): se retira una cantidad de la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.*/
    public void retirar(double cantidad) {
        if (this.cantidad - cantidad < 0) {
            this.cantidad = 0;
        } else {
            this.cantidad -= cantidad;
        }
    }
}
