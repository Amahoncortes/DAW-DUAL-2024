public class AguaMineral extends Bebida {
    //Atributos
    private String origen;

    //Constructores

    //Por defecto
    public AguaMineral() {
        super();
        this.origen = "";
    }

    public AguaMineral(String origen) {
        this.origen = origen;
    }

    //Getters y setters
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public double calcularPrecio() {
        String envase = getTipoEnvase();
        double precioActual = getPrecio();
        String marca = getMarca();
        if (envase.equalsIgnoreCase("cristal")) {
            precioActual += precioActual * 0.1;
        }
        if (marca.equalsIgnoreCase("aquaron")) {
            precioActual += 0.30;
        }

        //actualizar precio
        setPrecio(precioActual);
        return getPrecio();
    }

}