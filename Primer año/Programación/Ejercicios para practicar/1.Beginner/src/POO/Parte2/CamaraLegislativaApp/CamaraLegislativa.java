package POO.Parte2.CamaraLegislativaApp;

import java.util.HashMap;

public class CamaraLegislativa {
    public static void main(String[] args) {

        HashMap<Legislador, String> legisladores = new HashMap<>(5);
        Diputado diputadoAux1 = new Diputado("39464067T", "Abel", "Mahon Cortes", 28, "Pontevedra", "Camara 1", true, 25);
        Diputado diputadoAux2 = new Diputado("39464067T", "Ruben", "Mahon Cortes", 31, "Pontevedra", "Camara 2", false, 32);
        Senador senador1 = new Senador("3911122233B", "Jose Luis", "Mahon Aragon", 63, "Pontevedra", "Camara 3", true, 12);
        Senador senador2 = new Senador("3911122233B", "Maria Dolores", "Cortés González", 63, "Pontevedra", "Camara 4", false, 28);
        Diputado diputado1 = new Diputado("45191945C", "Uxia ", "Pedreira Perez", 25, "Pontevedra", "Camara 5", true, 23);
        legisladores.put(senador1, "1");
        legisladores.put(senador2, "2");
        legisladores.put(diputadoAux1, "3");
        legisladores.put(diputadoAux2, "4");
        legisladores.put(diputado1, "5");

        for (Legislador legislador : legisladores.keySet()) {
            String info = "Clave: " + legislador + "\n" +
                    "Valor: " + legisladores.get(legislador);
            System.out.println(info);

        }
        System.out.println("Camara en la que trabaja cada legislador: " + "\n" +
                "Diputado Aux 1: " + diputadoAux1.getCamaraEnQueTrabaja() + "\n" +
                "Diputado Aux 2: " + diputadoAux2.getCamaraEnQueTrabaja() + "\n" +
                "Senador 1: " + senador1.getCamaraEnQueTrabaja() + "\n" +
                "Senador 2: " + senador2.getCamaraEnQueTrabaja() + "\n" +
                "Diputado 1: " + diputado1.getCamaraEnQueTrabaja());
    }
}
