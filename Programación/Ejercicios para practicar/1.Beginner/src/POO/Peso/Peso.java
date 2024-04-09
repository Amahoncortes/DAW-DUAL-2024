package POO.Peso;

public class Peso {
    private double pesoEnKilogramos;
    private String medida;

    public Peso(double kg, String medida) {
        this.pesoEnKilogramos = kg;
        this.medida = medida;
    }

    public double getLibras(){
        double ratioConversion = 2.2046;
        return this.pesoEnKilogramos / ratioConversion;
    }

    public void getLingotes(){

    }

}
