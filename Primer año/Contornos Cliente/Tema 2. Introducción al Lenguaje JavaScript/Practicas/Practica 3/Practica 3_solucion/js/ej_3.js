/** Realiza un programa que pide 6 números por pantalla y los almacena en un array.
 * Debe realizar las siguientes acciones. Debes utilizar para cada acción una función.
 * Mostrar el array en el cuerpo de la página y en la consola.
 * Ordenarlos y mostrarlos
 * Invertir su orden y mostrarlos
 * Mostrar el número de elementos que tiene el array
 * Búsqueda de un valor introducido por el usuario que nos diga si lo encuentra y su índice.
 **/


/**Función para leer 6 números por pantalla y almacenarlos en un array.*/
function leerNumeros(numeros) {
    //let numeros = [];
    for (let index = 0; index < 6; index++) {
        let numero = prompt("Introduce el numero: ");
        numeros.push(Number(numero));
    }
    return; //numeros;
}

/**Función para mostrar el array tanto por consola como por pantalla*/
function mostrarArray(numeros) {
    /* const numeros = leerNumeros(); */
    document.getElementById("arrayBasico").innerHTML = numeros;
    console.log("Array: " + numeros);
}

/**Función para ordenar el array y mostrarlo por pantalla*/
function ordenarArray(numeros) {
    /* const numeros = leerNumeros(); */
    const numerosOrdenados = numeros.slice().sort(function (a, b) { return a - b });
    document.getElementById("arrayOrdenado").innerHTML = numerosOrdenados;
    console.log("Array ordenado:" + numerosOrdenados);
    return numerosOrdenados;
}

/**Función para invertir el orden del array y mostrarlo por pantalla*/
function invertirArray(numeros) {
    /*  const numeros = leerNumeros(); */
    const numerosCopia = numeros.slice();
    const numerosInvertidos = numerosCopia.reverse();
    document.getElementById("arrayInvertido").innerHTML = numerosInvertidos;
    console.log("Array invertido:" + numerosInvertidos);
}

/**Función para mostrar el número de elementos que tiene el array.*/
function mostrarLongitud(numeros) {
    /*  const numeros = leerNumeros(); */
    const longitud = numeros.length;
    document.getElementById("longitudArray").innerHTML = longitud;
    console.log("Longitud del array: " + longitud)
}

/**Función para buscar un elemento introducido por el usuario y su indice.*/
function buscarElemento(valorBuscado, array) {
    const indice = array.indexOf(valorBuscado);
    if (indice !== -1) {
        document.getElementById("valorABuscar").innerHTML = "El valor " + valorBuscado + " se encuentra en el indice " + indice;
        console.log("El valor " + valorBuscado + " se encuentra en el indice " + indice);
    } else {
        console.log("El valor " + valorBuscado + " no se encuentra en el array.")
    }

}


//Variables
const numeros = [];

//Llamada a funciones
//const numerosParaBuscar = leerNumeros(numeros);
leerNumeros(numeros);
mostrarArray(numeros);
ordenarArray(numeros);
invertirArray(numeros);
mostrarLongitud(numeros);

//Pedir valor buscado 
const valorBuscado = prompt("Introduce el valor a buscar: ");
buscarElemento(Number(valorBuscado), numeros);





