public class Main {
    public static void main(String[] args) {
        Consumo consumo = new Consumo(200, 10, 50, 5);
        System.out.println(consumo.getTiempo());
        System.out.println(consumo.consumoEuros());
        System.out.println(consumo.consumoMedio());
    }
}
