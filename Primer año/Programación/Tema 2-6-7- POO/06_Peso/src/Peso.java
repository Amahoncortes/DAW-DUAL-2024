public class Peso {
    // Atributos de la clase
    private double peso;   // Almacena el peso del objeto en kilogramos
    private String medida;  // Almacena la medida en la que se ha tomado el peso

    // Constructor de la clase
    public Peso(double peso, String medida) {
        this.peso = peso;
        this.medida = medida;
    }

    // Método para obtener el peso en libras
    public double getLibras() {
        switch (medida) {
            case "Lb":
                return peso;   // Si la medida es libras, devuelve el peso tal cual
            case "Li":
                return peso * 32.17;  // Si la medida es lingotes, convierte a libras
            case "Oz":
                return peso / 16.0;   // Si la medida es onzas, convierte a libras
            case "P":
                return peso * 0.05 / 16.0;  // Si la medida es peniques, convierte a libras
            case "K":
                return peso * 2.20462;  // Si la medida es kilos, convierte a libras
            case "G":
                return peso * 0.00220462;  // Si la medida es gramos, convierte a libras
            case "Q":
                return peso * 0.01;  // Si la medida es quintales, convierte a libras
            default:
                return 0.0;  // Si la medida no es reconocida, devuelve 0.0
        }
    }

    // Método para obtener el peso en lingotes
    public double getLingotes() {
        switch (medida) {
            case "Lb":
                return peso / 32.17;  // Si la medida es libras, convierte a lingotes
            case "Li":
                return peso;   // Si la medida es lingotes, devuelve el peso tal cual
            case "Oz":
                return peso / 32.17 * 16.0;  // Si la medida es onzas, convierte a lingotes
            case "P":
                return peso * 0.05 / 32.17;  // Si la medida es peniques, convierte a lingotes
            case "K":
                return peso * 2.20462 / 32.17;  // Si la medida es kilos, convierte a lingotes
            case "G":
                return peso * 0.00220462 / 32.17;  // Si la medida es gramos, convierte a lingotes
            case "Q":
                return peso * 0.01 / 32.17;  // Si la medida es quintales, convierte a lingotes
            default:
                return 0.0;  // Si la medida no es reconocida, devuelve 0.0
        }
    }

    // Método para obtener el peso en una medida específica
    public double getPeso(String nuevaMedida) {
        switch (nuevaMedida) {
            case "Lb":
                return getLibras();  // Devuelve el peso en libras usando el método getLibras()
            case "Li":
                return getLingotes();  // Devuelve el peso en lingotes usando el método getLingotes()
            case "Oz":
                return peso * 35.274;  // Si la medida es onzas, convierte a la nueva medida
            case "P":
                return peso * 16.0 / 0.05;  // Si la medida es peniques, convierte a la nueva medida
            case "K":
                return peso / 2.20462;  // Si la medida es kilos, convierte a la nueva medida
            case "G":
                return peso / 0.00220462;  // Si la medida es gramos, convierte a la nueva medida
            case "Q":
                return peso / 0.01;  // Si la medida es quintales, convierte a la nueva medida
            default:
                return 0.0;  // Si la medida no es reconocida, devuelve 0.0
        }
    }
}
