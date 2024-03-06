public class Main {
    public static void main(String[] args) {
        Vehiculo t1 = new Turismo(70);
        Vehiculo t2 = new Turismo(65);
        Vehiculo m1 = new Motocicleta(40);
        Vehiculo m2 = new Motocicleta(35);

        t1.acelerar(60);
        t1.frenar(60);
        t2.acelerar(60);
        t2.frenar(60);
        m1.acelerar(60);
        m1.frenar(60);
        m2.acelerar(60);
        m2.frenar(60);

    }
}
