/**PRACTICA 10 - DELEGACIÓN DE EVENTOS
1. Ejercicio 1: A partir del fichero Tarea1_UD5.html facilitado, escribe el código Javascript necesario
para realizar las funciones que se describen a continuación.
◦ El usuario introduce el número de filas y columnas
◦ Al pulsar Crear tabla, crea una tabla con las filas y columnas indicadas.
◦ Función Crear Tabla:
▪ Crea una tabla utilizando para ello el método CreateElement y la estructura de parentesco.
▪ Debes modificar el estilo de la tabla para que aparezca con un borde y color azúl.
▪ Modificar también el tamaño de la letra.
A continuación vamos a implementar la funcionalidad de la tabla utilizando la delegación de
eventos. Cada una de las acciones debe implementarse con funciones
• Al hacer dobleclic sobre una fila de la tabla, ésta desaparece.
• Al hacer clic sobre cada una de las filas de la nueva tabla, debe cambiar el color de fondo de
cada una de las celdas
• Al pulsar el botón derecho debes cambiar el color del texto, de todos los elementos de esa
fila.
Pasos:
1. Crear la tabla y modificar el aspecto de la tabla al pulsar el botón
2. Eliminar la fila al hacer dobleclic
3. Cambiar el color de fondo de las celdas */

window.addEventListener("DOMContentLoaded", () => {
    const botonCrear = document.getElementById("crear");

    function crearTabla() {
        const filas = document.getElementById("fila").value;
        const columnas = document.getElementById("columna").value;
        const resultado = document.getElementById("resultado");

        const tabla = document.createElement("table");
        tabla.style.border = "2px solid blue";
        tabla.style.fontSize = "15px";

        for (let i = 0; i < filas; i++) {
            const tr = document.createElement("tr");

            for (let j = 0; j < columnas; j++) {
                const td = document.createElement("td");
                const nodoTexto = document.createTextNode(i);
                td.style.border = "1px solid blue";
                td.style.color = "red";
                td.appendChild(nodoTexto);
                td.addEventListener("click", cambiarColorCeldas);
                tr.appendChild(td);
            }

            tr.addEventListener("dblclick", borrarFila);
            tr.addEventListener("contextmenu", cambiarColorFila);
            tabla.appendChild(tr);
        }

        resultado.innerHTML = "";
        resultado.appendChild(tabla);
    }

    function borrarFila(e) {
        let fila = e.target.parentNode;
        fila.parentNode.removeChild(fila);
    }

    function cambiarColorCeldas() {
        this.style.background = "blueviolet";
    }

    function cambiarColorFila() {
        this.style.background = "green";
    }

    botonCrear.addEventListener('click', crearTabla);
});
