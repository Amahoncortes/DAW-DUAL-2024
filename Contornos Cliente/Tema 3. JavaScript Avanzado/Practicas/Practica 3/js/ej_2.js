/**Los elementos habrán de ser creados en el arbol DOM. */

window.addEventListener("DOMContentLoaded", () => {

    /**Paso 1: Añadir el articulo con los botones asociados.*/

    const entrada = document.getElementById("entrada");
    const btnAnadir = document.getElementById("botonAnadir");
    const btnBorrar = document.getElementById("botonBorrar");
    const listaComprados = document.getElementsByClassName("listaComprados");
    const listaEliminados = document.getElementsByClassName("listaEliminados");

    //Añadimos articulo
    entrada.addEventListener("click", e =>{
        e.preventDefault();
        guardarArticulos();
    });

    function guardarArticulos(){
        if()
    }

});