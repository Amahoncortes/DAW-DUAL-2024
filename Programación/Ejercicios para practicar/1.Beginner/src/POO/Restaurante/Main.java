package POO.Restaurante;

public class Main {
    public static void main(String[] args) {
        Restaurante manolo = new Restaurante();
        System.out.println("El numero de clientes maximo es " +manolo.clientesAtendibles(3, 1.5));
    }
}
