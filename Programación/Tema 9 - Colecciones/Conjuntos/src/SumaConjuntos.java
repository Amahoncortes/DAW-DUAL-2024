import java.util.Iterator;
import java.util.TreeSet;

public class SumaConjuntos {
    public static void main(String[] args) {

        // Crear conjuntos
        TreeSet<Integer> conjunto1 = new TreeSet<>();
        TreeSet<Integer> conjunto2 = new TreeSet<>();

        // Añadir objetos a los conjuntos
        for (int i = 0; i < 10; i++) {
            conjunto1.add(i);
            conjunto2.add(i + 2);
        }

        // Mostrar conjuntos
        System.out.println("Conjunto 1");
        System.out.println(conjunto1);

        System.out.println("Conjunto 2");
        System.out.println(conjunto2);

        // Calcular la suma, resta, y multiplicación de los elementos entre ambos conjuntos
        System.out.println("Operaciones aritméticas entre conjuntos:");

        Iterator<Integer> iterator1 = conjunto1.iterator();
        Iterator<Integer> iterator2 = conjunto2.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            int elementoConjunto1 = iterator1.next();
            int elementoConjunto2 = iterator2.next();

            int suma = elementoConjunto1 + elementoConjunto2;
            int resta = elementoConjunto1 - elementoConjunto2;
            int multiplicacion = elementoConjunto1 * elementoConjunto2;

            System.out.println("Elemento Conjunto 1: " + elementoConjunto1);
            System.out.println("Elemento Conjunto 2: " + elementoConjunto2);
            System.out.println("Suma: " + suma);
            System.out.println("Resta: " + resta);
            System.out.println("Multiplicación: " + multiplicacion);
            System.out.println("-----");
        }

        // Crear nuevo conjunto con la unión de los iniciales
        TreeSet<Integer> unionSet = new TreeSet<>(conjunto1);
        unionSet.addAll(conjunto2);
        System.out.println("Unión de conjunto 1 y 2");
        System.out.println(unionSet);

        // Crear nuevo conjunto con la diferencia de los conjuntos iniciales (borrar elementos de conjunto2 en conjunto1)
        TreeSet<Integer> differenceSet = new TreeSet<>(conjunto1);
        differenceSet.removeAll(conjunto2);
        System.out.println("Diferencia de conjunto1 y conjunto2 (borrar elementos de conjunto2 en conjunto1): ");
        System.out.println(differenceSet);
    }
}
