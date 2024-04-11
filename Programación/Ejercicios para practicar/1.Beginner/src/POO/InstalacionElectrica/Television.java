package POO.InstalacionElectrica;

public class Television extends Electrodomestico {
    private int resolucion = 32;
    private boolean sintonizadorTDT = false;

    public Television() {
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
    }

    public Television(double precioBase, String color, char consumoEnergetico, double peso, int resolucion, boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public int getResolucion() {
        return resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();
        if (resolucion > 40) {
            precioFinal *= 1.3;
        }
        if (isSintonizadorTDT()) {
             precioFinal += 50;
        }

        return precioFinal;
    }
}
