/**Ejercicio 4: Crea un campo de texto que sólo permita introducir dígitos.*/

window.addEventListener("DOMContentLoaded", () => {
    console.log("La pagina ha terminado de cargarse");

    // Referencia al cuadro de texto
    const cuadroNumero = document.getElementById("number");

    // Referencia al botón
    const boton = document.getElementById("button");

    // Referencia a la sección para mostrar el número
    const seccion = document.createElement("div");

    function comprobarValores(event) {
        const valor = cuadroNumero.value;

        // Verificar si el valor es un número válido
        if (/^\d+$/.test(valor)) {
            // Mostrar el número en la sección
            seccion.innerHTML = "Número introducido: " + valor;
        } else {
            // Mostrar mensaje de error
            alert("Por favor, introduce solo dígitos");
        }
    }

    document.body.appendChild(seccion);
    // Agregar evento al botón
    boton.addEventListener('click', comprobarValores);
});