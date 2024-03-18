public class Satelite {
    private double meridiano;
    private double paralelo;
    private double distancia_tierra;

    public Satelite(double meridiano, double paralelo, double distancia_tierra) {
        this.meridiano = meridiano;
        this.paralelo = paralelo;
        this.distancia_tierra = distancia_tierra;
    }

    //Método boolean enOrbita(): Este método devolverá false si el satélite está en tierra, y true en caso contrario.
    public boolean enOrbita(double distancia_tierra) {
        return distancia_tierra != 0.0;
    }

    /*
     * Método void variaAltura(double desplazamiento):
     *  Este método acepta un parámetro que será positivo o negativo,
     *  dependiendo de si el satélite tiene que alejarse o acercarse a La Tierra.
     */
    public void variaAltura(double desplazamiento) {
        distancia_tierra += desplazamiento;
    }

    /*Método void variaPosicion(double variap, double variam):
     Este método permite modificar los atributos de posición (meridiano y paralelo)
     mediante los parámetros variap y variam.
     Estos parámetros serán valores positivos o negativos relativos
     que harán que el satélite modifique su posición.
     */
    public void variaPosicion(double variap, double variam) {
        this.paralelo += variap;
        this.meridiano += variam;
    }
}
