/*Realiza un script que lea un número y calcule y visualice su factorial.*/

function factorial() {
    let number;
    let producto = 1;

    do {
        number = userInput();

        if (number < 0) {
            console.log("El factorial no está definido para números negativos. Introduce un número no negativo.");
        }
    } while (number < 0);

    for (let index = 1; index <= number; index++) {
        producto *= index;
    }

    return producto;
}

let resultadoFactorial = factorial();
console.log("El factorial es " + resultadoFactorial);


//Crea una función que pida numeros por teclado
function userInput() {
    let input = prompt("Introduce un numero: ");

    // Intenta convertir la entrada a un número
    let number = parseInt(input);

    //Verifica si la conversión ha tenido éxito y si es un número
    if (!isNaN(number)) {
        return number;
    } else {
        console.log("Por favor, introduce un número válido.");
        return userInput();
    }
}