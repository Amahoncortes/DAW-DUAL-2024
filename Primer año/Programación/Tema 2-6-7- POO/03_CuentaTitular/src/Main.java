import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        // Parsear la fecha de nacimiento con un formato específico
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = sdf.parse("2012-05-05");

        Titular titular = new Titular("Abel", fechaNacimiento, "a");
        Cuenta cuenta = new Cuenta(titular);

        //Titular
        System.out.println(titular);
        System.out.println(titular.esMayorDeEdad());

        //Cuenta
        System.out.println(cuenta);
        System.out.println(cuenta.ingresar(1800.50));
        System.out.println(cuenta.ingresar(200));
        System.out.println(cuenta.getCantidad());
        System.out.println(cuenta.retirar(200));
        

    }
}
