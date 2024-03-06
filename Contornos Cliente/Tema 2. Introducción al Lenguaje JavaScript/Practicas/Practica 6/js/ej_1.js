/**A partir del fichero p6_ejercicio1 facilitado,
     *escribe el código Javascript necesario que permita la introducción de un código de 5 dígitos.
    Si el código introducido es igual que el que se almacena en la variable codigoValido,
    la cual se genera de forma aleatoria al cargar la página.
    Deberá mostrarse un mensaje de alerta indicando que el código introducido es correcto,
    y mostrando dicho código.
    Otro mensaje de alerta indicando que el mensaje introducido no es correcto.*/

// Nos aseguramos de que la página se cargue antes de hacer nada
window.onload = () => {
    // Generamos el código válido
    const codigoValido = generarCodigoAleatorio();
    console.log(codigoValido);

    // Almacenar codigo introducido
    let codigoIntroducido = "";

    // Función que agrega dígitos al código
    window.agregarDigito = (digito) => {
        // Comprobar que no se hayan introducido 5 dígitos
        if (codigoIntroducido.length < 5) {
            codigoIntroducido += digito; // Añadir el dígito a la variable
        }

        // Verificar si se han ingresado 5 dígitos
        if (codigoIntroducido.length === 5) {
            // Convertir el código introducido a número antes de la comparación
            const codigoIntroducidoNumero = parseInt(codigoIntroducido, 10);

            // Aquí realizamos la comparación con el código válido y mostramos el mensaje correspondiente
            if (codigoIntroducidoNumero === codigoValido) {
                alert("El código introducido es correcto. Código correcto: " + codigoIntroducido);
            } else {
                alert("El código introducido no es correcto.");
            }

            // Reiniciar la variable para permitir nuevos intentos
            codigoIntroducido = "";
        }
    };

    // Función para generar el código aleatorio
    function generarCodigoAleatorio() {
        return Math.floor(Math.random() * 90000) + 10000;
    }
}
