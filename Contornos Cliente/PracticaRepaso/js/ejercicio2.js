document.addEventListener('DOMContentLoaded', function () {

    // Limpia el localStorage para eliminar los datos existentes.
    localStorage.clear();

    const anhadirBtn = document.getElementById('botonAnadir');
    const borrarBtn = document.getElementById('botonBorrar');
    const nombreInput = document.getElementById('entrada');
    const precioInput = document.getElementById('precio');

    if (!nombreInput || !precioInput) {
        console.error('Faltan elementos del formulario');
        return;
    }

    maskInput(nombreInput);
    maskInput(precioInput);

    if (anhadirBtn && borrarBtn) {
        anhadirBtn.addEventListener('click', anhadirArticulo);
        // borrarBtn.addEventListener('click', borrarArticulo);
    } else {
        console.error("Botones de añadir o borrar no encontrados.");
    }

    /**
     * Esta función añade un escuchador de eventos 'input' a un elemento de entrada de texto
     * para reemplazar cada uno de sus caracteres por un asterisco ('*').
     * Cuando el usuario escribe en el elemento de entrada de texto,
     * los caracteres se reemplazan por asteriscos.
     * @param {HTMLElement} input - La entrada a enmascarar.
     */
    function maskInput(input) {

        input.setAttribute('type', 'password');
    }

    /**
     * Esta función se ejecuta cuando se hace clic en el botón "Añadir".
     * Previene el envío del formulario, obtiene los valores de los campos de entrada,
     * crea un nuevo objeto Articulo, y lo añade al LocalStorage.
     * Luego, enseña el articulo añadido en la sección "Lista de articulos comprados".
     * @param {Event} event - El objeto que representa el click del botón.
     */
    function anhadirArticulo(event) {
        // Previene el envío del formulario.
        event.preventDefault();

        // Devuelve los valores del formulario y elimina cualquier espacio en blanco (trim).
        const nombre = nombreInput.value.trim();
        const precio = precioInput.value.trim();

        // Comprueba si el usuario ha rellenado todos los campos.
        if (nombre === '' || precio === '') {
           alert('Por favor, rellena todos los campos.');
            return;
        }

        // Crea un nuevo Articulo con los valores del formulario.
        const articulo = new Articulo(nombre, precio);

        // Añade el articulo al LocalStorage.
        rellenarLocalStorage(articulo);

        // Muestra el articulo anhadido en la sección "Lista de articulos comprados".
        mostrarLocalStorage(articulo);

        //Resetea los campos del formulario.
        document.forms['elFormulario'].reset();
    }

    /**
     * Almacena un objeto 'articulo' en el LocalStorage con una clave 'nombre'.
     * Si el objeto 'articulo' o sus propiedades 'nombre' y 'precio' no son válidas,
     * se muestra un mensaje de error.
     * Si ocurre un error al almacenar o al parsear el objeto 'articulo', se muestra un mensaje de error.
     * El objeto 'articulo' se muestra en la consola.
     * @param {Object} articulo - El objeto que se almacenará en el LocalStorage.
     * @return {void} Esta función no devuelve valores.
     */
    function rellenarLocalStorage(articulo) {
        // Comprueba si el 'articulo' existe y sus atributos 'nombre' y 'precio' son válidos.
        if (articulo && articulo.nombre && articulo.precio) {
            try {
                // Almacena el 'articulo' en el LocalStorage con la clave 'nombre'.
                localStorage.setItem(articulo.nombre, JSON.stringify(articulo));

                // Devuelve el 'articulo' almacenado en el LocalStorage usando la clave 'nombre' y lo parsea a un objeto.
                const articuloObj = JSON.parse(localStorage.getItem(articulo.name));

                // Muestra el 'articulo' almacenado en el LocalStorage en la consola.
                console.log(articuloObj);
            } catch (error) {
                // Enseña un mensaje de error si hay algún error al almacenar el objeto 'articulo' en el LocalStorage.
                console.error('Error al rellenar LocalStorage.', error);
            }
        } else {
            // Muestra un error por consola si el 'articulo' no es válido o no existe.
            console.error('Artículo no válido o no existe.');
        }
    }

    // Esta función tiene un parámetro 'articulo'
    function mostrarLocalStorage(articulo) {
        // Comprueba si el 'articulo' existe y si es un objeto con 'nombre' y 'precio' como atributos
        if (articulo && articulo.nombre && articulo.precio) {
            try {
                // Obtiene el elemento con el id 'listaC' del DOM y lo guarda en la variable 'listaComprados'
                const listaComprados = document.getElementById('listaC');
                const listaEliminados = document.getElementById('listaE');

                // Comprueba si el elemento 'listaComprados' existe.
                if (listaComprados) {
                    // Crea un nuevo elemento 'li'
                    const li = document.createElement('li');

                    // Establece el textContent de li como 'nombre' y 'precio' del 'articulo'.
                    li.textContent = `Nombre: ${articulo.nombre} - Precio: ${articulo.precio}`;

                    //crear un boton para cada elemento que permita borrarlo de la lista
                    const removeButton = document.createElement('button');
                    removeButton.textContent = 'x';

                    //Crear un boton para mover los elementos arriba de la lista
                    const upButton = document.createElement('button');
                    upButton.textContent = 'Subir';

                    //Crear un boton para mover los elementos abajo de la lista
                    const downButton = document.createElement('button');
                    downButton.textContent = 'Bajar';


                    //Le añadimos la funcionalidad al botón para borrar el elemento de la lista
                    removeButton.addEventListener('click', function (){
                        listaEliminados.appendChild(li);
                        listaComprados.removeChild(li);
                        localStorage.removeItem(articulo.nombre);
                    });

                    upButton.addEventListener('click', function(){
                        listaComprados.insertBefore(li, li.previousSibling);
                    })

                    downButton.addEventListener('click', function(){
                        let nodoReferencia = li.nextSibling;
                        nodoReferencia.parentNode.insertBefore(li, nodoReferencia.nextSibling);
                    })

                    //Append del botón al elemento li
                    li.appendChild(removeButton);
                    li.appendChild(upButton);
                    li.appendChild(downButton);
                    // Append de li al elemento 'listaComprados'.
                    listaComprados.appendChild(li);
                }
            } catch (error) {
                // Enseña mensaje de error si hay algun error.
                console.error('Error al mostrar LocalStorage:', error);
            }
        } else {
            // Enseña un mensaje de error si el 'articulo' no existe o no tiene las propiedades correctas.
            console.error('Articulo no válido o no existe');
        }

        // Muestra el LocalStorage por consola.
        console.log(localStorage);
    }
});