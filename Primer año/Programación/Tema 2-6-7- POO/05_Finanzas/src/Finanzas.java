public class Finanzas {
    // Factor de cambio por defecto
    private double cambio;

    // Constructor por defecto que establece el cambio en 1.36
    public Finanzas() {
        this.cambio = 1.36;
    }

    // Constructor que permite configurar el cambio
    public Finanzas(double cambio) {
        this.cambio = cambio;
    }

    // Getter para obtener el valor actual del cambio
    public double getCambio() {
        return cambio;
    }

    // Setter para cambiar el valor del cambio
    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    // Método para convertir dólares a euros
    public double dolaresToEuros(double dolares) {
        // Dividir la cantidad en dólares por el cambio (cantidad más pequeña)
        return dolares / this.cambio;
    }

    // Método para convertir euros a dólares
    public double eurosToDolares(double euros) {
        // Multiplicar la cantidad en euros por el cambio
        return euros * this.cambio;
    }
}
