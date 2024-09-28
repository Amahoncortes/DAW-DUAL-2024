package POO.Parte1.Banco;




public class Main {
    public static void main(String[] args) {
        Titular t1 = new Titular("Jose Luis", "03/10/1962", 'M');
        Titular t2 = new Titular("Rocío", "07/04/2006", 'M');
        Cuenta c1 = new Cuenta(t1, 100.00);

        c1.ingresar(50);
        c1.toString();
        c1.retirar(160);
        c1.toString();

        System.out.println(t1);
        System.out.println(t1.esMayorDeEdad());

        System.out.println(t2);
        System.out.println(t2.esMayorDeEdad());
        t2.comprobarSexo(t2.getSexo());

    }
}
