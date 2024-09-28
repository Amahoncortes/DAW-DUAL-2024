import java.util.Scanner;

public class examen_ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroIntroducido;
        int diasValidos = 0;

        System.out.println("Dame un dia(del 1 al 31)");
        numeroIntroducido = sc.nextInt();

        while (numeroIntroducido != -1) {

            if (numeroIntroducido > 31 || numeroIntroducido < 1) {
                System.out.println("Error. Dia invalido");
            } else {
                diasValidos++;
            }
            System.out.println("Dame un dia(del 1 al 31)");
            numeroIntroducido = sc.nextInt();
        }
        System.out.println("Se han introducido un total de " + diasValidos + " dias.");
    }
}
