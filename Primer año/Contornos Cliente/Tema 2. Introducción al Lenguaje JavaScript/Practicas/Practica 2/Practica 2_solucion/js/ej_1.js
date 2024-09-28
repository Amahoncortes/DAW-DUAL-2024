/*Ejercicio : Realiza un script al que se le introduce un número e indique si dicho número es primo.
En ese caso mostrará una lista con todos los números primos menores que dicho número.*/

let salidaTexto = document.getElementById("numeroPrimo");

function esPrimo(numero) {
    if (numero < 2) {
        throw new Error("El número debe ser mayor o igual a 2 para determinar si es primo.");
    } else {
        for (let index = 2; index <= Math.sqrt(numero); index++) {
            if (numero % index === 0) {
                return false;
            }
        }
    }
    return true;
}


function imprimirPrimosMenores(numero) {
    let primosMenores = [];
    for (let index = 2; index < numero; index++) {
        if (esPrimo(index)) {
            primosMenores.push(index);
        } 
    }
    return primosMenores;
}

try {
    const numero = parseInt(prompt("Introduce un numero"));
    const resultado = esPrimo(numero);
    const salida = resultado ? `El numero ${numero} es primo. Lista de primos menores: ${imprimirPrimosMenores(numero)}` : "El numero no es primo";
    console.log(salida);
} catch (error) {
    console.error(error.message);
}






