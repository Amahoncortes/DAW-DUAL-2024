/*Ejercicio2: Escribir un programa que lea un número positivo y escriba la tabla de multiplicar de ese número.*/

let userInput = prompt("Introduce un numero");
tablaMultiplicar(userInput);

function tablaMultiplicar(numero) {
    let contenido = "";
    for (let index = 1; index < 10; index++) {
         contenido += numero + " * " + index + " = " + numero * index + "<br>";
    }
    document.getElementById("tablaMultiplicar").innerHTML = contenido;
}



