package POO.Finanzas;

public class Main {
    public static void main(String[] args) {
        Finanzas salario = new Finanzas();
        System.out.println(salario.pesosToEuros(6000) + " euros.");
        System.out.println(salario.eurosToPesos(60) + " pesos.");

        Finanzas salario2 = new Finanzas(17.74F);
    }
}
