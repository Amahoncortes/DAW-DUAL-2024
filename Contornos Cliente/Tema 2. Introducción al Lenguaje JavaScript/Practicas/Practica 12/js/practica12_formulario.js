window.addEventListener("DOMContentLoaded", () => {
    console.log("La ventana está completamente cargada.");

    //Creamos referencia a los botones de Enviar y Limpiar
    const botonEnviar = document.getElementById("enviar");
    const botonLimpiar = document.getElementById("limpiar");

    //Creamos referencia al formulario
    const formulario = document.getElementById("formulario");

    //Obtenemos la referencia al div donde se muestran los errores
    let divErrores = document.getElementById("errores");
    let errores = []; //Reiniciamos array de errores

    //Función para validar el nombre y los apellidos 
    function validarNombre() {
        //Creamos referencia a todos los campos a rellenar 
        let nombre = document.getElementById("nombre").value.trim();

        //Definimos el patrón que vamos a usar para la comparacion
        let patron = /^[a-zA-Z\s]+$/;

        //Validar nombre
        if (!patron.test(nombre)) {
            console.log("Nombre introducido de forma incorrecta");
            errores.push("Por favor, introduce un nombre válido");
            document.getElementById("nombre").focus();  // Enfocar el campo de nombre
            return false;
        }
        console.log("Nombre introducido correctamente.");
        return true;
    }

    function validarApellidos() {
        let apellidos = document.getElementById("apellidos").value.trim();

        //Definimos el patrón que vamos a usar para la comparacion
        let patron = /^[a-zA-Z\s]+$/;

        //Validar apellidos
        if (!patron.test(apellidos)) {
            console.log("Apellidos introducidos incorrectamente");
            errores.push("Por favor, introduce apellidos válidos");

            document.getElementById("apellidos").focus();  // Enfocar el campo de apellidos
            return false;
        }
        console.log("Apellidos introducidos correctamente.");
        return true;
    }

    //Funcion para validar la edad
    function validarEdad() {
        let edad = document.getElementById("edad").value.trim();
        let patron = /^\d{1,3}$/;

        //Validar edad
        if (!patron.test(edad)) {
            console.log("Edad introducida de forma incorrecta");
            errores.push("Por favor, introduce una edad correcta.");
            document.getElementById("edad").focus();  // Enfocar el campo de edad
            return false;
        }
        // Si no hay errores, la validación es exitosa
        console.log("Edad introducida correctamente.");
        return true;
    }

    //Funcion para validar el NIF
    function validarNIF() {
        let nif = document.getElementById("nif").value.trim();
        let patron = /^\d{8}[A-Z]$/;

        //Validar nif
        if (!patron.test(nif)) {
            console.log("nif introducido de forma incorrecta");
            errores.push("Por favor, introduce un nif correcto.");
            document.getElementById("nif").focus();  // Enfocar el campo de edad
            return false;
        }
        // Si no hay errores, la validación es exitosa
        console.log("nif introducido correctamente.");
        return true;
    }

    //Funcion para validar el e-mail
    function validarEmail() {
        let email = document.getElementById("email").value.trim();
        let patron = /^[^\s@]+@[^\s@]+\.[^\s@]+\d*$/

        if (!patron.test(email)) {
            console.log("email introducido de forma incorrecta");
            errores.push("Por favor, introduce un email correcto.");
            document.getElementById("email").focus();  // Enfocar el campo de edad
            return false;
        }
        // Si no hay errores, la validación es exitosa
        console.log("email introducido correctamente.");
        return true;
    }

    //Funcion para validar la fechaNacimiento
    function validarFechaNacimiento() {
        let fechaNac = document.getElementById("fecha").value.trim();
        let patron = /^\d{4}-\d{2}-\d{2}$/;
        //let patron2 = /^\d{2}\/\d{2}\/\d{4}$/;

        if (!patron.test(fechaNac)) {
            console.log("Fecha introducida de forma incorrecta");
            errores.push("Por favor, introduce una fecha correcta.");
            document.getElementById("fecha").focus();
            return false;
        }
        // Si no hay errores, la validación es exitosa
        console.log("fecha introducida correctamente.");
        return true;
    }



    //Funcion para validar telefono
    function validarTelefono() {
        let tlf = document.getElementById("telefono").value.trim();
        let patron = /^\d{9}$/;

        //Validar tlf
        if (!patron.test(tlf)) {
            console.log("Telefono introducido de forma incorrecta");
            errores.push("Por favor, introduce un telefono correcto.");
            document.getElementById("telefono").focus();  // Enfocar el campo de edad
            return false;
        }
        // Si no hay errores, la validación es exitosa
        console.log("telefono introducido correctamente.");
        return true;
    }

    function limpiarErrores() {
        divErrores.innerHTML = "";
        errores = [];
    }
    //Función para prevenir el envío del formulario si la validación de algún campo falla
    function prevenirEnvioFormulario(event) {
        limpiarErrores();
        if (!validarNombre() || !validarApellidos() || !validarEdad()
            || !validarNIF() || !validarEmail() || !validarFechaNacimiento()
            || !validarTelefono()) {
            if (errores.length > 0) {
                errores.forEach((error) => {
                    let mensajeError = document.createElement("div");
                    mensajeError.appendChild(document.createTextNode(error));
                    divErrores.appendChild(mensajeError);
                });
                // Si la validación falla, evita el envío del formulario
                event.preventDefault();
            }
        }
    }
    
    //Agregar evento al formulario para prevenir su envio en caso de error
    formulario.addEventListener("submit", prevenirEnvioFormulario);

    //Agregar evento click al botón de limpiar para limpiar mensajes de error
    //botonLimpiar.addEventListener("click", limpiarErrores);
});