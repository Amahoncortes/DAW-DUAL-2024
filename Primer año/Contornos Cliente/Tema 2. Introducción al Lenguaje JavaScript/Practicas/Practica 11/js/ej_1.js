// Cuando se carga la página por completo
window.addEventListener("DOMContentLoaded", () => {
    console.log("La página se ha cargado por completo.");

    // Obtener elementos del DOM
    let campo = document.getElementById("campo");
    let coche1 = document.getElementById("coche1");
    let coche2 = document.getElementById("coche2");
    let campoBoton = document.getElementById("iniciar");
    let tiempo = null; // Variable para almacenar el intervalo de tiempo
    let ganador;

    // Ancho de la ventana del navegador
    let anchoVentana = window.innerWidth;

    // Después de 2 segundos, pedir al usuario que elija el coche ganador
    setTimeout(() => {
        ganador = parseInt(prompt("Indica el coche ganador: 1 - 2"));
        const botonIniciar = document.getElementById("iniciar");

        // Escuchar clic en el botón de inicio y llamar a la función iniciarCarrera
        botonIniciar.addEventListener("click", iniciarCarrera);
    }, 2000);

    // Función que inicia la carrera
    function iniciarCarrera() {
        // Generar velocidades aleatorias para los coches
        let velocidadX1 = Math.floor(Math.random() * 50 + 10);
        let velocidadX2 = Math.floor(Math.random() * 50 + 10);

        // Obtener el ancho del campo y del coche
        let campoWidth = campo.clientWidth;
        let anchoCoche = coche1.clientWidth;

        // Inicializar posiciones de los coches
        let x1 = 0;
        let x2 = 0;

        // Establecer un intervalo de tiempo para mover los coches
        tiempo = setInterval(function () {
            // Actualizar posiciones de los coches
            x1 += velocidadX1;
            x2 += velocidadX2;

            // Actualizar la posición visual de los coches en el DOM
            coche1.style.left = x1 + "px";
            coche2.style.left = x2 + "px";

            // Verificar si un coche ha llegado al final del campo
            if (x1 >= campoWidth - anchoCoche || x2 >= campoWidth - anchoCoche) {
                // Verificar y mostrar el mensaje de ganador o perdedor
                if ((x1 > x2 && ganador === 1) || (x2 > x1 && ganador === 2)) {
                    alert("¡Has ganado!");
                } else {
                    alert("¡Has perdido!");
                }

                // Finalizar el intervalo de tiempo y desactivar el botón de inicio
                clearInterval(tiempo);
                campoBoton.removeEventListener("click", iniciarCarrera);
                campoBoton.setAttribute("disabled", true);
            }
        }, 20);
    }
});