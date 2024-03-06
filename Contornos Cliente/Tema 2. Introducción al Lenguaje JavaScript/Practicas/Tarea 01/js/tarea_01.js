
/**•Generar un número aleatorio de 0 a 50. Mostrar el número generado por la consola para comprobar
que el programa funciona correctamente.
• Mediante prompt se le solicita un número al usuario. Si Acierta finaliza la ejecución del programa
con un Alert en el que se le indica que “Enhorabuena”
• En caso contrario le indica al usuario si el número es mayor o menor.
• Si transcurridos los 5 intentos no encuentra el número muestra un Alert “Lo siento, no ha conseguido
adivinar el número “*/

function app() {
    let numeroIntentos = 5;
    const numAleatorio = generarNumeroAleatorio();

    while (numeroIntentos > 0) {
        let intento = userInput();

        if (intento === "CANCELADO") {
            console.log("Entrada cancelada por el usuario.");
            break;
        }

        if (!isNaN(intento)) {
            intento = parseInt(intento);
            if (intento === numAleatorio) {
                alert("Enhorabuena. Has acertado.");
                return;
            } else {
                console.log("Número de intentos restantes: " + --numeroIntentos);
                alert("El número " + intento + (intento > numAleatorio ? " es mayor" : " es menor") + " que el número aleatorio.");
            }
        } else {
            console.log("Por favor, introduce un número válido.");
        }
    }

    alert("Lo siento, no has conseguido adivinar el número.");
}

function generarNumeroAleatorio() {
    const numAleatorio = Math.round(Math.random() * 50);
    console.log("Número aleatorio generado: " + numAleatorio);
    return numAleatorio;
}

function userInput() {
    let input = prompt("Introduce un número: ");

    if (input === null) {
        console.log("Entrada cancelada por el usuario.");
        return "CANCELADO";
    }

    if (input.trim() === "" || isNaN(input)) {
        console.log("Por favor, introduce un número válido.");
        return userInput();
    }

    return input;
}

app();
