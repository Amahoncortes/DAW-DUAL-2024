package ExceptionHandling.Examen2daAvaliacion;

import java.util.InputMismatchException;

public class EdadNegativaException extends Exception {

    public  EdadNegativaException(String mensaje) {
        super(mensaje);
    }
}
