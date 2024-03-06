import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {

        // Clase para testear uso de colecciones y la funcionalidad TreeSet

        // Crear conjunto1 con TreeSet
        TreeSet<String> conjunto1 = new TreeSet<>();

        // Crear conjunto2 con TreeSet
        TreeSet<String> conjunto2 = new TreeSet<>();

        // Añadir objetos a los conjuntos
        conjunto1.add("Abel");
        conjunto1.add("Sandra");
        conjunto2.add("Yago");
        conjunto2.add("Andrea");

        // Imprimir los objetos TreeSet
        System.out.println("TreeSet impreso: ");
        System.out.println(conjunto1);
        System.out.println(conjunto2);

        // Imprimir los elementos de cada TreeSet usando iteradores
        System.out.println("Elementos de conjunto1 usando iterador:");
        for (String s : conjunto1) {
            System.out.println(s);
        }

        // Crear nuevo conjunto con la unión de los conjuntos iniciales
        TreeSet<String> unionSet = new TreeSet<>(conjunto1);
        unionSet.addAll(conjunto2);
        System.out.println("Unión de conjunto1 y conjunto2: ");
        System.out.println(unionSet);

        // Crear nuevo conjunto con la diferencia de los conjuntos iniciales (borrar elementos de conjunto2 en conjunto1)
        TreeSet<String> differenceSet = new TreeSet<>(conjunto1);
        differenceSet.removeAll(conjunto2);
        System.out.println("Diferencia de conjunto1 y conjunto2 (borrar elementos de conjunto2 en conjunto1): ");
        System.out.println(differenceSet);
    }
}
