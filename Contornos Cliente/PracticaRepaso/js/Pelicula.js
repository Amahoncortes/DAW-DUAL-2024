//Creacion del objeto Pelicula
//titulo, director, duracion

class Pelicula {
   constructor(titulo, director, duracion) {
       this.titulo = titulo;
       this.director = director;
       this.duracion = duracion;
   }
};

//console.log(pelicula.titulo);

//let peliculaJSON = JSON.stringify(pelicula);

//console.log("Pelicula como objeto JSON: \n" + peliculaJSON);

//rellenarLocalStorage();

/**
 * Esta funcion se utiliza para poblar el LocalStorage con el objeto pelicula.
 * Usamos el JSON.stringify para convertir el objeto en un string.
 * Usamos el JSON.parse para convertir el string en un objeto.
 */
//function rellenarLocalStorage() {
    // usamos setItem para guardar el objeto en el localStorage
    // El primer argumento es la clave, que es el titulo de la pelicula.
    // El segundo argumento es el valor, que es el objeto JSON de la pelicula.
    //localStorage.setItem(pelicula.titulo, peliculaJSON);

    // Obtenemos el objeto de la pelicula de localStorage usando la clave como argumento.
    // Convierte el String en un objeto pelicula usando JSON.parse. 
    // Enseñamos el objeto por la consola.
    //console.log(JSON.parse(localStorage.getItem(pelicula.titulo)));
//}


