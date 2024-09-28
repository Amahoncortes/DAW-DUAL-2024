package POO.Parte2.AlquilerVehiculos;

import POO.Parte2.AlquilerVehiculos.Vehiculo.*;

/*
 * Se desea implementar una aplicación para gestionar una empresa de alquiler de vehículos. Se almacenará información sobre:
 *Clientes: registrando su nif, nombre y apellidos.
 *Vehiculos: se registrará su matrícula, marca, modelo, color y tarifa. Existirán 3 tipos de vehículos: Turismo, Furgoneta y Deportivo.
 *Para el primer tipo se necesitará almacenar el número de puertas y si es automático. Para las furgonetas será necesario conocer su carga y su volumen.
 *Por último, para los deportivos, necesitaremos conocer su cilindrada.
 *El alquiler de un vehículo: almacenando una referencia al cliente que lo alquila,
 *y los datos del vehículo alquilado. Además, se registrarán el día, mes, año y el número de días que estará el vehículo en alquiler.
 *
 *
 * */
public class AlquilerVehiculos {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("48151623", "Volkswagen", "Jetta", "negro", 200);
        Vehiculo vehiculo2 = new Vehiculo("48151623", "Opel", "Corsa", "rojo", 150);
        Turismo turismo1 = new Turismo("48151623", "Citroen", "Sara", "azul", 100, 4, true);
        Turismo turismo2 = new Turismo("48151623", "Sara", "Picasso", "verde", 250, 4, true);
        Furgoneta furgoneta1 = new Furgoneta("2324232423", "Citroen", "Twingo", "marron", 300, 300, 500);
        Furgoneta furgoneta2 = new Furgoneta("4519541923", "Hyundai", "Bayon", "amarillo", 300, 250, 500);

        System.out.println(vehiculo1.getAtributos());
        System.out.println(vehiculo2.getAtributos());

        Cliente cliente1 = new Cliente("39464067T", "Abel", "Mahon Cortes");

        //Para relacionar un vehiculo1 con cliente1
        VehiculoAlquilado alquiler1 = new VehiculoAlquilado(cliente1, vehiculo1, 12, 04, 2024, 3);
        System.out.println(alquiler1.getCliente().getNif() + " " +
                alquiler1.getCliente().getNombre() + " " +
                alquiler1.getCliente().getApellidos());
        System.out.println(alquiler1.getVehiculo().getMatricula());

        Vehiculo miVehiculo = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100);
        Turismo miTurismo = new Turismo("4060 TUR", "Skoda", "Fabia", "Blanco", 90, 2, false);
        Deportivo miDeportivo = new Deportivo("4080 DEP", "Ford", "Mustang", "Rojo", 150, 2000);
        Furgoneta miFurgoneta = new Furgoneta("4080 FUR", "Fiat", "Ducato", "Azul", 80, 1200, 8);

        System.out.println(miVehiculo.getAtributos());

        System.out.println(miTurismo.getAtributos());

        System.out.println(miDeportivo.getAtributos());

        System.out.println(miFurgoneta.getAtributos());
    }
}
