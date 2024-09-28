/**Ejemplo1: Implementa el siguiente código javaScript donde se crea una nueva ventana, la
cual se va moviendo aleatoriamente.*/

/**Creamos una ventana con opciones predeterminadas
* e imprimimos un mensaje
*/

function app() {
    let ventana = null;
    let opciones = "left = 100, top=100, width=200, height=150", i = 0;

    //Funciones
    function crearVentana() {
        ventana = window.open("", "", opciones);
        ventana.document.write("Esta es la ventana que se ha creado");
    }

    function abrirVentana() {
        ventana.open("", "", opciones);
        console.log("Me he activado y he abierto la ventana");
    }

    function cerrarVentana() {
        ventana.close();
    }


    function moverVentana() {
        ventana.moveBy(5, 5);
        i++;
        if (i < 20) {
            setTimeout(moverVentana, 100);
        } else {
            cerrarVentana();
        }
    }

    //Constantes que llaman a los eventos al pulsar los botones correspondientes

    /**Asignación de eventos a cada botón*/
    document.getElementById("botonCerrar").onclick = cerrarVentana;

    document.getElementById("botonMover").onclick = moverVentana;

    crearVentana();
    abrirVentana();
}
app();