package POO.InstalacionElectrica;

public class Lavavajillas extends Electrodomestico {
    private int numServicios;
    private final int MAX = 12;

    public Lavavajillas() {
    }

    public Lavavajillas(double precioBase, double peso) {
        super(precioBase, peso);
    }

    public Lavavajillas(double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso);
    }

    public int getNumServicios() {
        return numServicios;
    }

    public void setNumServicios(int numServicios) {
        this.numServicios = numServicios;
    }

    @Override
    public double getPrecioBase() {
        return super.getPrecioBase();
    }

    @Override
    public void setPrecioBase(double precioBase) {
        super.setPrecioBase(precioBase);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public char getConsumoEnergetico() {
        return super.getConsumoEnergetico();
    }

    @Override
    public void setConsumoEnergetico(char consumoEnergetico) {
        super.setConsumoEnergetico(consumoEnergetico);
    }

    @Override
    public double getPeso() {
        return super.getPeso();
    }

    @Override
    public void setPeso(double peso) {
        super.setPeso(peso);
    }

    @Override
    public double precioFinal() {
        if(this.numServicios > MAX){
            return super.precioFinal() + 60;
        }
        return super.precioFinal();
    }
}
