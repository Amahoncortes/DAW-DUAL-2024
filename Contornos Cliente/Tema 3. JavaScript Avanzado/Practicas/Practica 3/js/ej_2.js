/**Los elementos habrán de ser creados en el arbol DOM. */

window.addEventListener("DOMContentLoaded", () => {
    console.log("La pagina se ha cargado correctamente.");
    /**Paso 1: Añadir el articulo con los botones asociados.*/
    let entrada = document.getElementById("entrada");
    let precio = document.getElementById("precio");
    const btnAnadir = document.getElementById("botonAnadir");
    const btnBorrar = document.getElementById("botonBorrar");
    const listaC = document.getElementById("listaC");
    const listaE = document.getElementById("listaE");

    /**2. Al introducir los valores en el cuadro de texto deben aparecer asteriscos
     *en lugar del valor introducido.  */
    // Agregar eventos oninput para entrada y precio


    localStorage.clear();
    console.log("Almacen vacio");

    //Entrada = password
    entrada.addEventListener("input", () => {
        entrada.setAttribute("type", "password");
    })

    precio.addEventListener("input", () => {
        precio.setAttribute("type", "password");
    })

    btnAnadir.addEventListener("click", guardarArticulos);

    function guardarArticulos() {
        if (entrada?.value && precio?.value) {
            const articulo = new Articulo(entrada.value, precio.value);
            localStorage.setItem(articulo.getNombre(), JSON.stringify(articulo));
            console.log("Articulo guardado. Total de articulos: ", localStorage.length);
            document.getElementById("elFormulario").reset();
        } else {
            console.error("Error. Todos los campos deben tener valores.")
            alert("Error. Todos los campos deben tener valores.");
        }



        //MOSTRAR LA INFORMACION DE LOS ARTICULOS GUARDADOS
        listaC.textContent = "";
        //recorremos localStorage para acceder a la informacion de su interior
        for (let i = 0; i < localStorage.length; i++) {
            const articulo = JSON.parse(localStorage.getItem(localStorage.key(i)));
            const li = document.createElement("li");

            listaC.appendChild(li);

            li.innerHTML =
                `Nombre: ${articulo.nombre};
                Precio: ${articulo.precio};
              `;
            console.log("Articulos mostrados correctamente.");
        }
    }
});
