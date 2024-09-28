package POO.Parte2.GestionVehiculosApp;

public class Turismo implements Vehiculo {
    private int velocidad;

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void acelerar(int velocidad) {
        this.velocidad += velocidad;
        if (this.velocidad > MAX) {
            this.velocidad = MAX;
        }
    }

    @Override
    public void frenar(int velocidad) {
        this.velocidad += velocidad;
        if (this.velocidad <= 0) {
            this.velocidad = 0;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\t" +
                "velocidad: " + velocidad;
    }
}
