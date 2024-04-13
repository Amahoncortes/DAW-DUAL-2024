package POO.Parte2.GestionVehiculosApp;

import java.util.ArrayList;

public class Taller {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(4);
        Turismo turismo1 = new Turismo();
        Turismo turismo2 = new Turismo();
        Motocicleta moto1 = new Motocicleta();
        Motocicleta moto2 = new Motocicleta();

        vehiculos.add(turismo1);
        vehiculos.add(turismo2);
        vehiculos.add(moto1);
        vehiculos.add(moto2);

        moto1.acelerar(50);
        turismo1.acelerar(200);

        for (Vehiculo vehiculo : vehiculos) {
            String info = vehiculo.toString();
            System.out.println(info);
        }

        System.out.println( "Velocidad actual de la moto: " + moto1.getVelocidad());
        moto1.acelerar(50);
        System.out.println( "Velocidad actual de la moto: " + moto1.getVelocidad());
    }
}
