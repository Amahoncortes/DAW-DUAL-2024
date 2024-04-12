package POO.Parte1.Sorteo;

public class Dado extends Sorteo {
    @Override
    public int lanzar() {
        return (int) (Math.random() * 6 + 1);
    }
}
