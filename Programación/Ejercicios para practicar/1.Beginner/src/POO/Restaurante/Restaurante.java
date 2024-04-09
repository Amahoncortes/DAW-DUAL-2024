package POO.Restaurante;

/*El restaurante mexicano de Israel cuya especialidad son las papas con chocos
 nos pide diseñar un método con el que se pueda saber cuántos clientes pueden
  atender con la materia prima que tienen en el almacén.
  El método recibe la cantidad de papas y chocos en kilos y devuelve el número
  de clientes que puede atender el restaurante
  teniendo en cuenta que por cada tres personas,
  Israel utiliza un kilo de papas y medio de chocos.*/
public class Restaurante {
    private double patata;
    private double choco;

    public Restaurante() {
    }

    public Restaurante(double patata, double choco) {
        this.patata = patata;
        this.choco = choco;
    }

    public int clientesAtendibles(double cantidadPatata, double cantidadChoco) {
        int numeroClientes = 0;
        int maxClientesPatata = (int) (cantidadPatata); // cada kilo de patatas atiende a 3 clientes
        int maxClientesChoco = (int) (cantidadChoco / 0.5); //Cada medio kilo de choco atiende a 3 personas.
        int maxClientesGrupo = Math.min(maxClientesPatata, maxClientesChoco);
        //Calcular el numero total de clientes
        numeroClientes = maxClientesGrupo * 3;

        return numeroClientes;
    }
}
