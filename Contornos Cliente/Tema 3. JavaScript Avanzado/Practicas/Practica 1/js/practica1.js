document.addEventListener("DOMContentLoaded", function () {
    console.log("La pagina ha terminado de cargarse");

    //Recoger todos los cuadros de texto y alformulario
    const formulario = document.forms["formulario"];
    const modelo = document.getElementById("modelo");
    const marca = document.getElementById("marca");
    const precio = document.getElementById("precio");
    const km = document.getElementById("km");

    //Botones
    const botonCrearVehiculo = formulario.querySelector('input[type="submit"]');
    const botonMostrarVehiculo = document.getElementById("mostrar");

    //Array de vehiculos
    let arrayDeVehiculos = [];

    /*Añadir un botón Mostrar que visualice todos los coches aparcados en el
    aparcamiento.
    Para ello debes crear un método imprimirVehiculo que muestre los datos
    utilizando los métodos de creación de nodos de la estructura DOM.
    */

    function crearVehiculo(event) {
        //Evitamos el envío del formulario
        event.preventDefault();
        //Se almacenan los vehiculos en un arraylist de vehiculos
        let nuevoVehiculo = new Vehiculo(modelo.value, marca.value, precio.value, km.value);
        arrayDeVehiculos.push(nuevoVehiculo);

        //Cuento el total de vehiculos
        console.log("Vehiculo creado. Total de vehiculos:", arrayDeVehiculos.length);

        //Reseteamos los valores del formulario
        formulario.reset();
    }

    function imprimirVehiculo() {
        console.log("Ejecutando imprimirVehiculo. Total de vehiculos:", arrayDeVehiculos.length);
        //Creamos referencia a divVehiculos 
        const divVehiculos = document.getElementById("divVehiculos");


        for (let i = 0; i < arrayDeVehiculos.length; i++) {
            if (arrayDeVehiculos[i] instanceof Vehiculo) {
                const contenedor = document.createElement("div");
                const nodoTexto = document.createTextNode(arrayDeVehiculos[i].mostrarDatos());

                //Appends
                contenedor.appendChild(nodoTexto);
                divVehiculos.appendChild(contenedor);

                //Muestro la informacion completa de los coches 
                console.log(arrayDeVehiculos[i].mostrarDatos());
            } else {
                console.error("Elemento en el array no es instancia válida de Vehiculo");
            }
        }
    }

    //Cuando pulsamos Crear Vehiculo, añademe un vehiculo al array
    botonCrearVehiculo.addEventListener("click", crearVehiculo);
    //Cuando pulsemos mostrar, muestra todos los coches aparcados.
    botonMostrarVehiculo.addEventListener("click", imprimirVehiculo);
});