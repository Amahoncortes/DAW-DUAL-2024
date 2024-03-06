import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<Integer, String> provincias = new HashMap<>();

    public static void main(String[] args) {
        addPostalCodes();
        displayPostalCodes();
        int postalCode = getUserInputPostalCode();
        displayProvinceForPostalCode(postalCode);
        removeProvinces(27, 36);
        displayPostalCodes();
    }

    private static void addPostalCodes() {
        provincias.put(36, "Pontevedra");
        provincias.put(15, "A Coruña");
        provincias.put(32, "Ourense");
        provincias.put(27, "Lugo");
    }

    private static void displayPostalCodes() {
        System.out.println("Datos introducidos en el hashmap: ");
        provincias.forEach((codigoPostal, provincia) ->
                System.out.println("Código Postal: " + codigoPostal + ", Provincia: " + provincia));
    }

    private static int getUserInputPostalCode() {
        System.out.println("Introduce un código postal (de 5 dígitos): ");
        return sc.nextInt();
    }

    private static void displayProvinceForPostalCode(int postalCode) {
        int prefijoCodigoPostal = postalCode / 1000;
        String provinciaAsociada = provincias.get(prefijoCodigoPostal);
        if (provinciaAsociada != null) {
            System.out.println("La provincia asociada al código postal es " + provinciaAsociada);
        } else {
            System.out.println("No se encontró ninguna provincia asociada");
        }
    }

    private static void removeProvinces(int... provincesToRemove) {
        for (int province : provincesToRemove) {
            provincias.remove(province);
        }
    }
}
