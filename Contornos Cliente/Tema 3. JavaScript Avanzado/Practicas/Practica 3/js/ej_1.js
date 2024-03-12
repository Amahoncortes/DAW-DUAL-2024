window.addEventListener("DOMContentLoaded", () => {
    console.log("La página ha cargado correctamente.");


    localStorage.clear();
    //Referencias
    const formPeliculas = document.getElementById("formpeliculas");
    const titulo = document.getElementById("addTitulo");
    const director = document.getElementById("addDirector");
    const duracion = document.getElementById("addDuracion");
    const mostrar = document.getElementById("mostrar");
    const divPeliculas = document.getElementById("peliculas");
    const listaPeliculas = document.getElementById("peliculaslist");
    const buscar = document.getElementById("buscar");
    const buscarPelicula = document.getElementById("buscarPelicula");
    const formBorrarPeliculas = document.getElementById("formborrarpeliculas");
    const borrarPelicula = document.getElementById("removepelicula");
    const botonesBorrar = document.querySelectorAll('button[type="submit"]');
    let botonBorrar;

    //Definimos función para guardar en el botón
    formPeliculas.addEventListener("submit", e => {
        e.preventDefault();
        guardarPeliculas();
    });


    //añado método mostrar para ver si efectivamente hay peliculas guardadas (testeo)
    mostrar.addEventListener("click", mostrarPeliculas);

    function mostrarPeliculas() {
        divPeliculas.innerHTML = "";
        const ul = document.createElement("ul");
        divPeliculas.appendChild(ul);
        for (let i = 0; i < localStorage.length; i++) {
            const pelicula = JSON.parse(localStorage.getItem(localStorage.key(i)));
            const li = document.createElement("li");
            ul.appendChild(li);
            li.innerHTML =
                `Titulo: ${pelicula.titulo};
                director: ${pelicula.director};
                duracion: ${pelicula.duracion};`
            console.log("Peliculas mostradas correctamente.");
        }
    }


    //añadimos metodo buscar para buscar peliculas por titulo
    buscar.addEventListener("submit", e => {
        e.preventDefault();
        listaPeliculas.innerHTML = "";
        if (localStorage.getItem(buscarPelicula.value)) {
            const pelicula = JSON.parse(localStorage.getItem(buscarPelicula.value));
            const p = document.createElement("p");
            p.innerHTML =
                `Titulo: ${pelicula.titulo};
                director: ${pelicula.director};
                duracion: ${pelicula.duracion};`
            listaPeliculas.appendChild(p);
        }
    });

    //Metodo Borrar: el usuario introduce una pelicula y al pulsar borrar
    //la elimina del localStorage. En caso de que no exista, se muestra con un alert.

    /** Como el botón borrar no tiene id, ni nada que lo distinga, vamos a combinar selectores
     * para obtener una referencia a dicho botón
     * const botonesBorrar = document.querySelectorAll('button[type="submit"]');
    let botonBorrar;

    // Itera sobre los botones y encuentra el que tiene el texto "Borrar"
    botonesBorrar.forEach(boton => {
        if (boton.textContent.trim() === 'Borrar') {
            botonBorrar = boton;
  }

// Ahora 'botonBorrar' contiene la referencia al botón específico de borrar
     */
    botonesBorrar.forEach(boton => {
        if (boton.textContent.trim() === 'Borrar') {
            botonBorrar = boton;
        }
    });

    botonBorrar.addEventListener("click", () => {
        const peliculaABorrar = borrarPelicula.value;
        if (localStorage.getItem(peliculaABorrar)) {
            localStorage.removeItem(peliculaABorrar);
            console.log("Pelicula borrada. Total de peliculas: ", localStorage.length);
        } else {
            console.error("No se encontró ninguna película con ese nombre");
        }
    })


    function guardarPeliculas() {
        //Comprobamos que los atributos del objeto estén definidos
        //Operador opcional ?. comprueba si nombre está definido antes de intentar acceder a nombre.value
        if (titulo?.value && director?.value && duracion?.value) {
            //Si lo están, creamos un nuevo objeto con los valores
            const pelicula = new Pelicula(titulo.value, director.value, duracion.value);
            //Y lo metemos en el almacenamiento local
            localStorage.setItem(pelicula.getTitulo(), JSON.stringify(pelicula));
            //Imprimimos el total de peliculas
            console.log("Pelicula guardada. Total de peliculas: ", localStorage.length);
            formPeliculas.reset();
        } else {
            console.error("Error. Todos los campos deben tener valores");
        }
    }
});