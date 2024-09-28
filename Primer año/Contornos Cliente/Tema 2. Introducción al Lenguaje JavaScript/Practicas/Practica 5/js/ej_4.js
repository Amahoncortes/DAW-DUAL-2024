
function crear() {
    let texto = document.formulario.texto.value;
    console.log(texto);
    // Creamos la etiqueta
    let parrafo = document.createElement("p");
    // Después creamos un nodo de texto
    let nodoTexto = document.createTextNode(texto);
    // Y un elemento "span"
    let span = document.createElement("span");
    // Creamos un segundo nodo de texto
    let nodoTexto2 = document.createTextNode("Prueba");
    // Le vinculamos el segundo nodo de texto a span
    span.appendChild(nodoTexto2);
    // Le vinculamos el primer nodo de texto a parrafo
    parrafo.appendChild(nodoTexto);
    // Le vinculamos el elemento parrafo, que es un nodo, a document.body, para que lo enseñe
    document.body.appendChild(parrafo);
    // Cambia parrafo por span
    let devuelto = document.body.replaceChild(span, parrafo);
    console.log(devuelto);
}

window.onload = function () {
    document.formulario.crear.addEventListener("click", crear);
}

