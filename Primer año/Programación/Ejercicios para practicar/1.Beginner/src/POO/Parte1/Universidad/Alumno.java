package POO.Parte1.Universidad;

import java.util.Scanner;

public class Alumno extends Persona {
    private String escuela;
    private String grado;
    private boolean internacional;
    private String paisProcedencia;


    public Alumno(String nombre, int edad, String DNI, char sexo, double peso, double altura, String escuela, String grado) {
        super(nombre, edad, DNI, sexo, peso, altura);
        this.escuela = escuela;
        this.grado = grado;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public boolean isInternacional() {
        return internacional;
    }

    public void setInternacional(boolean internacional) {
        this.internacional = internacional;
    }

    public void establecerPaisProcedencia(String paisProcedencia) {
        if (this.internacional) {
            this.paisProcedencia = paisProcedencia;
        } else {
            throw new IllegalStateException("El alumno no es internacional. No se puede almacenar su país de procedencia.");
        }
    }

    @Override
    public String mostrarInfo() {
        if (this.internacional) {
            return super.mostrarInfo() + '\n' +
                    "Pais de procedencia: " + paisProcedencia;
        }
        return super.mostrarInfo();
    }
}
