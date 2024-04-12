package POO.Parte1;

import java.util.Scanner;

public class CuadradoNumero {
    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero");
        numero = sc.nextInt();

        while(numero > 0){
            System.out.println("El cuadrado de " + numero + " es " + Math.pow(numero, 2) +"\n");
            System.out.println("Introduce un numero");
            numero = sc.nextInt();
        }
    }
}