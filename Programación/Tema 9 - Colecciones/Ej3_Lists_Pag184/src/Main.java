import java.util.Scanner;

/*Desarrolla un programa que lea constantemente desde
* la entrada estándar hasta recibir un enter como finalizador.
* Cada carácter será almacenado de forma independiente en una colección que permitirá
* recuperar el contenido en orden inverso al que fue introducido.
* Una vez recibido enter, recorre la colección mostrando por pantalla
* el contenido almacenado.
* Recuerda que los caracteres deben leerse por separado y no se se debe emplear la clase String*/
public class Main {
    public static void main(String[] args) {
try {
    Scanner sc = new Scanner(System.in);


    Test test = new Test(10);
    String word = "yoquesexdd";
    System.out.println("Palabra introducida: " + word);
    System.out.println("Palabra revertida: " + test.reverseWord(word));
} catch (Exception e){
    e.printStackTrace();
        }
    }
}
