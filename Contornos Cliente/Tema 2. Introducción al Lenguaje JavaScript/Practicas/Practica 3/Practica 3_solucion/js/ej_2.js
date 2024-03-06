/*
Escribir un programa que lea 10 números de teclado,
los almacene en un array llamado numeros, y los escriba en orden inverso al
que fueron introducidos. La entrada por teclado se hará con la orden prompt().
Debes resolverlo mediante funciones.
Para invocar la función inverso, debes utilizar un parámetros reset.
*/

/**Función para leer 10 numeros de teclado y almacenarlos en un array*/

function leerNumeros() {
    let numeros = [];
    for (let index = 0; index < 10; index++) {
        let numero = prompt("Introduce el numero: ");
        numeros.push(Number(numero));
    }
    return numeros;
}


//Llamada
let numeros = leerNumeros();

console.log("Numeros introducidos: ")
console.log(numeros);
let numerosCopia = numeros;

console.log("Numeros en orden inverso: ")
let numerosInvertidos = numerosCopia.reverse();
console.log(numerosInvertidos);
