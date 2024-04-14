package POO.Parte3.Biblioteca.Prestable;

public class Publicacion {
    private String codigo, titulo;
    private int anhoPublicacion;

    public Publicacion(String codigo, String titulo, int anhoPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anhoPublicacion = anhoPublicacion;
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

    @Override
    public String toString() {
        return "--------------------------" + "\n" +
                this.getClass().getSimpleName() + "\n" +
                "Codigo:" + codigo + "\n" +
                "Titulo: " + titulo + "\n" +
                "Año publicacion: " + anhoPublicacion;
    }
}
