package POO.Parte2.SeresVivos;

public class Vegetal extends SerVivo {
    private int altura;

    public Vegetal(String nombre_cientifico, String nombre_comun, int altura) {
        super(nombre_cientifico, nombre_comun);
        this.altura = altura;
    }

    public Vegetal(String nombre_cientifico, String nombre_comun, String habitat, String reproduccion, int edad_maxima, String color, int altura) {
        super(nombre_cientifico, nombre_comun, habitat, reproduccion, edad_maxima, color);
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "altura: " + altura;
    }

    @Override
    public void formaAlimentacion() {
        System.out.println("Fotosintesis");
    }
}
