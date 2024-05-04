// Bloque de código ejecutado cuando la ventana es cargada.
window.onload = function () {

    // Primero, limpiamos el LocalStorage para eliminar cualquier dato existente.
    console.log("Vaciando LocalStorage...");
    localStorage.clear();
    console.log("LocalStorage vaciado.");

    // A continuación, obtenemos los elementos con los que vamos a trabajar.
    const anadirBtn = document.getElementById('botonAnadir');
    const borrarBtn = document.getElementById('botonBorrar');

    /*
    El siguiente bloque de código se ocupa de crear un objeto de clase Articulo y 
    lo almacena en el localStorage cuando el usuario introduce un elemento en el campo de texto
    y hace click en el botón añadir.
    La clase Articulo tiene los siguientes atributos:
    - Nombre (key)
    - Precio
    */

    // Comprueba si los botones anadir o borrar existen y los añade si existen
    if(anadirBtn && borrarBtn) {
        // If both elements exist, add a click event listener to the add button
        anadirBtn.addEventListener('click', anadirArticulo);
        borrarBtn.addEventListener('click', borrarArticulo);
    } else {
        // If any of the elements are not found, log an error message
        console.error("No existen los botones 'Anadir' o 'Borrar'");
    }
}


/**
 * Función para agregar un artículo al LocalStorage.
 * @param {Event} event - El evento que activa la función.
 */
function anadirArticulo(event) {
    // Previene el envío del formulario.
    event.preventDefault();

    // Obtiene los elementos de entrada del formulario.
    const nombreInput = document.getElementById('entrada');
    const precioInput = document.getElementById('precio');

    // Comprueba si los elementos de entrada existen.
    if (!nombreInput || !precioInput) {
        // Si no existen, enseña un error y sale de la función.
        console.error('Faltan elementos en el formulario');
        return;
    }

    // Obtiene los valores de los elementos de entrada y los trimea.
    const nombre = nombreInput.value.trim();
    const precio = precioInput.value.trim();

    // Comprueba si los valores son vacíos.
    if (nombre === '' || precio === '') {
        // Si son vacíos, enseña un error y sale de la función.
        console.error('Por favor, rellena todos los campos');
        return;
    }

    // Crea un nuevo objeto de la clase Articulo con los valores obtenidos.
    const articulo = new Articulo(nombre, precio);

    // Llama a la función rellenarLocalStorage para agregar el artículo al LocalStorage.
    rellenarLocalStorage(articulo);

    // Llama a la función mostrarLocalStorage para mostrar el contenido del LocalStorage.
    mostrarLocalStorage(articulo);
}

/**
 * Esta función toma un objeto de la clase Articulo y lo almacena en el LocalStorage.
 * Primero, verifica si el objeto de Articulo y su nombre son válidos. Si no lo son, 
 * enseña un error y sale de la función.
 * Luego, intenta agregar el objeto al LocalStorage. Si esto es exitoso, obtiene el 
 * objeto del LocalStorage y lo devuelve en la consola. Si hay un error en el proceso, 
 * enseña un error.
 * @param {Object} articulo - El objeto Articulo que se va a almacenar en el LocalStorage.
 */
function rellenarLocalStorage(articulo) {
    // Comprueba si el objeto de Articulo y su nombre son válidos.
    if (articulo && articulo.nombre) {
        try {
            // Intenta almacenar el objeto en el LocalStorage.
            // El nombre del objeto en el LocalStorage es el nombre del artículo.
            localStorage.setItem(articulo.nombre, JSON.stringify(articulo));
            // Obtiene el objeto del LocalStorage y lo devuelve en la consola para comprobación.
            const miArticuloObj = JSON.parse(localStorage.getItem(articulo.nombre));
            console.log(miArticuloObj);
        } catch (error) {
            // Enseña un error si hay un error en el proceso de agregar el objeto al LocalStorage.
            console.error('Error en rellenarLocalStorage:', error);
        }
    } else {
        // Enseña un error si el objeto de Articulo o su nombre son inválidos.
        console.error('Articulo invalido o sin nombre');
    }
}

/**
 * Esta función toma un objeto de la clase Articulo y muestra su contenido en la página web.
 * Primero, verifica si el objeto de Articulo y su nombre son válidos. Si no lo son, 
 * enseña un error y sale de la función.
 * Luego, intenta obtener el objeto del LocalStorage y crear un elemento <li> con el nombre y precio del artículo.
 * Finalmente, muestra el objeto en la consola para comprobación.
 * @param {Object} articulo - El objeto Articulo que se va a mostrar en la página web.
 */
function mostrarLocalStorage(articulo) {
    // Comprueba si el objeto de Articulo y su nombre son válidos.
    if (articulo && articulo.nombre && articulo.precio) {
        try {
            // Obtiene el elemento <ul> con el id "listaC" de la página.
            const lista = document.getElementById('listaC');
            
            // Si el elemento existe...
            if (lista) {
                // Crea un nuevo elemento <li> con el nombre y precio del artículo.
                const li = document.createElement('li');
                li.textContent = `Name: ${articulo.nombre} - Price: ${articulo.precio}`;
                
                // Agrega el elemento <li> al final de la lista.
                lista.appendChild(li);
            }
        } catch (error) {
            // Enseña un error si hay un error en el proceso de mostrar el artículo en la página.
            console.error('Error en mostrarLocalStorage:', error);
        }
    } else {
        // Enseña un error si el objeto de Articulo o su nombre son inválidos.
        console.error('Articulo inválido o sin nombre');
    }

    // Muestra el objeto en la consola para comprobación.
    console.log(localStorage);
}

