window.onload = function () {
    const datosClientes = [
        { id: 1, email: "michael.lawson@reqres.in", first_name: "Michael", last_name: "Lawson" },
        { id: 2, email: "lindsay.ferguson@reqres.in", first_name: "Lindsay", last_name: "Ferguson" },
        { id: 3, email: "tobias.funke@reqres.in", first_name: "Tobias", last_name: "Funke" },
        { id: 4, email: "byron.fields@reqres.in", first_name: "Byron", last_name: "Fields" }
    ];

    const datosPizza = [
        { nombre: "Pizza margarita", precio: 20, identificador: 1, ingredientes: ["Champiñones", "Jamón Cocido"] },
        { nombre: "Pizza barbacoa", precio: 25, identificador: 2, ingredientes: ["Carne", "Salsa barbacoa", "Extra de queso"] },
        { nombre: "Pizza atún", precio: 22, identificador: 3, ingredientes: ["Atún", "Aceitunas negras", "Anchoa"] }
    ];

    const clienteId = parseInt(window.prompt("Introduce la ID del cliente:"));

    resetearLocalStorage();
    //Apartado 1
    mostrarDatosCliente();
    //Apartado 2
    mostrarPizzas();
    //Apartado 3
    buscarPizzaPorId();
    //Apartado 4 y 5
    crearBotonComprar();

    function mostrarDatosCliente() {

        const cliente = datosClientes.find(cliente => cliente.id === clienteId);

        if (cliente) {
            const encabezadoCliente = document.createElement("h1");
            const parrafoCliente = document.createElement("p");
            parrafoCliente.textContent = `Datos del cliente: Nombre: ${cliente.first_name} ${cliente.last_name} Email: ${cliente.email}  ID: ${cliente.id}`;
            parrafoCliente.style.textAlign = "center";
            parrafoCliente.style.fontSize = "20px";
            parrafoCliente.style.fontWeight = "bold";

            encabezadoCliente.appendChild(parrafoCliente);
            document.getElementById("cliente").appendChild(encabezadoCliente);
        } else {
            //En caso de que no lo encuentre muestra un alert.
            alert("Cliente no encontrado");
        }
    }


    //Apartado 2 : Mostrar los datos en formato tabla
    function mostrarPizzas() {
        const tabla = document.createElement("table");
        const encabezado = document.createElement("tr");
        const encabezadoCeldas = ["ID", "Nombre", "Ingredientes", "Precio"];

        encabezadoCeldas.forEach(celda => {
            const encabezadoCelda = document.createElement("th");
            encabezadoCelda.textContent = celda;
            encabezado.appendChild(encabezadoCelda);
        });

        tabla.appendChild(encabezado);

        datosPizza.forEach(pizza => {
            const celdas = document.createElement("tr");

            Object.values(pizza).forEach(celda => {
                const celdaP = document.createElement("td");
                celdaP.textContent = celda;
                celdas.appendChild(celdaP);
            });

            tabla.appendChild(celdas);
        });

        document.getElementById("pizzas").appendChild(tabla);
    }



    /**▪ Apartado 3: Utilizando el mismo identificador del cliente, busca la pizza cuyo identificador
    sea igual al identificador del cliente. Si lo encuentra muestra los ingredientes de la pizza,
    creando la estructura de nodos para que tenga el siguiente aspecto. */

    function buscarPizzaPorId() {
        const cliente = datosClientes.find(cliente => cliente.id === clienteId);

        if (cliente) {
            const pizzaId = clienteId;
            const pizza = datosPizza.find(pizza => pizza.identificador === pizzaId);

            if (pizza) {
                const encabezadoPizza = document.createElement("h1");
                const parrafoPizza = document.createElement("p");
                parrafoPizza.textContent = `Ingredientes de la pizza: ${pizza.ingredientes || ''}`;
                parrafoPizza.style.textAlign = "center";
                parrafoPizza.style.fontSize = "20px";
                parrafoPizza.style.fontWeight = "bold";
                encabezadoPizza.appendChild(parrafoPizza);
                const pizzasSection = document.getElementById("pizzas");
                if (pizzasSection) {
                    pizzasSection.appendChild(encabezadoPizza);
                } else {
                    console.error("No se encontró el elemento con el id 'pizzas'.");
                }
            } else {
                alert("No se ha encontrado una pizza con el identificador del cliente.");
            }
        } else {
            alert("Cliente no encontrado.");
        }
    }


    //Apartado 4: Crear boton Comprar
    function crearBotonComprar() {
        const botonComprar = document.createElement("button");
        botonComprar.textContent = "Comprar pizza y guardarla";
        botonComprar.addEventListener("click", () => {
            guardarEnLocalStorage();
        });
        //Funcion auxiliar para 
        mostrarLocalStorage();
        document.getElementById("pizzas").appendChild(botonComprar);
    }

    //Apartado 5: Al pulsar el botón Comprar, almacena en el LocalStorage.
    function guardarEnLocalStorage() {
        localStorage.setItem("pizzas", JSON.stringify(datosPizza));
        alert("Pizzas guardadas en el local storage");
    }

    //ESTA FUNCION NO ES DEL EXAMEN
    function mostrarLocalStorage() {
        const pizzas = JSON.parse(localStorage.getItem("pizzas"));
        if (pizzas) {
            alert("Hay pizzas en el localStorage");
        } else {
            alert("No hay pizzas guardadas en el local storage");
        }
    }

    //ESTA FUNCION NO ES DEL EXAMEN
    function resetearLocalStorage() {
        localStorage.clear();
    }
}