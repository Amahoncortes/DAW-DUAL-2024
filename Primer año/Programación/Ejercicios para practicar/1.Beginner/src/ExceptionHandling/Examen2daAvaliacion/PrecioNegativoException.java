package ExceptionHandling.Examen2daAvaliacion;

public class PrecioNegativoException extends Exception {

    public PrecioNegativoException(){

    }

    public PrecioNegativoException(String mensaje){
        super(mensaje);
    }
}
