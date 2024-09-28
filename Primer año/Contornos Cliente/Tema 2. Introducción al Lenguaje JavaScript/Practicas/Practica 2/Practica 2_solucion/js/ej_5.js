/**Realiza un script que halle la media de unos valores numéricos enteros
 *  introducidos por el usuario.
 *  Mostrar el resultado en una alerta.
 *  La introducción de datos se realizará de tal forma que si
 *  se pulsa el botón aceptar el usuario continuará introduciendo valores
 *  y si se pulsa cancelar se muestra el resultado. Se debe comprobar que
 *  los valores introducidos son numéricos, si no es así se mostrará un mensaje
 *  y se seguirán pidiendo datos. También se controlará que se haya introducido
 *  al menos un valor numérico.*/

function ejecutarScript() {
    let contador = 0;
    let resultadoSuma = suma();
    let resultadoMedia = media(resultadoSuma, contador);

    // Crea una función que pida números por teclado
    function userInput() {
        let input = prompt("Introduce un numero (clic en Cancelar para finalizar):");

        // Si el usuario hace clic en "Cancelar" o deja el campo vacío, devuelve null
        if (input === null || input.trim() === "") {
            return null;
        }

        // Intenta convertir la entrada a un número
        let number = parseInt(input);

        // Verifica si la conversión ha tenido éxito y si es un número
        if (!isNaN(number)) {
            return number;
        } else {
            console.log("Por favor, introduce un número válido.");
            return userInput();
        }
    }

    function suma() {
        let suma = 0;
        let number;

        do {
            number = userInput();

            // Si el usuario hace clic en "Cancelar" o deja el campo vacío, termina el bucle
            if (number === null) {
                break;
            }

            // Calcula la suma
            suma += number;
            contador++;
        } while (true);

        return suma;
    }

    function media(suma, contador) {
        if (contador === 0) {
            console.log("No se ingresaron números para calcular la media.");
            return 0;
        }
        // Calcula la media 
        return suma / contador;
    }

    alert("La media es " + resultadoMedia);
}

ejecutarScript();  // Llamada a la función para ejecutar el script
