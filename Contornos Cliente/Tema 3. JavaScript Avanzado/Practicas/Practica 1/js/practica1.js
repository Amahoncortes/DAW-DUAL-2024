document.addEventListener("DOMContentLoaded", function () {
    console.log("La pagina ha terminado de cargarse");

    //Recoger todos los cuadros de texto y el formulario

    const formulario = document.getElementById("crearVehiculos"); //formulario
    const modelo = document.getElementById("modelo"); //modelo
    const marca = document.getElementById("marca"); //marca
    const precio = document.getElementById("precio"); //precio
    const km = document.getElementById("km"); //km
    const numero = document.getElementById("number"); //numero
    const btnCrearVehiculo = document.querySelector('input[type="button"][value="Crear vehiculo"]');
    const elementosFormulario = document.querySelectorAll('input[type="text"], input[type="number"]');
    console.log(elementosFormulario);
    const btnMostrarVehiculo = document.getElementById('mostrar');
    const vehiculos = [];
    const divVehiculos = document.getElementById("divVehiculos");


    btnCrearVehiculo.addEventListener("click", function (event) {
        event.preventDefault();
        const vehiculo = {
            modelo: modelo.value,
            marca: marca.value,
            precio: precio.value,
            km: km.value
        };
        vehiculos.push(vehiculo);
        limpiar();
    });

    btnMostrarVehiculo.addEventListener("click", function () {
        console.log("Mostrar vehiculos");
        for (let index = 0; index < vehiculos.length; index++) {
            const vehiculo = vehiculos[index];
            const parrafo = document.createElement("p");
            const texto = document.createTextNode("Vehiculo: " + vehiculo.modelo + "\n" +
                "Marca: " + vehiculo.marca + "\n" +
                "Precio: " + vehiculo.precio + "\n" +
                "Km: " + vehiculo.km);
            parrafo.appendChild(texto);
            divVehiculos.appendChild(parrafo);
        }
    })

    function limpiar() {
        elementosFormulario.forEach(element => {
            element.value = "";
        });
        elementosFormulario[0].focus();
    }
});