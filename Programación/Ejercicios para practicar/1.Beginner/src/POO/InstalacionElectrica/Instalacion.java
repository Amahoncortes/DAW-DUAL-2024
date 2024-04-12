package POO.InstalacionElectrica;

import java.util.ArrayList;

public class Instalacion {
    public static void main(String[] args) {
        Aparato nevera = new Aparato(300, "watios");
        System.out.println("El aparato está encendido? : true | false\n" + nevera.isOn());
        nevera.cambiarEstado();
        System.out.println("El aparato está encendido? : true | false\n" + nevera.isOn());
        System.out.println("Consumo de la instalacion: " + nevera.calcularConsumoTotal() + " " + nevera.getUnidadEnergia());

        Aparato lavadora = new Aparato(200, "watios");
        System.out.println("El aparato está encendido? : true | false\n" + lavadora.isOn());
        lavadora.cambiarEstado();
        System.out.println("El aparato está encendido? : true | false\n" + lavadora.isOn());
        System.out.println("Consumo de la instalacion: " + lavadora.calcularConsumoTotal() + " " + lavadora.getUnidadEnergia());

        lavadora.cambiarEstado();
        System.out.println("El aparato está encendido? : true | false\n" + lavadora.isOn());
        System.out.println("Consumo de la instalacion: " + lavadora.calcularConsumoTotal() + " " + lavadora.getUnidadEnergia());

        Electrodomestico secadora = new Electrodomestico(400, "negro", 'C', 200);
        System.out.println("Color: " + secadora.getColor() + "\n" + "Consumo energetico: " + secadora.getConsumoEnergetico());
        System.out.println("Precio final: " + secadora.precioFinal());

        Lavavajillas lavavajillas = new Lavavajillas(200, "azul", 'D', 25);
        lavavajillas.setNumServicios(13);
        System.out.println("Precio final: " + lavavajillas.precioFinal());

        Television SonyBravia = new Television(300, "rojo", 'B', 10, 41, true);
        System.out.println("Precio television: " + SonyBravia.precioFinal());

        Television Samsung = new Television(600, "", 'B', 20, 25, false);
        System.out.println("Precio television: " + Samsung.precioFinal());

        Lavavajillas lavavajillas2 = new Lavavajillas(100, "azul", 'D', 25);
        lavavajillas.setNumServicios(6);

        Electrodomestico secadora2 = new Electrodomestico(150, "verde", 'C', 150);

        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
        electrodomesticos.add(secadora);
        electrodomesticos.add(lavavajillas);
        electrodomesticos.add(SonyBravia);
        electrodomesticos.add(Samsung);
        electrodomesticos.add(lavavajillas2);
        electrodomesticos.add(secadora2);
        electrodomesticos.add(secadora);
        electrodomesticos.add(Samsung);
        electrodomesticos.add(secadora2);
        electrodomesticos.add(secadora);

        int precioTotal = 0;
        int precioTotalElectrodomesticos = 0;
        int precioTotalTelevisores = 0;
        int precioTotalLavavajillas = 0;
        for (Electrodomestico el : electrodomesticos) {
            if (el instanceof Television) {
                precioTotalTelevisores += (int) el.precioFinal();
            }

            if (el instanceof Lavavajillas) {
                precioTotalLavavajillas += (int) el.precioFinal();
            }

            if (el != null) {
                precioTotalElectrodomesticos += (int) el.precioFinal();
            }

            assert el != null;
            precioTotal += (int) el.precioFinal();
        }
        System.out.println("Precio total de todos los electrodomesticos: " + precioTotalElectrodomesticos);
        System.out.println("Precio total de todos los lavavajillas: " + precioTotalLavavajillas);
        System.out.println("Precio total de todos los televisores: " + precioTotalTelevisores);
        System.out.println("Precio total: " + precioTotal);
    }


}