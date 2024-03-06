public class Refresco extends Bebida {

    /*
     * Por el contrario, para los refrescos, queremos saber su porcentaje de azúcar
     * y si tiene o no alguna promoción
     * (para aplicar un descuento del 15% en el precio).
     * */
    private double porcentajeAzucar;

    private boolean tienePromocion;

    //constructor

    public Refresco() {
        super();
        this.porcentajeAzucar = 0;
        this.tienePromocion = false; //por defecto, no hay promocion
    }

    public Refresco(double porcentajeAzucar) {
        this.porcentajeAzucar = porcentajeAzucar;
    }

    public double getPorcentajeAzucar() {
        return porcentajeAzucar;
    }

    public void setPorcentajeAzucar(double porcentajeAzucar) {
        this.porcentajeAzucar = porcentajeAzucar;
    }

    public boolean isTienePromocion() {
        return tienePromocion;
    }

    public void setTienePromocion(boolean tienePromocion) {
        this.tienePromocion = tienePromocion;
    }

    @Override
    public double calcularPrecio() {
        String envase = getTipoEnvase();
        double precioActual = getPrecio();
        double porcAzucar = getPorcentajeAzucar();

        if (isTienePromocion()) {
        precioActual -= precioActual* 0.85;
        }
        if(envase.equalsIgnoreCase("lata")){
            precioActual -= precioActual* 0.05;
        }
        if(porcAzucar > 10){
            precioActual += precioActual * 0.10;
        }

        //Necesitamos actualizar el precio
        setPrecio(precioActual);
        return getPrecio();
    }

}
