import java.util.Scanner;

public class NumerosNegativos {
    public static void main(String[] args) {
        int numero;
        int contador = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero");
        numero = sc.nextInt();

        while (numero >= 0) {
            System.out.println("Numero " + numero + " añadido");
            contador++;
            System.out.println("Introduce un numero");
            numero = sc.nextInt();
        }
        System.out.println("Total de numeros añadidos: " + contador);
    }
}