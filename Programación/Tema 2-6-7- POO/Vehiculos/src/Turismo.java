public class Turismo implements Vehiculo {
    private int velocidadActual;

    Turismo(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    @Override
    public void acelerar(int velocidad) {
        velocidadActual += velocidad;
        if (velocidadActual > VELOCIDAD_MAX) {
            velocidadActual = VELOCIDAD_MAX;
        }
        System.out.println("Velocidad actual del turismo: " +velocidadActual);
    }


    @Override
    public void frenar(int velocidad) {


        velocidadActual -= velocidad;
        if(velocidadActual < 0){
            velocidadActual = 0;
        }

        if (velocidadActual> VELOCIDAD_MAX) {
            velocidadActual = VELOCIDAD_MAX;
        }
        System.out.println("Velocidad actual del turismo: " +velocidadActual);
    }
}
