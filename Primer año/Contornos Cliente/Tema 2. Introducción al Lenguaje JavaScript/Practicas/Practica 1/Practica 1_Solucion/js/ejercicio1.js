/*Ejercicio1: Realiza un script que dados dos números obtenga como resultado la suma, resta, multiplicación y división.
Las operaciones se realizan mediante funciones y el resultado se muestra por pantalla.*/

let a = 5;
let b = 7;


function miSuma(num1, num2) { return num1 + num2 };
function miResta(num1, num2) { return num1 - num2 };
function miMultiplicacion(num1, num2) { return num1 * num2 };
function miDivision(num1, num2) { return num1 / num2};


document.getElementById("suma").innerHTML =  a + " + " + b + " = " + miSuma(a, b);
document.getElementById("resta").innerHTML =  a + " - " + b + " = " + miResta(a, b);
document.getElementById("multiplicacion").innerHTML =  a + " * " + b + " = " + miMultiplicacion(a, b);
document.getElementById("division").innerHTML =  a + " / " + b + " = " + miDivision(a, b);