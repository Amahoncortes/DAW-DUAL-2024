public class Biblioteca {
    private String codigo;
    private String titulo;
    private int anhoPublicacion;

    public Biblioteca(String codigo, String titulo, int anhoPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anhoPublicacion = anhoPublicacion;
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Año de Publicación: " + anhoPublicacion);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnhoPublicacion() {
        return anhoPublicacion;
    }

    public void setAnhoPublicacion(int anhoPublicacion) {
        this.anhoPublicacion = anhoPublicacion;
    }
}
