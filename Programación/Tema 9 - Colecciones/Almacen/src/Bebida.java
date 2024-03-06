
public class Bebida extends Producto {

/*Para las bebidas necesitaremos también conocer el tipo de envase
    *en el que se presenta.*/

    //Atributos
    private String tipoEnvase;

    //Constructor

    //Por defecto

    public Bebida() {
        super(); //Constructor por defecto de Producto
        this.tipoEnvase = "";
    }

    public Bebida(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    //Getters y setters

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }


    @Override
    //Método
    public double calcularPrecio(){
        return getPrecio();
    }
}
