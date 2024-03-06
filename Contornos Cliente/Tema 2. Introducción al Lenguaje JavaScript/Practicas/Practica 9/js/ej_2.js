let esconderMostrar;
let desactivado = false;
let texto;

function cambiarTexto() {
    let escondido = false;
    escondido = !escondido;
    // Oculta el texto con la propiedad display de CSS
    if (escondido) {
        console.log("Subo");
        //esconderMostrar.style.visibility = "hidden"; si usamos hidden, se vuelve no interactable
        esconderMostrar.style.display = "none";
        esconderMostrar.value = "Mostrar";
    } else {
        console.log("Bajo");
        // Muestra otra vez el texto oculto
        //esconderMostrar.style.visibility = "visible";
        esconderMostrar.style.display = "inline-block"; // Muestra el botón
        esconderMostrar.value = "Esconder";
    }
}

function toggleActivarDesactivar() {
    // Cambia el estado de desactivado y actualiza la propiedad disabled del botón
    desactivado = !desactivado;
    document.getElementById("esconderMostrar").disabled = desactivado;
}

const cargar = function () {
    // Obtiene los objetos de la página, el párrafo y los botones
    esconderMostrar = document.getElementById("esconderMostrar");
    console.log(esconderMostrar);
    esconderMostrar.addEventListener("click", cambiarTexto);
    document.getElementById("toggleActivarDesactivar").addEventListener("click", toggleActivarDesactivar);
};

// Asegurarse de que no ejecuta hasta que está cargada toda la estructura DOM,
// similar a window.onload
document.addEventListener("DOMContentLoaded", cargar);

