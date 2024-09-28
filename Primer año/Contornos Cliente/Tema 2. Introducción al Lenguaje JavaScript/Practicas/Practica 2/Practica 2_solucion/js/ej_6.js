/**Realizar un script que lea una nota introducida por teclado 
 * y si la nota introducida es:
 * ◦ 5 --> Aprobado
 *  ◦ 6 --> Bien
 *  ◦ 7 y 8 --> Notable
 *  ◦ 9 y 10 --> Sobresaliente
 *  ◦ Resto --> Suspenso*/


function mostrarNota() {
    let nota = userInput();

    switch (nota) {
        case 5:
            console.log("Aprobado");
            break;
        case 6:
            console.log("Bien");
            break;
        case 7:
        case 8:
            console.log("Notable");
            break;
        case 9:
        case 10:
            console.log("Sobresaliente");
            break;
        default:
            console.log("Suspenso");
    }
}


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

mostrarNota();