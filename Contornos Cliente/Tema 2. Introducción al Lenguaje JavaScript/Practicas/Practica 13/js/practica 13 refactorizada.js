/**
 * El funcionamiento es el siguiente:
 * 1. Se generan de forma aleatoria 8 números para adivinar.
 * 2. El usuario introduce 4 números.
 * 3. Al final aparece en cada celda los números generados de forma aleatoria,
 * y cambia de color aquellas celdas en las que se adivina el número.
 */

// Función principal para inicializar el juego
function inicializar() {
    // Generar números aleatorios sin repetición
    const numerosAleatorios = generarNumerosAleatorios(8, 1, 16);

    // Obtener los números introducidos por el usuario
    const numerosAIntroducir = obtenerNumerosUsuario(4);

    // Mostrar números aleatorios con un retraso y resaltar los adivinados
    mostrarNumerosAleatorios(numerosAleatorios);
    resaltarNumerosAdivinados(numerosAIntroducir, numerosAleatorios);
}

// Generar una lista de números aleatorios sin repetición en un rango específico
function generarNumerosAleatorios(cantidad, min, max) {
    const numeros = [];

    for (let i = 0; i < cantidad; i++) {
        let numeroAleatorio;

        // Evitar repeticiones
        do {
            numeroAleatorio = Math.floor(Math.random() * (max - min + 1)) + min;
        } while (numeros.includes(numeroAleatorio));

        numeros.push(numeroAleatorio);
    }

    // Ordenar la lista de números generados
    return numeros.sort((a, b) => a - b);
}

// Obtener una lista de números introducidos por el usuario
function obtenerNumerosUsuario(cantidad) {
    const numeros = [];

    for (let i = 0; i < cantidad; i++) {
        numeros.push(parseInt(prompt("Introduce un número")));
    }

    // Mostrar los números introducidos por el usuario en la consola
    console.log(numeros);
    return numeros;
}

// Mostrar los números aleatorios con un retraso
function mostrarNumerosAleatorios(numerosAleatorios) {
    for (const numero of numerosAleatorios) {
        // Mostrar cada número con un retraso incremental
        mostrarNumeroConRetraso(numero, numerosAleatorios.indexOf(numero));
    }
}

// Mostrar un número con un retraso
function mostrarNumeroConRetraso(numero, indice) {
    const elemento = document.getElementById("s" + numero);
    setTimeout(() => {
        // Hacer visible el número
        elemento.style.visibility = "visible";
        // Ocultar el número después de 5 segundos
        setTimeout(() => { elemento.style.visibility = "hidden" }, 5000);
    }, 1000 * indice); // Añadir un retraso incremental para cada número
}

// Resaltar los números adivinados cambiando el color de fondo
function resaltarNumerosAdivinados(numerosAIntroducir, numerosAleatorios) {
    for (const numeroAdivinar of numerosAleatorios) {
        const id = "s" + numeroAdivinar;
        const elemento = document.getElementById(id);

        // Hacer visible el número
        elemento.style.visibility = "visible";

        // Cambiar el color de fondo si el número está en la lista introducida por el usuario
        if (numerosAIntroducir.includes(numeroAdivinar)) {
            elemento.style.background = "yellow";
        }
    }
}
