//Clase Pelicula

/**
 * 1. Crea un objeto javascript PELICULA con los siguientes campos 
 * ▪Titulo:
 * ▪Director:
 * ▪Duración
 */

class Pelicula {
    constructor(titulo, director, duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }


    //getters y setters
    getTitulo() { return this.titulo; }
    setTitulo(titulo) { this.titulo = titulo; }

    getDirector() { return this.director; }
    setDirector(director) { this.director = director; }

    getDuracion() { return this.duracion; }
    setDuracion(duracion) { this.duracion = duracion; }
}