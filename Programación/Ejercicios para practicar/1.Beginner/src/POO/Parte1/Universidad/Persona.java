package POO.Parte1.Universidad;

public class Persona {
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;


    public Persona(String nombre, int edad, String DNI, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = validarEdad(edad);
        this.DNI = DNI;
        this.sexo = validarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String mostrarInfo() {
        return "-----------------" + "\n" +
                "Persona" + "\n" +
                "nombre: " + nombre + '\n' +
                "edad: " + edad + '\n' +
                "DNI: " + DNI + '\n' +
                "sexo: " + sexo + '\n' +
                "peso: " + peso + '\n' +
                "altura: " + altura + '\n';
    }

    private int validarEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 18 años.");
        } else {
            return edad;
        }
    }

    private char validarSexo(char sexo) {
        if (sexo != 'H' && sexo != 'M') {
            throw new IllegalArgumentException("El sexo debe ser 'H' o 'M'.");
        } else {
            return sexo;
        }
    }
}

