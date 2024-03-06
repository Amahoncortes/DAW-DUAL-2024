/**Funcionamiento:
▪ El usuario introduce un nombre en el cuadro de texto, en minúsculas
▪ El color se solicita con la lista desplegable
▪ Se elige el tipo de fuente y algunos efectos con casillas de verificación
▪ Al pulsar el botón Enviar se muestra el nombre del usuario con los efectos y formato
seleccionados, así como el primer carácter de cada palabra en mayúscula.
▪ Al mismo tiempo, se abre una ventana donde muestra el nombre del usuario con formato h1,
nombre del usuario con formato y efectos elegidos en el formulario y un botón Cerrar.
▪ Al pulsar el botón cerrar se cierra la nueva ventana.

Requisitos:
▪ Utiliza para la modificación de las propiedades del texto el acceso a las propiedades CSS
mediante el atributo style del elemento HTML que mostrará el texto.
▪ Utiliza la estructura de árbol DOM para mostrar los datos en la nueva ventana
*/
"use strict";

document.addEventListener("DOMContentLoaded", () => {
    console.log("La página ha terminado de cargarse.");

    const nombreInput = document.getElementById("nombre");
    const botonEnviar = document.getElementById("enviar");

    let ventanaEmergente;

    nombreInput.addEventListener('input', convertirAMinusculas);
    botonEnviar.addEventListener('click', enviar);

    function convertirAMinusculas() {
        nombreInput.value = nombreInput.value.toLowerCase();
    }

    function enviar() {
        const nombre = nombreInput.value;
        const spanResultado = document.getElementById("resultado");

        const seccionDatos = document.createElement("div");
        const h1 = crearElementoConNombre(nombre, "h1");
        aplicarEstilos(h1);

        seccionDatos.appendChild(h1);
        spanResultado.appendChild(seccionDatos);

        crearVentana(nombre);
    }

    function crearElementoConNombre(nombre, tipoElemento) {
        const elemento = document.createElement(tipoElemento);
        elemento.innerHTML = nombre.replace(/\b\w/g, l => l.toUpperCase());
        return elemento;
    }

    function aplicarEstilos(elemento) {
        const color = obtenerColor();
        const fuente = obtenerFuente();
        elemento.style.color = color;
        elemento.style.fontFamily = fuente;
        aplicarEfectos(elemento);
    }

    function crearVentana(nombre) {
        ventanaEmergente = window.open("", "_blank", "width=400,height=300,scrollbars=yes");
        const cuerpo = ventanaEmergente.document.body;

        const seccionDatos = document.createElement("div");
        const linea = document.createElement("hr");
        const h3 = crearElementoConNombre(nombre, "h3");
        const h1 = crearElementoConNombre(nombre, "h1");
        aplicarEstilos(h1);

        seccionDatos.appendChild(h3);
        seccionDatos.appendChild(linea);
        seccionDatos.appendChild(h1);

        const botonCerrarVentana = crearBoton("Cerrar", cerrarVentana);
        cuerpo.appendChild(seccionDatos);
        cuerpo.appendChild(botonCerrarVentana);
    }

    function cerrarVentana() {
        ventanaEmergente.close();
    }

    function obtenerColor() {
        return document.getElementsByName("color")[0].value;
    }

    function obtenerFuente() {
        const botonSeleccionado = Array.from(document.getElementsByName("fuente")).find(boton => boton.checked);
        return botonSeleccionado ? botonSeleccionado.value : "";
    }

    function aplicarEfectos(elemento) {
        const checkboxes = document.querySelectorAll('input[type="checkbox"]');
        checkboxes.forEach(checkbox => checkbox.checked && aplicarEfecto(checkbox, elemento));
    }

    function aplicarEfecto(checkbox, elemento) {
        switch (checkbox.name) {
            case "tachado":
                elemento.style.textDecoration = "line-through";
                break;
            case "negrita":
                elemento.style.fontWeight = "bold";
                break;
            case "cursiva":
                elemento.style.fontStyle = "italic";
                break;
            case "versalita":
                elemento.style.textTransform = "uppercase";
                break;
            case "subrayado":
                elemento.style.textDecoration = "underline";
                break;
        }
    }

    function crearBoton(value, clickHandler) {
        const boton = document.createElement("input");
        boton.type = "button";
        boton.value = value;
        boton.addEventListener('click', clickHandler);
        return boton;
    }
});
