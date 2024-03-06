/*Realiza un script que lea una secuencia de números introducidos por teclado y calcula y visualiza su suma y media.
 La secuencia terminará cuando el número introducido sea cero. */
let contador = 0;

function suma() {
    let suma = 0;
    let number;

    do {
        number = userInput();
        // Calcula la suma
        suma += number;
        contador++;
    } while (number !== 0);

    return suma;
}

function media(suma, contador) {
    if (contador === 0) {
        console.log("No se ingresaron números para calcular la media.");
        return 0;
    }
    // Calcula la media 
    return suma / (contador - 1);
}

let resultadoSuma = suma();
let resultadoMedia = media(resultadoSuma, contador);

console.log("La suma es " + resultadoSuma);
console.log("La media es " + resultadoMedia);

// Crea una función que pida números por teclado
function userInput() {
    let input = prompt("Introduce un numero: ");

    // Intenta convertir la entrada a un número
    let number = parseInt(input);

    // Verifica si la conversión ha tenido éxito y si es un número
    if (!isNaN(number)) {
        return number;
    } else {
        console.log("Por favor, introduce un número válido.");
        // Aquí podrías considerar agregar un contador de intentos y limitar el número de intentos.
        return userInput();
    }
}
