document.addEventListener("DOMContentLoaded", function () {
    console.log("La pagina ha terminado de cargarse");

    //Recoger todos los cuadros de texto y el formulario
    const formulario = document.getElementById("crearVehiculos"); //formulario
    const modelo = document.getElementById("modelo");
    const marca = document.getElementById("marca");
    const precio = document.getElementById("precio");
    const km = document.getElementById("km");
    const mostrar = document.getElementById("mostrar");
    const divVehiculos = document.getElementById("divVehiculos");
    const buscar = document.getElementById('buscar');
    const buscarModelo = document.getElementById('buscarModelo');
    const divVehiculosBuscados = document.getElementById("divVehiculosBuscados");
    //Hacemos una referencia al botón que borra los coches
    const borrarCoche = document.getElementById('removeCoche');
    const btnBorrarCoches = document.getElementById("borrar");
    //Evitamos que, al pulsar submit, se envíe el formulario, y creamos
    //un vehiculo con todas sus propiedades
    formulario.addEventListener("submit", e => {
        e.preventDefault();
        guardarVehiculos();
    });

    //Al pulsar mostrar, vaciamos el contenido de divVehiculos
    //Creamos una unordered list y la appendeamos al divVehiculos
    //Para meterle informacion posterior
    mostrar.addEventListener("click", () => {
        divVehiculos.innerHTML = "";
        const ul = document.createElement("ul");
        divVehiculos.appendChild(ul);

        //Ahora tenemos que recorrer localStorage en su totalidad
        for (let i = 0; i < localStorage.length; i++) {
            //ya que hemos guardado los vehiculos como un JSON (String notación de objeto  JavaScript)
            //convertimos dicho String a un objeto de nuevo con JSON.parse
            //en JSON, se almacenan los datos en pares nombre-valor
            //Por eso, para parsear el JSON, (JSON.parse) debemos hacerlo despues de obtener el item (localStorage.getItem)
            //Y luego debemos obtener su nombre (o clave) (localStorage.key(i)).
            const vehiculo = JSON.parse(localStorage.getItem(localStorage.key(i)));
            const li = document.createElement("li");
            ul.appendChild(li);
            li.innerHTML =
                `🚗Modelo: ${vehiculo.modelo};
                 Marca: ${vehiculo.marca};
                Precio: ${vehiculo.precio} €;
                Km: ${vehiculo.km}`
        }
    });

    buscar.addEventListener("submit", e => {
        e.preventDefault();
        divVehiculosBuscados.innerHTML = "";

        if (localStorage.getItem(buscarModelo.value)) {
            const vehiculo = JSON.parse(localStorage.getItem(buscarModelo.value));
            const p = document.createElement("p");
            p.innerHTML =
                `🚗Modelo: ${vehiculo.modelo};
                 Marca: ${vehiculo.marca};
                Precio: ${vehiculo.precio} €;
                Km: ${vehiculo.km}`
            divVehiculosBuscados.appendChild(p);
        }
    });

    btnBorrarCoches.addEventListener('click', () => {
        if (localStorage.getItem(borrarCoche.value)) {
            localStorage.removeItem(borrarCoche.value);
            console.log("Coche eliminado. Total de coches:", localStorage.length);
        } else {
            console.error('No se encontró ningún coche de ese modelo.');
        }
    });


    //Array de vehiculos
    //let arrayDeVehiculos = [];

    /*Añadir un botón Mostrar que visualice todos los coches aparcados en el
    aparcamiento.
    Para ello debes crear un método imprimirVehiculo que muestre los datos
    utilizando los métodos de creación de nodos de la estructura DOM.
    */

    function guardarVehiculos() {
        // Comprobamos que los elementos están definidos
        if (modelo?.value && marca?.value && precio?.value && km?.value) {
            const vehiculo = new Vehiculo(modelo.value, marca.value, precio.value, km.value);
            localStorage.setItem(vehiculo.getModelo(), JSON.stringify(vehiculo));

            // Cuento el total de vehiculos
            console.log("Vehiculo creado. Total de vehiculos:", localStorage.length);

            formulario.reset();
        } else {
            console.error("Error: Todos los campos deben tener valores");
        }
    }

});