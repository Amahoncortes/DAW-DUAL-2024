'use strict'


let numeroIntentos = 5;
const numeroAleatorio = Math.floor(Math.random() * 51);


console.log("El numero generado es " + numeroAleatorio);

while (numeroIntentos > 0) {
    let datoUsuario = prompt("Adivina el numero (0-50): ");

    try {
        if (datoUsuario === null) {
            throw "Has cancelado el juego";
        }

        let numeroIntroducido = parseInt(datoUsuario);

        if (isNaN(numeroIntroducido) || numeroIntroducido < 0 || numeroIntroducido > 50) {
            throw "Introducción de datos inválida. Por favor, introduce un número (0-50)";
        }

        if (numeroIntroducido === numeroAleatorio) {
            alert("Enhorabuena. Has acertado.")
            break;
        } else {
            numeroIntentos--;
            if (numeroIntroducido > numeroAleatorio) {
                alert("El numero " + numeroIntroducido + " es mayor que el aleatorio");
            } else {
                alert("El numero " + numeroIntroducido + " es menor que el aleatorio");
            }
        }
    } catch (error) {
        alert(error);
    }
}

if (numeroIntentos == 0) {
    alert("Lo siento, no has conseguido adivinar el numero.")
}