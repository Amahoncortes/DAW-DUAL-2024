window.onload = function () {
    const formulario = document.getElementById("formulario");

    if (!formulario) {
        console.error("No se encontró el botón de crear");
        return;
    }

    //Escuchador de eventos
    formulario.addEventListener('submit', crearNumero);


    function crearNumero(event) {
        event.preventDefault();
        //Obtencion de elementos:
        const texto = document.getElementById("texto");

        //Existen?
        if (texto.value === '' || !texto) {
            console.error('Faltan elementos en el formulario');
            return;
        }
        const valorTexto = texto.value;

        if (isNaN(valorTexto)) {
            mostrarVinhetas(valorTexto);
            // Restablecer los campos del formulario
            formulario.reset();
            texto.focus();
        } else {
            alert("No se puede introducir un valor numerico")
            formulario.reset();
        }
    }

    function mostrarVinhetas (texto) {
        if (texto) {
            //lista
            const lista = document.getElementById('lista');
            //parrafo
            const parrafo = document.createElement('p');
            parrafo.textContent = texto; //mejor usar textContent que innerHTML
            //append
            lista.appendChild(parrafo);
            parrafo.addEventListener('click', eliminarCampo);
            parrafo.addEventListener('contextmenu', cambiarColor);
        } else {
            alert('Texto no válido');
        }
    }

    function eliminarCampo(event) {
        //Prevenir el comportamiento predeterminado del evento, como enviar un formulario.
        event.preventDefault();

        // Obtener el elemento actual en el que se desencadenó el evento.
        const item = this;

        // Eliminar el elemento del DOM.
        item.remove();
    }

    function cambiarColor(event) {
        event.preventDefault();

        //obtenemos el elemento
        const element = this;

        //Color del texto
        const textColor = randomColor();

        //Color del fondo
        const backgroundColor = randomColor();

        element.style.color = textColor;
        element.style.textDecoration = "line-through";
        element.style.color = "white";
        element.style.size = "200px";
        element.style.backgroundColor = backgroundColor;
    }

    function randomColor() {
        return '#' + Math.floor(Math.random() * 16777215).toString(16);
    }
};



