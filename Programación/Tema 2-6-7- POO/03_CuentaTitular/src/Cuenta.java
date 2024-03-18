public class Cuenta {
    private Titular titular;
    private double cantidad;

   /* El titular será  obligatorio y la cantidad opcional.
    Crea dos constructores que cumpla lo anterior.*/

    public Cuenta(Titular titular) {
        this.titular = titular;
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
        return "Cuenta{" +
                "titular='" + titular.getNombre() + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    /*
ingresar(double cantidad): se ingresa una cantidad a la cuenta,
si la cantidad introducida es negativa, no se hará nada.*/
    public double ingresar(double cantidad) {
        if (cantidad <= 0) {
            throw new ArithmeticException("Cantidad invalida - introduce una cantidad.");
        } else {
            setCantidad(getCantidad() + cantidad);
        }
        return cantidad;
    }

    /*retirar(double cantidad): se retira una cantidad a la cuenta,
     si restando la cantidad actual a la que nos pasan es negativa,
      la cantidad de la cuenta pasa a ser 0.*/

    public double retirar(double cantidad) {
        double cantidadActual = getCantidad();
// Si la cantidad a retirar es mayor que la cantidad actual, establecer la cantidad en 0
        if (cantidadActual - cantidad < 0) {
                cantidadActual = 0;
        } else {
            //Restar la cantidad en la cuenta
            cantidadActual -= cantidad;
        }
        return cantidadActual;
    }
}
