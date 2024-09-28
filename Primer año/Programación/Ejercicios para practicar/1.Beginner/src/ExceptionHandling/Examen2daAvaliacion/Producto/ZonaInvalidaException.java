package ExceptionHandling.Examen2daAvaliacion.Producto;

public class ZonaInvalidaException extends Exception {
    public ZonaInvalidaException(){

    }

    public ZonaInvalidaException(String mensaje){
        super(mensaje);
    }
}
