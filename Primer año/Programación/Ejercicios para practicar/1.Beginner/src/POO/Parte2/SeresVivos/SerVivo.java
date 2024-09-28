package POO.Parte2.SeresVivos;

/*
 * Codifica la jerarquía ser vivo, animal y vegetal,
 *  creando las estructuras que consideres necesario
 *  para almacenar de cada elemento, como mínimo nombre científico y nombre común.
 *  Para los animales almacenar peso y altura. Para los vegetales únicamente altura.
 *  Cada ser vivo se alimentará de una manera diferente, por lo que deberá reflejar este aspecto de alguna forma.

 * */
public abstract class SerVivo {
    private String nombre_cientifico;
    private String nombre_comun;
    private String habitat;
    private String reproduccion;
    private int edad_maxima;
    private String color;

    public SerVivo(String nombre_cientifico, String nombre_comun) {
        this.nombre_cientifico = nombre_cientifico;
        this.nombre_comun = nombre_comun;
        this.habitat = "Planeta Tierra";
        this.reproduccion = "sexual/asexual/esporas";
        this.edad_maxima = 16;
        this.color = "marron";
    }

    public SerVivo(String nombre_cientifico, String nombre_comun, String habitat, String reproduccion, int edad_maxima, String color) {
        this.nombre_cientifico = nombre_cientifico;
        this.nombre_comun = nombre_comun;
        this.habitat = habitat;
        this.reproduccion = reproduccion;
        this.edad_maxima = edad_maxima;
        this.color = color;
    }

    public String getNombre_cientifico() {
        return nombre_cientifico;
    }

    public void setNombre_cientifico(String nombre_cientifico) {
        this.nombre_cientifico = nombre_cientifico;
    }

    public String getNombre_comun() {
        return nombre_comun;
    }

    public void setNombre_comun(String nombre_comun) {
        this.nombre_comun = nombre_comun;
    }


    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getReproduccion() {
        return reproduccion;
    }

    public void setReproduccion(String reproduccion) {
        this.reproduccion = reproduccion;
    }

    public int getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(int edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ser Vivo: " + "\n" +
                "nombre_cientifico: " + nombre_cientifico + "\n" +
                "nombre_comun: " + nombre_comun + "\n" +
                "habitat: " + habitat + "\n" +
                "reproduccion: " + reproduccion + "\n" +
                "edad_maxima: " + edad_maxima + "\n" +
                "color: " + color + "\n";
    }

    public abstract void formaAlimentacion();
}
