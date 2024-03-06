document.addEventListener("DOMContentLoaded", () => {
    let numerosAleatorios = [];
    let numerosAIntroducir = [];
    let id;

    // Generar 8 números aleatorios distintos entre 1 y 16
    for (let i = 0; i < 8; i++) {
        let isValid = true;
        let numeroAleatorio;

        do {
            numeroAleatorio = Math.floor(Math.random() * 16) + 1;

            if (numerosAleatorios.includes(numeroAleatorio)) {
                isValid = false;
            } else {
                isValid = true;
                numerosAleatorios.push(numeroAleatorio);
            }
        } while (!isValid);
    }

    // Ordenar array de números
    numerosAleatorios = numerosAleatorios.sort((a, b) => a - b);
    console.log(numerosAleatorios);

    // Función para mostrar un valor con retraso
    function mostrarValor(num) {
        let element = document.getElementById("s" + num);
        element.style.visibility = "visible";
        setTimeout(() => {
            element.style.visibility = "hidden";
            element.parentElement.style.background = "cyan";
        }, 2000);
    }

    // Función para mostrar números aleatorios con intervalos
    function mostrarNumeroConIntervalo(i) {
        if (i < numerosAleatorios.length) {
            let num = numerosAleatorios[i];
            mostrarValor(num);
            setTimeout(() => {
                mostrarNumeroConIntervalo(i + 1);
            }, 2000); // Espera 7 segundos antes de mostrar el siguiente número
        } else {
            // Cuando se han mostrado todos los números, pedir input al usuario
            pedirNumerosUsuario();
        }
    }

    // Mostrar números aleatorios con intervalos
    mostrarNumeroConIntervalo(0);

    // Función para pedir números al usuario
    function pedirNumerosUsuario() {
        // 2. El usuario introduce 4 números.
        for (let i = 0; i < 4; i++) {
            numerosAIntroducir[i] = parseInt(prompt("Introduce un numero"));
        }

        // Mostrar en consola los números introducidos por el usuario
        console.log(numerosAIntroducir);

        // Introducir números aleatorios en las celdas y colorearlos
        for (let i = 0; i < numerosAleatorios.length; i++) {
            id = numerosAleatorios[i];
            document.getElementById("s" + id).style.visibility = "visible";

            // Comprobar si el número aleatorio está entre los introducidos por el usuario
            // Si es así, se colorea de amarillo
            for (let j = 0; j < numerosAIntroducir.length; j++) {
                if (numerosAIntroducir[j] == numerosAleatorios[i]) {
                    document.getElementById("s" + id).parentElement.style.background = "yellow";
                }
            }
        }

        // Utilizando la delegación de eventos, poner cada div a la escucha del evento botón derecho del ratón
        function botonDerecho() {
            let divs = document.querySelectorAll("td");
            let numeroIntentos = 0;

            divs.forEach(div => {
                div.addEventListener("contextmenu", function (event) {
                    event.preventDefault(); // Prevenir el menú contextual por defecto
                    let celdaSeleccionada = event.target;

                    // Compara el número adivinado y actualiza el color en consecuencia
                    if (celdaSeleccionada.textContent == numerosAleatorios[numeroIntentos]) {
                        celdaSeleccionada.style.background = "yellow";
                        let num = numerosAleatorios[numeroIntentos]; // Definir num aquí
                        let element = document.getElementById("s" + num);
                        element.style.visibility = "visible";

                        numeroIntentos++;
                    } else {
                        celdaSeleccionada.style.background = "red";
                        setTimeout(() => { alert("Has perdido.") }, 300);
                    }
                    if (numeroIntentos == numerosAleatorios.length) {
                        setTimeout(() => {
                            alert("Has ganado.")
                        }, 200);
                    }
                });
            });
        }

        botonDerecho();


        // Ocultar números aleatorios después de un tiempo
        setTimeout(() => {
            for (let i = 0; i < numerosAleatorios.length; i++) {
                let num = numerosAleatorios[i];
                let element = document.getElementById("s" + num);
                element.style.visibility = "hidden";
                element.parentElement.style.background = "cyan"; // Restaurar el color original
            }
        }, 5000); // Ocultar después de 5 segundos
    }
});