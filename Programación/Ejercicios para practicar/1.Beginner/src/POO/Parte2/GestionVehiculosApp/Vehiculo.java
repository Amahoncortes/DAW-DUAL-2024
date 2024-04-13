package POO.Parte2.GestionVehiculosApp;

public interface Vehiculo {
    final int MAX = 120;

    //Metodos abstractos
    public abstract void acelerar(int velocidadAceleracion);
    public abstract void frenar(int velocidadAceleracion);
}
