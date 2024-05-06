document.addEventListener('DOMContentLoaded', function () {

    localStorage.clear();

    const anadirBtn = document.getElementById('botonAnadir');
    const borrarBtn = document.getElementById('botonBorrar');
    const nombreInput = document.getElementById('entrada');
    const precioInput = document.getElementById('precio');

    if (!nombreInput || !precioInput) {
        console.error('Faltan elementos del formulario');
        return;
    }

    maskInput(nombreInput);
    maskInput(precioInput);

    if (anadirBtn && borrarBtn) {
        anadirBtn.addEventListener('click', anhadirArticulo);
        borrarBtn.addEventListener('click', borrarArticulos);
    } else {
        console.error("Botones de añadir o borrar no encontrados.");
    }

    function maskInput(input) {
        input.setAttribute('type', 'password');
    }

    function anhadirArticulo(event) {
        event.preventDefault();

        const nombre = nombreInput.value.trim();
        const precio = precioInput.value.trim();

        if (nombre === '' || precio === '') {
            alert('Por favor, rellena todos los campos.');
            return;
        }

        const articulo = new Articulo(nombre, precio);

        rellenarLocalStorage(articulo);
        mostrarLocalStorage(articulo);

        document.forms['elFormulario'].reset();
    }

    function rellenarLocalStorage(articulo) {
        if (articulo && articulo.nombre && articulo.precio) {
            try {
                localStorage.setItem(articulo.nombre, JSON.stringify(articulo));
                const articuloObj = JSON.parse(localStorage.getItem(articulo.nombre));
                console.log(articuloObj);
            } catch (error) {
                console.error('Error al rellenar LocalStorage.', error);
            }
        } else {
            console.error('Artículo no válido o no existe.');
        }
    }

    function mostrarLocalStorage(articulo) {
        // Comprueba que el objeto 'articulo' y sus propiedades 'nombre' y 'precio' existan y tengan valores.
        if (articulo && articulo.nombre && articulo.precio) {
            // Obtiene el elemento con id 'listaC' y 'listaE' y les asigna una variable.
            const listaComprados = document.getElementById('listaC');
            const listaEliminados = document.getElementById('listaE');

            // Si existe el elemento 'listaComprados'
            if (listaComprados) {
                //  crea un nuevo elemento 'li'
                const li = document.createElement('li');
                // Establece el texto del elemento 'li' como el nombre y el precio del objeto 'articulo'.
                li.textContent = `Nombre: ${articulo.nombre} - Precio: ${articulo.precio}`;

                // Crea tres elementos botón : borrar, subir y bajar.
                const removeButton = document.createElement('button');
                removeButton.textContent = 'x';

                const upButton = document.createElement('button');
                upButton.textContent = 'Subir';

                const downButton = document.createElement('button');
                downButton.textContent = 'Bajar';

                // Añade event listeners a los botones.
                removeButton.addEventListener('click', function (event) {
                    // Mueve el elemento 'li' a 'listaEliminados' y elimina el elemento 'li' de 'listaComprados' junto
                    // con sus botones.
                   
                    listaComprados.removeChild(li);
                    listaEliminados.appendChild(li);
                    li.removeChild(removeButton);
                    li.removeChild(upButton);
                    li.removeChild(downButton);
                    li.addEventListener('contextmenu', cambiarColor);

                    event.stopImmediatePropagation();

                    //Al hacer clic sobre un elemento de la zona de eliminados, se elimina de dicha lista.
                    li.addEventListener('click', eliminarArticulo);
                    listaEliminados.appendChild(li);
                    // Elimina el articulo del localStorage.
                    localStorage.removeItem(articulo.nombre);
                    console.log(localStorage);
                });


                upButton.addEventListener('click', function () {
                    // Mueve el elemento li hacia arriba en 'listaComprados'.
                    listaComprados.insertBefore(li, li.previousSibling);
                });

                downButton.addEventListener('click', function () {
                    // Mueve el li hacia abajo en 'listaComprados'.
                    let nodoReferencia = li.nextSibling;
                    nodoReferencia.parentNode.insertBefore(li, nodoReferencia.nextSibling);
                });

                // Vincula los botones al elemento li y entonces vincula el elemento li a 'listaComprados'.
                li.appendChild(removeButton);
                li.appendChild(upButton);
                li.appendChild(downButton);
                //Agrega el elemento li a 'listaComprados'.
                listaComprados.appendChild(li);

            }
        } else {
            // Enseña un error si el objeto articulo no es válido o le faltan propeidades.
            console.error('Articulo no válido o no existe');
        }
    }

    function borrarArticulos() {
        const listaComprados = document.getElementById('listaC');
        const listaEliminados = document.getElementById('listaE');
        while (listaComprados.firstChild) {
            listaComprados.removeChild(listaComprados.firstChild);
        }
        // while (listaEliminados.firstChild) {
        //     listaEliminados.removeChild(listaEliminados.firstChild);
        // }
        localStorage.clear();
    }

    function cambiarColor(event){
        event.preventDefault();
        this.style.color = randomColor();
        this.style.backgroundColor = randomColor();
    }

    function eliminarArticulo(){
        this.remove();
    }

    function randomColor(){
        return '#' + Math.floor(Math.random()*16777215).toString(16);
    }



});