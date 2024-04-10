package POO.InstalacionElectrica;

import org.w3c.dom.ls.LSOutput;

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
    }
}
