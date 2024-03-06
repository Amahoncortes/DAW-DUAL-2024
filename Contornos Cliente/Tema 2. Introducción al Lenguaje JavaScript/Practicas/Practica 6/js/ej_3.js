/** Crea una aplicación web con un botón y un cuadro de texto.
*Cuando el usuario pulse añadir nota se crea una capa con la nota y tres botones,
los cuales al pulsar o se elimina, pasa a ser el primero o el último.*/

"use strict"

window.addEventListener("DOMContentLoaded", () => {
    console.log("La pagina ha terminado de cargarse")

    //Obtenemos el botón por su ID en el HTML
    let boton = document.getElementById("boton");
    //Le añadimos un addEventListener para que reaccione al evento click
    //ejecutando una funcion
    boton.addEventListener("click", anadirNota);

    /**Creamos una capa llamada cuerpoNotas, que tiene que almacenar 3 botones en su interior */
    function anadirNota() {
        //Añadimos la nota
        let nota = parseInt(document.getElementById("nota").value);

        //hacemos la capa y le añadimos una subseccion div
        let capa = document.getElementById("cuerpoNotas");

        //Añadimos una seccion div
        let seccionBotones = document.createElement("div");

        //Añadimos un nodeText a la seccion para que refleje la nota introducida
        const textoNota = document.createTextNode(nota);

        //Primero hay que crear los botones en el HTML
        //Boton Eliminar
        let botonEliminar = document.createElement("input");
        botonEliminar.value = "Eliminar";
        botonEliminar.type = "button";
        botonEliminar.addEventListener('click', eliminar);

        //Boton Arriba
        let botonArriba = document.createElement("input");
        botonArriba.value = "Arriba";
        botonArriba.type = "button";
        botonArriba.addEventListener('click', arriba);

        //Boton Abajo
        let botonAbajo = document.createElement("input");
        botonAbajo.value = "Abajo";
        botonAbajo.type = "button";
        botonAbajo.addEventListener('click', abajo);


        //Y añadimos la nota y posteriormente los botones
        seccionBotones.appendChild(textoNota);
        seccionBotones.appendChild(botonEliminar);
        seccionBotones.appendChild(botonArriba);
        seccionBotones.appendChild(botonAbajo);

        //Agregar el botón al cuerpo del documento
        capa.appendChild(seccionBotones);

        //Funciones
        function eliminar() {
            console.log("Funcion eliminar");
            //Creamos una referencia al padre del boton Eliminar
            let nodoAEliminar = this.parentNode;
            //Borramos al nodo hijo (seccionBotones) desde su padre
            nodoAEliminar.parentNode.removeChild(nodoAEliminar);
        }

        function arriba() {
            console.log("Funcion arriba");
            let nodoASubir = this.parentNode;
            //Seleccionamos el nodo padre de seccionBotones, que es cuerpoNotas
            let notas = document.getElementById("cuerpoNotas");
            notas.insertBefore(nodoASubir, notas.firstChild);
        }

        function abajo() {
            console.log("Funcion abajo");
            let nodoABajar = this.parentNode;
            let notas = document.getElementById("cuerpoNotas");
            notas.appendChild(nodoABajar);
        }
    }

});

