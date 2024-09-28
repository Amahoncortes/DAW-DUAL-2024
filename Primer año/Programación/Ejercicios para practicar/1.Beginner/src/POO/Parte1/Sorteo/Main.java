package POO.Parte1.Sorteo;

public class Main {
    public static void main(String[] args) {
        Moneda moneda = new Moneda();
        Dado dado = new Dado();

        moneda.lanzar();
        System.out.println(dado.lanzar());

    }

}
