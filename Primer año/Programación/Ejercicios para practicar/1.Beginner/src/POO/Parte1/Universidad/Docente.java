package POO.Parte1.Universidad;

public class Docente extends Persona {
    private String materia;
    public Docente(String nombre, int edad, String DNI, char sexo, double peso, double altura, String materia) {
        super(nombre, edad, DNI, sexo, peso, altura);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + '\n' +
                "materia " + materia;
    }
}
