document.addEventListener("DOMContentLoaded", function () {

    /** Ejercicio 1: Implementa la siguiente página y almacena los datos de los alumnos.
     * Almacena los datos de forma local.
     * 
     * 
     * PASOS: 
     * 1: Crea un objeto javascript ALUMNO con los siguientes campos
     *  ▪ Nombre:
     *  ▪ DNI:
     *  ▪ Direccción
     * */
    //Lo creamos en una clase separada Alumno.js a la que referenciamos en el html

    //Recoger todos los cuadros de texto y el formulario
    const formAddAlumnos = document.getElementById("formalumnos");
    const nombre = document.getElementById("addNombre");
    const direccion = document.getElementById("addDireccion");
    const dni = document.getElementById("addDni");
    const mostrar = document.getElementById("mostrar");
    const divAlumnos = document.getElementById("alumnos");
    const buscar = document.getElementById("buscar");
    const buscarAlumno = document.getElementById("buscarAlumno");
    const divAlumnosBuscados = document.getElementById("divAlumnosBuscados");
    const borrarAlumno = document.getElementById("removeAlumno");
    const btnborrarAlumnos = document.getElementById("borrar");
    const divAlumnosBorrados = document.getElementById("divAlumnosBorrados");



    /**2: Añade los metodos:
     *  Constructor
     *  Guardar
     *  Mostrar
     */


    //Evitamos que , al pulsar submit, se envíe el formulario,
    //Y guardamos un alumno con todas sus propiedades
    formAddAlumnos.addEventListener("submit", e => {
        e.preventDefault();
        guardarAlumnos();
    })


    //Al pulsar mostrar, vaciamos el contenido de divAlumnos
    //Creamos una lista desordenada y la appendeamos a divAlumnos 
    //Para meterle información posteriormente
    mostrar.addEventListener("click", () => {
        divAlumnos.innerHTML = "";
        const ul = document.createElement("ul");
        divAlumnos.appendChild(ul);
        //Recorremos LocalStorage
        for (let i = 0; i < localStorage.length; i++) {
            const alumno = JSON.parse(localStorage.getItem(localStorage.key(i)));
            const li = document.createElement("li");
            ul.appendChild(li);
            li.innerHTML =
                `Nombre: ${alumno.nombre};
                 Direccion: ${alumno.direccion};
                dni: ${alumno.dni}`;
            console.log("Alumnos mostrados correctamente.");
        }
    });


    /**El metodo buscar previene el envio del formulario
     * y busca a un alumno determinando si su nombre existe en LocalStorage
     * (if(localStorage.getItem(buscarAlumno.value)))
     * Si existe, convierte el string devuelto con los atributos a un objeto,
     * crea un parrafo que contiene la informacion de alumno, y lo vincula al div de 
     * alumnos buscados.
    */
    buscar.addEventListener("submit", e => {
        e.preventDefault();
        divAlumnosBuscados.innerHTML = "";
        if (localStorage.getItem(buscarAlumno.value)) {
            const alumno = JSON.parse(localStorage.getItem(buscarAlumno.value));
            const p = document.createElement("p");
            p.innerHTML =
                `Nombre: ${alumno.nombre};
                 Direccion: ${alumno.direccion};
                dni: ${alumno.dni}`;
            divAlumnosBuscados.appendChild(p);
        }
    });

    btnborrarAlumnos.addEventListener("click", () => {
        divAlumnosBorrados.innerHTML = "";
        const alumnoBorradoNombre = borrarAlumno.value;
        if (localStorage.getItem(alumnoBorradoNombre)) {
            localStorage.removeItem(alumnoBorradoNombre);
            console.log("Alumno borrado. Total de alumnos: ", localStorage.length);
        } else {
            console.error("No se encontró ningún alumno con ese nombre");
        }
    });




    /** Funcion que primero valida si los campos del formulario están
     * definidos. Si lo están, crea un nuevo alumno y lo almacena en LocalStorage.
     * Después, cuenta el total de alumnos y vacía el formulario para rellenar
     * un nuevo elemento. Si nos saltamos algun campo, da error.
    */

    function guardarAlumnos() {
        

        //Comprobamos que los elementos estén definidos
        if (nombre?.value && direccion?.value && dni?.value) {
        
            //Si lo están , creamos un nuevo objeto con los valores del formulario
            const alumno = new Alumno(nombre.value, direccion.value, dni.value);
            //y lo metemos en el almacenamiento local
            localStorage.setItem(alumno.getNombre(), JSON.stringify(alumno));

            //Contamos el total de alumnos
            console.log("Alumno guardado. Total de alumnos: ", localStorage.length);
            formAddAlumnos.reset();

        } else {
            console.error("Error. Todos los campos deben tener valores.");
        }
    }

});