import java.util.ArrayList;

public class Pila implements CollectionInterface {

    /*
     * A continuación, escribe una clase Pila, que implemente esta clase,
     * utilizando para ello un array y un contador de objetos.
     * */

    private Object[] array;
    private int contador;

    //constructor


    public Pila() {
        array = new Object[10];
        contador = 0;
    }

    // isEmpty(): devuelve true si la colección está vacía y false en caso contrario.
    @Override
    public boolean isEmpty() {
        return contador == 0; //devuelve true si el contador está vacío
    }

    // get(): devuelve y elimina el primer elemento de la colección.
    @Override
    public Object get() {
        if (!isEmpty()) {
            Object resultado = array[contador - 1]; //LIFO
            contador--;
            return resultado;
        }
        return null;
    }

    // first(): devuelve el primer elemento de la colección.
    @Override
    public Object first() {
        if (!isEmpty()) {
            Object resultado = array[contador - 1]; //LIFO
            return resultado;
        }
        return null;
    }

    // add(): añade un objeto por el extremo que corresponda,
    // y devuelve true si se ha añadido y false en caso contrario.
    @Override
    public boolean add(Object obj) {
        if (contador < array.length) {
            array[contador] = obj;
            contador++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Longitud de la pila: " + array.length + "\n"
                + "Numero de elementos: " + contador;
    }
}
