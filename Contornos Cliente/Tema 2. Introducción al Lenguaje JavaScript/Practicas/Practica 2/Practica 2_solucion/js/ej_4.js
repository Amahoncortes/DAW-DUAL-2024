/**Realizar un script que muestre los números pares por la consola
 *y los números impares en la página.
 Debes crear un array con varios números.
  Recorres dicho array, y compruebas si el número es par o impar.
 Para hacer dicha comprobación debes utilizar una función EsPar(),
 que recibe un número y devuelve un valor booleano.*/

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let impares = "";

for (let index = 0; index < numbers.length; index++) {
    let resultado = esPar(numbers[index]);
}

document.getElementById("impares").innerHTML = impares;

function esPar(number) {
    if (number % 2 === 0) {
        console.log("El numero " + number + " es par.")
    } else {
        impares += "El numero " + number + " es impar.";
    }
}


