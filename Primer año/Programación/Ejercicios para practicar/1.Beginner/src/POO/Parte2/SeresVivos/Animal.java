package POO.Parte2.SeresVivos;

public class Animal extends SerVivo {
    private int peso;
    private int altura;
    private int numeroPatas;

    public Animal(String nombre_cientifico, String nombre_comun, int peso, int altura, int numeroPatas) {
        super(nombre_cientifico, nombre_comun);
        this.peso = peso;
        this.altura = altura;
        this.numeroPatas = numeroPatas;
    }

    public Animal(String nombre_cientifico, String nombre_comun, String habitat, String reproduccion, int edad_maxima, String color, int peso, int altura, int numeroPatas) {
        super(nombre_cientifico, nombre_comun, habitat, reproduccion, edad_maxima, color);
        this.peso = peso;
        this.altura = altura;
        this.numeroPatas = numeroPatas;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNumeroPatas() {
        return numeroPatas;
    }

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Peso: " + peso + "\n" +
                "Altura: " + altura + "\n" +
                "Numero de patas: " + numeroPatas;
    }

    @Override
    public void formaAlimentacion() {
        System.out.println("Caza");
    }


}
