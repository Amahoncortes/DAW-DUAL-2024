public class Main {
    public static void main(String[] args) {

        Pila pila = new Pila();
        Coche coche1 = new Coche("volkswagen", "jetta");
        Coche coche2 = new Coche("Renault", "5");
        Coche coche3 = new Coche("Mercedes", "mila");

        pila.add(coche1);
        pila.add(coche2);
        pila.add(coche3);

        System.out.println("La pila está vacía? Si = true || No = false :" + pila.isEmpty());
        System.out.println(pila);
    }
}


