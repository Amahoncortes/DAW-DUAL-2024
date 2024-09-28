package POO.Parte2.SeresVivos;

import java.util.ArrayList;

public class ReinoAnimal {
    public static void main(String[] args) {
        ArrayList<SerVivo> seresVivos = new ArrayList<>(7);
        Animal mantisReligiosa = new Animal("Santarrita alicorta", "mantis religiosa", 2, 35, 4);
        Animal vaca = new Animal("Bos taurus", "Vaca", 50, 50, 4);
        Vegetal helecho = new Vegetal("Pteridium aquilinum", "helecho", 45);
        Vegetal antoceros = new Vegetal("Anthocerotophyta", "Antoceros", 25);

        seresVivos.add(mantisReligiosa);
        seresVivos.add(vaca);
        seresVivos.add(helecho);
        seresVivos.add(antoceros);

        for (int i = 0; i < seresVivos.size(); i++) {
            String info = seresVivos.get(i).toString();
            System.out.println(info);
        }
    }
}
