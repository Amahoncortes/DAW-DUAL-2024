package POO.Parte1;

import java.util.Scanner;

public class AdivinarNumero {
    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);
        int n = (int) (Math.random() * 100) + 1;
        do {
            System.out.println("Introduce un numero");
            numero = sc.nextInt();
            if (n > numero) {
                System.out.println("mayor");
            }
            if (n < numero) {
                System.out.println("menor");
            }
        } while (n != numero);
        System.out.println("Has acertado el numero " + n + ".");
    }
}