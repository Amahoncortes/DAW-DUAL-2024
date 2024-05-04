/**
 * Este snipper de código es un módulo JavaScript que gestiona la funcionalidad
 * de una aplicación de almacenamiento de películas y la visualización.
 * Se agrega un control de eventos al formulario y realiza acciones cuando se enviará el formulario.
 * También se definen funciones auxiliares para manejar el almacenamiento y la visualización de datos de películas.
 */

// Esperar a que la ventana termine de cargarse antes de ejecutar el codigo
window.onload = function () {

    //Reset localStorage
    localStorage.clear();

    // Obtiene el elemento con el id 'formpeliculas'
    const guardarBtn = document.getElementById('formpeliculas');

    // Obtiene el elemento con el id 'formborrarpeliculas'
    const borrarBtn = document.getElementById('formborrarpeliculas');


    //Comprueba si el elemento existe
    if (!guardarBtn) {
        // Enseña un error si el elemento no se encuentra
        console.error('No se encontró el botón de guardar');
        return; //Sale de la función para prevenir ejecutar el resto del código. 
    }

    //Comprueba si el elemento existe
    if (!borrarBtn) {
        // Enseña un error si el elemento no se encuentra
        console.error('No se encontró el botón de borrar');
        return; //Sale de la función para prevenir ejecutar el resto del código.
    }


    // Añade un escuchador de eventos para el evento 'submit' al elemento con el id 'formpeliculas'.
    guardarBtn.addEventListener('submit', manejarClick);
    borrarBtn.addEventListener('submit', borrarPelicula);

    /**
     * Función auxiliar para manejar el envío del formulario.
     * @param {Event} event - El objeto evento representando el envío del formulario.
     */
    function manejarClick(event) {
        // Previene el envío del formulario. 
        event.preventDefault();

        // Obtiene los elementos introducidos con las ids 'addTitulo', 'addDirector', y 'addDuracion'.
        const titulo = document.getElementById('addTitulo');
        const director = document.getElementById('addDirector');
        const duracion = document.getElementById('addDuracion');

        // Comprueba si todos los elementos input existen
        if (!titulo || !director || !duracion) {
            // Si cualquiera de ellos falta, enseña un mensaje de error. 
            console.error('Faltan elementos en el formulario');
            return; // Sale de la función para prevenir ejecución del resto del código. 
        }

        // Crea una nueva instancia de la clase Película.
        const pelicula = new Pelicula(
            titulo.value, // Obtiene el valor introducido en el input 'addTitulo'.
            director.value, // Obtiene el valor introducido en el input 'addDirector'.
            duracion.value // Obtiene el valor introducido en el input 'addDuracion'.
        );

        // Llamamos a la función rellenarLocalStorage para almacenar la película en el localStorage.
        rellenarLocalStorage(pelicula);
        // Llamamos a la función mostrarPelicula para mostrar la opción almacenada en el localStorage. 
        mostrarPelicula(pelicula);
    }

    function borrarPelicula(event) {
        event.preventDefault();
        const peliculaBorrar = document.getElementById('removepelicula');
        const peliculasList = document.getElementById('peliculas');
        const parrafos = peliculasList.getElementsByTagName('p');

        if (!peliculaBorrar) {
            console.error('Faltan elementos en el formulario');
            return;
        }

        for (let index = 0; index < parrafos.length; index++) {
            if (parrafos[index].textContent.includes(peliculaBorrar.value)) {
                parrafos[index].remove();
            }
        }



        localStorage.removeItem(peliculaBorrar.value);
        console.log(localStorage);
    }

    /**
     * Función para almacenar los datos de la pelicula en el localStorage.
     * @param {Object} pelicula - El objeto pelicula que se almacenará en el localStorage. The movie object to be stored
     */
    function rellenarLocalStorage(pelicula) {
        if (pelicula) {
            // Convierte el objeto pelicula a un string JSON
            const peliculaJSON = JSON.stringify(pelicula);
            // Almacena el string JSON en el localStorage con la clave 'pelicula.titulo'.
            localStorage.setItem(pelicula.titulo, peliculaJSON);
            // Dvuelve el valor de la clave del localStorage y lo parsea a un objeto.
            const miPeliculaObj = JSON.parse(
                localStorage.getItem(pelicula.titulo)
            );
            // Hace un log de la variable 'miPeliculaObj' para verificar que se almaceno correctamente.
            console.log(miPeliculaObj);
        } else {
            // Si el objeto de la pelicula es inválido, enseña un error.
            console.error('Pelicula no válida');
        }
    }

    /**
     * Función para enseñar los datos de la película en la página.
     * @param {Object} pelicula - El objeto cuya información vamos a enseñar.
     */
    function mostrarPelicula(pelicula) {
        if (pelicula) {
            // Obtiene el elemento con la id peliculas
            const peliculasList = document.getElementById('peliculas');
            // Crea un elemento párrafo para enseñar la información de la pelicula.
            const peliculasParrafo = document.createElement('p');
            // Establece el contenido del texto del parágrafo para que enseñe la información de la pelicula.
            peliculasParrafo.textContent = `Titulo: ${pelicula.titulo} - Director: ${pelicula.director} - Duración: ${pelicula.duracion}`;
            // Añade el elemento parágrafo a la lista de 'peliculas'.
            peliculasList.appendChild(peliculasParrafo);
        } else {
            // Enseña un error si es inválido.
            console.error('Pelicula no válida');
        }
    }
};
