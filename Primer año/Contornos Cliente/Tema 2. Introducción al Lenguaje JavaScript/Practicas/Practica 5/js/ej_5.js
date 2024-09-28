/**Crea una aplicación web con dos botones: crear y destruir.
 * Cuando el usuario pulse "crear", se añade al body una nueva lista <ul>,
 * cuando pulsa "destruir", se elimina la primera lista que se creó.*/

let contadorListas = 1;

function crear() {

    //Creamos un nuevo elemento de lista(li)
    let li = document.createElement("li");
    let ul = document.createElement("ul");

    li.innerHTML = contadorListas;
    ul.appendChild(li);
    document.body.appendChild(ul);
    contadorListas++;
}

function destruir() {
    let ul = document.querySelector("ul");
    if (ul) {
        // Eliminamos la primera lista no ordenada (ul)
        ul.remove();
    } else {
        alert("No existe ninguna lista que destruir");
    }
}

window.onload = function () {
    document.getElementById("botonCrear").addEventListener("click", crear);
    document.getElementById("botonDestruir").addEventListener("click", destruir);
}