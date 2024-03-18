public class Motocicleta implements Vehiculo {
    private int velocidadActual;

    Motocicleta(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    @Override
    public void acelerar(int velocidad) {
        velocidadActual += velocidad;
        if (velocidadActual > VELOCIDAD_MAX) {
            velocidadActual = VELOCIDAD_MAX;
        }
        System.out.println("Velocidad actual de la moto: " + velocidadActual);
    }


    @Override
    public void frenar(int velocidad) {

        if (velocidadActual> VELOCIDAD_MAX) {
            velocidadActual = VELOCIDAD_MAX;
        }
        velocidadActual -= velocidad;
        if(velocidadActual < 0){
            velocidadActual = 0;
        }
        System.out.println("Velocidad actual de la moto: " +velocidadActual);
    }
}

