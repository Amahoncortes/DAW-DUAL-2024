package POO.InstalacionElectrica;

import java.util.Objects;

public class Electrodomestico {
    private double precioBase;
    private String color;
    private char consumoEnergetico; //letras entre la A y la F (?)
    private double peso;

    static char[] letras = {'A', 'B', 'C', 'D', 'E', 'F'};
    static String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};

    public Electrodomestico() {
        this.color = "blanco";
        this.consumoEnergetico = 'F';
        this.precioBase = 100;
        this.peso = 5;
    }

    public Electrodomestico(double precioBase, double peso) {
        this.color = "blanco";
        this.consumoEnergetico = 'F';
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        for (char c : letras) {
            if (letra == c) {
                return letra;
            }
        }
        return 'F';
    }

    private String comprobarColor(String color) {
        for (String cl : colores) {
            if (Objects.equals(color, cl)) {
                return color;
            }
        }
        return "blanco";
    }

    public double precioFinal() {
        double incremento = 0;
        double precioFinal = precioBase;

            switch (this.consumoEnergetico) {
                case 'A':
                    incremento += 100;
                    break;
                case 'B':
                    incremento += 80;
                    break;
                case 'C':
                    incremento += 60;
                    break;
                case 'D':
                    incremento += 50;
                    break;

                case 'E':
                    incremento += 30;
                    break;
                case 'F':
                    incremento += 10;
                    break;
            }

        precioFinal += incremento;
        return precioFinal;
    }
}

