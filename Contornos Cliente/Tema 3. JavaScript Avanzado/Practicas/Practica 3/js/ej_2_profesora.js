/**Los elementos habrán de ser creados en el arbol DOM. */

window.addEventListener("DOMContentLoaded", () => {
    console.log("La pagina se ha cargado correctamente.");

    let contador = 0;
    let valorEscondido = "";

    function anhadir() {
        //Se obtiene la descripcion y el precio
        //let nombre = valorEscondido;
        let nombre = valorEscondido;
        let precio = document.getElementById("precio").value;

        valorEscondido = "";
        //Si el campo NO está vacío
        if (nombre != "") {
            //creamos un elemento li
            const nuevoArticulo = document.createElement("li");
            //Creamos el contenido de texto del li
            const contenido = document.createTextNode(nombre);
            //Se le añaden los hijos al li
            //Creamos los botones del enunciado:
            /**
             * Se añadirá un botón al lado de cada elemento para poder eliminarlo de la lista
             * Se añadirán dos botones al lado de cada elemento para moverlos arriba
             *  o abajo en la lista
             */
            const botonEliminar = crearBotonEliminar(); //Creacion del boton eliminar
            const botonSubir = crearBotonSubir(); //Creacion del boton subir
            const botonBajar = crearBotonBajar(); //Creacion del boton bajar

            nuevoArticulo.appendChild(contenido);
            nuevoArticulo.appendChild(botonEliminar);
            nuevoArticulo.appendChild(botonSubir);
            nuevoArticulo.appendChild(botonBajar);

            const lista = document.getElementById("listaC");
            //Para añadir el producto al final de la lista
            //lista.appendChild(nuevoItem);

            //Para añadirla al principio
            //lista.insertBefore(nuevoArticulo, lista.childNodes[0]);
            lista.appendChild(nuevoArticulo);
            //añadimos el conteo del producto.
            contador++;

            //Creamos el objeto y lo añadimos al LocalStorage, 
            const articulo = new Articulo(nombre, precio);

            //Almacenar JSON en localStorage
            localStorage.setItem(nombre, JSON.stringify(articulo));
        }
        //Vaciamos los campos del formulario
        document.getElementById("entrada").value = "";
        document.getElementById("precio").value = "";
        document.getElementById("entrada").focus();
        console.log("Articulo añadido correctamente. Numero de articulos: ", localStorage.length)
    }

    function crearBotonEliminar() {
        const botonEliminar = document.createElement("input");
        //Definimos los atributos:
        //tipo:
        botonEliminar.type = "button";
        //value
        botonEliminar.value = "x";
        //name
        botonEliminar.name = "elimina" + contador;
        //formulario?????
        botonEliminar.form = "formElimina";
        //Manejador de eventos
        botonEliminar.addEventListener("click", eliminar);
        //Devuelve la variable
        return botonEliminar;
    }

    function eliminar() {
        //Toma el <li> donde está el botón
        const nodoLi = this.parentNode;
        const textoNuevoEliminar = nodoLi.firstChild.textContent;
        //Borramos el nodoLi (el articulo)
        nodoLi.parentNode.removeChild(nodoLi);

        //Crear un nuevo elemento en la lista de eliminados
        const nuevoItem = document.createElement("li");
        //Se crea el contenido de texto 
        const contenido = document.createTextNode(textoNuevoEliminar);
        nuevoItem.appendChild(contenido);

        const lista = document.getElementById("listaE");

        //Añadimos el producto al final
        lista.appendChild(nuevoItem);
        console.log(nuevoItem);

        //Borrar el archivo del localStorage, lo cual se realiza a través de su clave,
        //en este caso, el nombre

        localStorage.removeItem(textoNuevoEliminar);

        //Comprobamos que se ha eliminado
        //Recorremos localStorage
        for (let i = 0; i < localStorage.length; i++) {
            const articuloGuardado = localStorage.getItem(localStorage.key(i));
            //Convertir el string JSON a un objeto JavaScript
            const articulo = JSON.parse(articuloGuardado);
            console.log("Articulos guardados ", articulo.nombre);
        }
    }


    function crearBotonSubir() {
        const botonSubir = document.createElement("input");
        botonSubir.type = "button";
        botonSubir.value = "Subir";
        botonSubir.name = "sube" + contador;
        botonSubir.form = "formSube";
        botonSubir.addEventListener("click", subir);
        return botonSubir;
    }

    function subir() {
        //Toma el <li> del boton subir
        const articuloActual = this.parentNode;
        const articuloAnterior = articuloActual.previousSibling;
        const lista = articuloActual.parentNode;
        //Con esto ya saca el nodoActual de donde está y lo mueve hacia arriba
        lista.insertBefore(articuloActual, articuloAnterior);
    }

    function crearBotonBajar() {
        const botonBajar = document.createElement("input");
        botonBajar.type = "button";
        botonBajar.value = "Bajar";
        botonBajar.name = "baja" + contador;
        botonBajar.form = "formBaja";
        botonBajar.addEventListener("click", bajar);
        return botonBajar;
    }

    function bajar() {
        const articuloActual = this.parentNode;
        const articuloSiguiente = articuloActual.nextSibling;
        const lista = articuloActual.parentNode;
        lista.insertBefore(articuloActual, articuloSiguiente.nextSibling);
    }


    function borrarTodos() {
        console.log("Borrando listas...");

        const listaC = document.getElementById("listaC");
        const articulosC = listaC.childNodes;
        while (!articulosC.length != 0) {
            listaC.removeChild(listaC.firstChild);
        }

        const listaE = document.getElementById("listaE");
        const articulosE = listaE.childNodes;
        while (!articulosE.length != 0) {
            listaE.removeChild(listaE.firstChild);
        }
        if (localStorage != null) {
            localStorage.clear();
            console.log("Todos los elementos borrados.");
        }

    }

    function borrarListaE(event) {
        const nodoAEliminar = event.target;
        nodoAEliminar.parentNode.removeChild(nodoAEliminar);
    }

    function modificarFondo(event) {
        event.preventDefault();
        const nodoLista = event.target;
        nodoLista.style.color = "red";
        nodoLista.style.background = "blue";
    }

    function inputDatos(e) {
        // Verifica si las teclas Ctrl o Alt no están presionadas
        if (!(e.ctrlKey || e.altKey)) {
            // Intenta prevenir el comportamiento predeterminado del evento
            if (e.preventDefault) { // W3C variant 
                e.preventDefault();
            } else { // IE<=8
                e.returnValue = false;
            }
        }
    
        // Obtiene el código de la tecla del evento (compatible con diferentes navegadores)
        let tecla = e.keyCode || e.which;
        
        // Imprime el código de la tecla en la consola para propósitos de depuración
        console.log("tecla:" + tecla);
    
        // Verifica si el código de la tecla corresponde a un número, letra mayúscula o letra minúscula
        if (((tecla >= 48) && (tecla <= 57)) || ((tecla >= 65) && (tecla <= 90)) || ((tecla >= 97) && (tecla <= 122))) {
            // Obtiene el elemento HTML que activó el evento (compatible con diferentes navegadores)
            let objetivo = e.target || e.srcElement;
            
            // Añade un asterisco al valor actual del elemento HTML que activó el evento
            objetivo.value += "*";
    
            // Almacena en una variable externa el carácter correspondiente a la tecla presionada
            valorEscondido += String.fromCharCode(tecla);
        }
    }
    

    /**Paso 1: Añadir el articulo con los botones asociados.*/

    const botonAnhadir = document.getElementById("botonAnadir");
    const botonBorrar = document.getElementById("botonBorrar");
    const cuadroTexto = document.getElementById("entrada");
    const listaE = document.getElementById("listaE");

    //asignacion de eventos a los botones
    botonAnhadir.addEventListener("click", anhadir);
    botonBorrar.addEventListener("click", borrarTodos);
    listaE.addEventListener("click", borrarListaE);
    listaE.addEventListener("contextmenu", modificarFondo);
    cuadroTexto.addEventListener("keydown", inputDatos);
});
