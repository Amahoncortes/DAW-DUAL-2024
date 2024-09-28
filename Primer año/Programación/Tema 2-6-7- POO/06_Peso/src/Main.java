public class Main {
    public static void main(String[] args) {
        Peso peso = new Peso(50,"K");
        System.out.println("Peso en libras: " +peso.getLibras());
        System.out.println("Peso en onzas: " +peso.getPeso("Oz"));
    }
}
