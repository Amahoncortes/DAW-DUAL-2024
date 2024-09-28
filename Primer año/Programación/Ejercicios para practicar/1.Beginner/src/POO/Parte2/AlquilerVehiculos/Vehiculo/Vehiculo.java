package POO.Parte2.AlquilerVehiculos.Vehiculo;

public class Vehiculo {
    private String matricula, marca, modelo, color;
    private String tipo;
    private int tarifa;

    public Vehiculo(String matricula, String marca, String modelo, String color, int tarifa) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
    }

    public Vehiculo(String matricula, String marca, String modelo, String color, String tipo, int tarifa) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public String getAtributos() {
        return "--------------------------" + "\n" +
                "Vehiculo" + "\n" +
                "matricula: " + matricula + "\n" +
                "marca: " + marca + "\n" +
                "modelo: " + modelo + "\n" +
                "color: " + color + "\n" +
                "tipo: " + tipo + "\n" +
                "tarifa: " + tarifa;
    }
}
