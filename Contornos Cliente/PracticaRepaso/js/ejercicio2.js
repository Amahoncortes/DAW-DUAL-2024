document.addEventListener('DOMContentLoaded', function () {
    const formulario = document.getElementById('elFormulario');
    const listaComprados = document.getElementById('listaC');
    const listaEliminados = document.getElementById('listaE');

    if (!formulario) {
        console.error('Formulario no encontrado');
        return;
    }

    const anadirBtn = document.getElementById('botonAnadir');
    const borrarBtn = document.getElementById('botonBorrar');
    const nombreInput = document.getElementById('entrada');
    const precioInput = document.getElementById('precio');

    if (!anadirBtn || !borrarBtn || !nombreInput || !precioInput) {
        console.error('Faltan elementos del formulario o botones');
        return;
    }

    formulario.addEventListener('submit', anhadirArticulo);
    borrarBtn.addEventListener('click', borrarArticulos);

    /**
     * Establece el tipo de entrada como 'contraseña' para enmascarar la entrada.
     * @param {HTMLElement} input - El elemento de entrada a enmascarar.
     */
    function maskInput(input) {
        // Establecer el tipo de entrada como 'contraseña'
        input.setAttribute('type', 'password');
    }

    /**
     * This function is triggered when the "Añadir" button is clicked.
     * It prevents the default form submission behavior.
     * It retrieves the values from the input fields for the article name and price.
     * If either of the fields is empty, it displays an alert message and returns.
     * It creates a new instance of the `Articulo` class with the provided name and price.
     * It calls the `rellenarLocalStorage` function to store the article in the local storage.
     * It calls the `mostrarLocalStorage` function to display the article in the "Lista de articulos comprados" list.
     * It resets the form fields.
     * @param {Event} event - The click event object.
     */
    function anhadirArticulo(event) {
        // Prevenir el comportamiento predeterminado de envío del formulario
        event.preventDefault();

        // Recuperar los valores de los campos de entrada para el nombre y el precio del artículo
        const nombre = nombreInput.value.trim();
        const precio = precioInput.value.trim();

        // Si alguno de los campos está vacío, mostrar un mensaje de alerta y retornar
        if (nombre === '' || precio === '') {
            alert('Por favor, rellena todos los campos.');
            return;
        }

        // Crear una nueva instancia de la clase `Articulo` con el nombre y precio proporcionados
        const articulo = new Articulo(nombre, precio);

        // Almacenar el artículo en el almacenamiento local
        rellenarLocalStorage(articulo);

        // Mostrar el artículo en la lista "Lista de artículos comprados"
        mostrarLocalStorage(articulo);

        // Restablecer los campos del formulario
        formulario.reset();
    }

    /**
     * Esta función almacena un artículo en el almacenamiento local.
     * @param {Object} articulo - El objeto del artículo a almacenar.
     */
    function rellenarLocalStorage(articulo) {
        // Verificar si el objeto del artículo es válido y tiene un nombre y un precio
        if (articulo && articulo.nombre && articulo.precio) {
            try {
                // Convertir el objeto del artículo a una cadena JSON y almacenarlo en el almacenamiento local
                // con el nombre del artículo como clave
                localStorage.setItem(articulo.nombre, JSON.stringify(articulo));
            } catch (error) {
                // Si ocurre un error mientras se almacena el artículo en el almacenamiento local, registrar el mensaje de error
                console.error('Error al rellenar LocalStorage.', error);
            }
        } else {
            // Si el objeto del artículo no es válido o no tiene un nombre y un precio, registrar un mensaje de error
            console.error('Artículo no válido o no existe.');
        }
    }

    /**
     * Esta función muestra un artículo en la lista "Lista de artículos comprados" creando un nuevo elemento de ítem de lista y agregándolo a la lista. La función también crea y agrega botones para eliminar, mover hacia arriba y mover hacia abajo el artículo. El objeto del artículo debe tener propiedades 'nombre' y 'precio'. Si el objeto del artículo es inválido o falta 'nombre' o 'precio', se registra un error.
     *
     * @param {Object} articulo - El objeto del artículo a mostrar.
     * @return {void} Esta función no devuelve ningún valor.
     */

    function mostrarLocalStorage(articulo) {
        // Verificar si el objeto 'articulo' existe y tiene propiedades 'nombre' y 'precio'
        if (articulo && articulo.nombre && articulo.precio) {
            // Crear un nuevo elemento de ítem de lista
            const li = document.createElement('li');
            // Establecer el contenido de texto del ítem de lista para mostrar el nombre y el precio del artículo
            li.textContent = `Nombre: ${articulo.nombre} - Precio: ${articulo.precio}`;

            // Crear un botón de eliminar para eliminar el artículo
            const removeButton = document.createElement('button');
            removeButton.textContent = 'x';
            // Agregar un event listener de click al botón de eliminar para manejar la eliminación
            removeButton.addEventListener('click', function (event) {
                // Llamar a la función para mover el artículo a la lista de eliminados
                moverAListaEliminados(li);
                // Detener la propagación inmediata del evento para prevenir un comportamiento no deseado
                event.stopImmediatePropagation();
                // Llamar a la función para eliminar permanentemente el artículo
                eliminarArticulo(li);
            });

            // Crear un botón 'arriba' para mover el artículo hacia arriba en la lista
            const upButton = document.createElement('button');
            upButton.textContent = 'Subir';
            // Agregar un event listener de click al botón 'arriba' para manejar el movimiento del artículo hacia arriba
            upButton.addEventListener('click', function () {
                moverArriba(li);
            });

            // Crear un botón 'abajo' para mover el artículo hacia abajo en la lista
            const downButton = document.createElement('button');
            downButton.textContent = 'Bajar';
            // Agregar un event listener de click al botón 'abajo' para manejar el movimiento del artículo hacia abajo
            downButton.addEventListener('click', function () {
                moverAbajo(li);
            });

            // Adjuntar los botones al elemento de ítem de lista
            li.appendChild(removeButton);
            li.appendChild(upButton);
            li.appendChild(downButton);
            // Adjuntar el elemento de ítem de lista a la lista 'Lista de artículos comprados'
            listaComprados.appendChild(li);
        } else {
            // Registrar un error si el objeto del artículo es inválido o falta 'nombre' o 'precio'
            console.error('Articulo no válido o no existe');
        }
    }

    /**Esta función es responsable de borrar la lista de artículos comprados y el almacenamiento local.    function borrarArticulos() {
     * Mientras haya elementos secundarios en el elemento "listaComprados", eliminar el primer elemento secundario.
     * Este bucle asegura que todos los elementos secundarios sean eliminados.
     */
    function borrarArticulos() {
        while (listaComprados.firstChild) {
            listaComprados.removeChild(listaComprados.firstChild);
        }

        // Limpiar el almacenamiento local.
        // Esto elimina todos los datos almacenados del almacenamiento local.
        localStorage.clear();
    }


    /**
     * Esta función mueve un elemento de ítem de lista de la lista "listaComprados" a la lista "listaEliminados".
     *
     * @param {HTMLElement} li - El elemento de ítem de lista a mover.
     * @return {void} Esta función no devuelve ningún valor.
     */
    function moverAListaEliminados(li) {
        // Eliminar el elemento de ítem de lista de la lista "listaComprados"
        listaComprados.removeChild(li);

        // Adjuntar el elemento de ítem de lista a la lista "listaEliminados"
        listaEliminados.appendChild(li);

        // Eliminar el event listener de 'contextmenu' del elemento de ítem de lista
        li.removeEventListener('contextmenu', cambiarColor);

        // Agregar un event listener de 'click' al elemento de ítem de lista para manejar la eliminación del elemento
        li.addEventListener('click', eliminarArticulo);
    }


    /**
     * Mueve el elemento de la lista de la compra hacia arriba en la lista "listaComprados".
     *
     * @param {HTMLElement} li - El elemento de la lista a mover.
     * @return {void} Esta función no retorna ningún valor.
     */
    function moverArriba(li) {
        // Inserta el elemento 'li' antes del hermano anterior en la lista 'listaComprados'
        listaComprados.insertBefore(li, li.previousSibling);
    }

    /**
     * Mueve el elemento de ítem de lista dado a la siguiente posición hermana en la lista.
     *
     * @param {HTMLElement} li - El elemento de ítem de lista a mover.
     * @return {void} Esta función no devuelve ningún valor.
     */
    function moverAbajo(li) {
        // Get the next sibling of the list item element
        let nodoReferencia = li.nextSibling;

        // Insert the list item element after the next sibling in the parent node
        nodoReferencia.parentNode.insertBefore(li, nodoReferencia.nextSibling);
    }

    /**
     * Esta función es un manejador de eventos para cambiar el color y el fondo de un elemento.
     * Se activa cuando ocurre un evento, como un clic o un desplazamiento.
     *
     * @param {Event} event - El objeto de evento que desencadenó la función.
     */
    function cambiarColor(event) {
        // Prevent the default behavior of the event, such as submitting a form.
        event.preventDefault();

        // Get the current element that the event was triggered on.
        const element = this;

        // Generate a random color for the text color.
        const textColor = randomColor();

        // Generate a random color for the background color.
        const backgroundColor = randomColor();

        // Set the text color of the element to the generated color.
        element.style.color = textColor;

        // Set the background color of the element to the generated color.
        element.style.backgroundColor = backgroundColor;
    }

    /**
     * Esta función es responsable de eliminar un elemento del DOM y del almacenamiento local.
     * Se activa cuando se hace clic en el botón "Eliminar".
     *
     * @param {Event} event - El objeto de evento de clic.
     */
    function eliminarArticulo(event) {
        //Prevenir el comportamiento predeterminado del evento, como enviar un formulario.
        event.preventDefault();

        // Obtener el elemento actual en el que se desencadenó el evento.
        const item = this;

        // Eliminar el elemento del DOM.
        item.remove();

        // Extraer el nombre del artículo del contenido de texto del elemento.
        const articleName = item.textContent.split(' - ')[0].split(': ')[1];

        // Eliminar el artículo del almacenamiento local usando su nombre como clave.
        localStorage.removeItem(articleName);
    }

    function randomColor() {
        return '#' + Math.floor(Math.random() * 16777215).toString(16);
    }
});