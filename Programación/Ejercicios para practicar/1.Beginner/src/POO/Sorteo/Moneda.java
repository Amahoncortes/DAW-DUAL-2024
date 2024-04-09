package POO.Sorteo;

public class Moneda extends Sorteo{
    @Override
    public int lanzar() {
        posibilidades = (int) (Math.random() * 2 +1);
        if(posibilidades == 1){
            System.out.println("Cara");
        } else {
            System.out.println("Cruz");
        }
        return posibilidades;
    }
}
