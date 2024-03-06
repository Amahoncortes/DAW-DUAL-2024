/* 
Realiza un programa que pida introducir un nombre de alumno por teclado,
si el nombre del alumno existe en la lista implementada mediante un array,
se visualizará el mensaje “Encontrado”, si no existe, se visualizará 
el mensaje de “No Encontrado”.
*/


function introducirNombres() {
    let nombre;
    const nombres = ["Abel", "Rubén", "Maria Dolores"];
    nombre = userInput();

    if (nombres.includes(nombre)) {
        console.log("Encontrado")
    } else {
        console.log("No encontrado");
    }
}

//Crea una función que pida strings por teclado
function userInput() {
    let input = prompt("Introduce un nombre: ");

    // Verifica si el usuario ha cancelado la entrada
    if (input === null) {
        console.log("Entrada cancelada por el usuario.");
        return null;
    }

    // Verifica si es un número
    if (!isNaN(input)) {
        console.log("Por favor, introduce un texto válido.");
        return userInput();
    } else {
        return input;
    }
}

introducirNombres(); //llamamos a la función.
