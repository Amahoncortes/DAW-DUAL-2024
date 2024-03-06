/**Ejercicio 3: Muestra en un textarea los eventos producidos por el ratón en un
botón (mousedown, mouseup, click, contextmenu, dblclick).*/

//Obtén el botón y el area de texto

const boton = document.getElementById("miBoton");
const eventosTextArea = document.getElementById("eventosTextArea");

//Añadimos un escuchador de eventos al boton para cada uno de los elementos especificados

boton.addEventListener("mousedown", mostrarEvento);
boton.addEventListener("mouseup", mostrarEvento);
boton.addEventListener("click", mostrarEvento);
boton.addEventListener("contextMenu", mostrarEvento);
boton.addEventListener("dblclick", mostrarEvento);

//Función para mostrar evento en el area de texto
function mostrarEvento(event) {
    const eventoTexto = `Tipo de evento: ${event.type}\n`;
    eventosTextArea.value += eventoTexto;
}

