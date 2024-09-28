/*Al cargar la página,
 el usuario introduce el número de cajas que quiere crear. 
 Una vez que han sido creadas, al pasar con el ratón por encima cambia de color,
 y al salir de la caja vuelve al color inicial.
El cuadro de texto asociado al botón antes,
indica la posición indice para crear una caja y añadir antes
de la posición indicada (en el ejemplo es la caja de color verde)
Comportamiento similar al texto asociado al botón después.
(En el ejemplo es la caja de color naranja)*/


/**El primer paso es asegurarse de que no realizamos nada hasta haber cargado
 *completamente la página */

"use strict"

window.addEventListener("DOMContentLoaded", () => {
  console.log("La pagina ha terminado de cargarse.");

   window.alert("Alerta");
   window.confirm("Confirma");
   window.prompt("Introduce un valor");

  //Después, nos aseguramos de obtener todos los cuadros de texto cuyos valores
  //influyen en el comportamiento de los botones que queremos manipular / pulsar

  //Obtenemos el botón por su ID en el HTML
  let crear = document.getElementById("crearCajas");
  //Le añadimos un addEventListener para que reaccione al evento click
  //ejecutando una función. NO USAR PARENTESIS EN EL ADDEVENTLISTENER.
  //NO ESTAMOS LLAMANDO A LA FUNCION, SOLO AGREGANDOLE EL ESCUCHADOR DE EVENTOS.
  crear.addEventListener("click", crearCajas);

  //Hacemos lo mismo con los botones insertarAntes e insertarDespues
  let antes = document.getElementById("anadirAntes");
  antes.addEventListener("click", anadirAntes);

  let despues = document.getElementById("anadirDespues");
  despues.addEventListener("click", anadirDespues);

  //Hacemos la función de crearCajas

  function crearCajas() {
    //Pasos para crear elementos de la estructura DOM
    //Obtenemos el numero de cajas que queremos crear
    let numero = parseInt(document.getElementById("cantidad").value);
    console.log(numero);

    //Obtenemos el numero total de cajas devolviendo el numero de nodos que coinciden con "caja"
    let numeroDeCajas = document.querySelectorAll("caja").length;
    console.log(numeroDeCajas);

    //Ahora que tenemos todas las cajas, las recorremos y le asignamos a cada una un div y un id
    for (let i = numeroDeCajas; i < numero + numeroDeCajas; i++) {

      let caja = document.createElement("div");
      console.log(caja);

      caja.innerHTML = `<h1>${i + 1}</h1>`;

      //asignar estilos a la caja
      caja.setAttribute("class", "caja");

      //Poner las cajas a la escucha de los eventos mouse


      //Añadir las cajas al documento
      let seccion = document.getElementById("seccion");
      seccion.appendChild(caja);
    }
  }


  /**Añadir cajas antes de una posicion determinada*/
  function anadirAntes() {

    //Obtenemos las cajas ya existentes, aquellas que existan en el documento con className caja
    let cajasCreadas = document.getElementsByClassName("caja");

    //Obtenemos la posición donde queremos insertar cajas nuevas a través del cuadro de texto:
    let posicion = document.getElementById('numeroAnterior').value - 1;

    //Obtenemos el padre de las cajas para asegurarnos de que estamos en el mismo contenedor que estas
    //Posteriormente, utilizaremos esta variable padre para insertar la nueva caja anterior a la posicion deseada.
    let padre = cajasCreadas[0].parentNode;

    //Crear la nueva caja
    let nuevaCaja = document.createElement("div");

    //Asignar estilos a la caja
    nuevaCaja.setAttribute("class", "caja amarillo");
    nuevaCaja.addEventListener("mouseenter", cambiarColor);
    nuevaCaja.addEventListener("mouseleave", volverColor);

    if (posicion > cajasCreadas.length - 1) {
      posicion = cajasCreadas.length - 1;
    }

    //Ahora usamos el padre con la funcion insertBefore para insertar la caja nueva
    //antes de la posicion deseada. insertBefore toma como parametros el elemento nuevo, y la 
    //**EJEMPLO***/
    //var insertedNode = parentNode.insertBefore(newNode, referenceNode);
    //insertedNode El nodo que esta siendo insertado, es decir, newNode
    //parentNode El padre del nodo recién insertado.
    //newNode El nodo a insertar.
    //referenceNode El nodo antes del cual se inserta newNode.
    padre.insertBefore(nuevaCaja, cajasCreadas[posicion]);

    //Volver a numerar las cajas
    for (let i = 0; i < cajasCreadas.length; i++) {
      //asignar un id a la caja
      cajasCreadas[i].setAttribute('id', i);
      cajasCreadas[i].innerHTML = `<h1>${i + 1}</h1>`;
    }
  }

  /**Funcion para insertar un elemento después de una posición dada
   *, ya que no existe en JavaScript, la hacemos nosotros.
  */
  function insertAfter(elemento, item) {
    //Verificar si el elemento tiene un nodo despues (nextSibling)
    if (elemento.nextSibling) {
      //Si tiene un nodo siguiente,  inserta el item antes de ese nodo (insertBefore)
      elemento.parentNode.insertBefore(item, elemento.nextSibling);
      //Si no tiene un nodo siguiente, simplemente agrega el item al final del padre
    } else {
      elemento.parentNode.appendChild(item);
    }
  }

  function anadirDespues() {
    //Obtenemos las cajas ya existentes, aquellas que existan en el documento con className caja
    let cajasCreadas = document.getElementsByClassName("caja");

    //Obtenemos la posición donde queremos insertar cajas nuevas a través del cuadro de texto:
    let posicion = document.getElementById('numeroPosterior').value - 1;

    //Obtenemos el padre de las cajas para asegurarnos de que estamos en el mismo contenedor que estas
    //Posteriormente, utilizaremos esta variable padre para insertar la nueva caja posterior a la posicion deseada.
    let padre = cajasCreadas[0].parentNode;

    //Crear la nueva caja
    let nuevaCaja = document.createElement("div");

    //Asignar estilos a la caja
    nuevaCaja.setAttribute("class", "caja naranja");
    nuevaCaja.addEventListener("mouseenter", cambiarColor);
    nuevaCaja.addEventListener("mouseleave", volverColor);

    if (posicion > cajasCreadas.length) {
      padre.appendChild(nuevaCaja);
    } else {
      padre.insertBefore(nuevaCaja, cajasCreadas[posicion + 1]);
    }

    //Llamamos a la función personalizada insertAfter(referenceNode, newNode)
    //referenceNode El nodo despues del cual se inserta newNode.
    //newNode El nodo a insertar.
    //insertAfter(cajasCreadas[posicion], nuevaCaja);

    //Volver a numerar las cajas
    for (let i = 0; i < cajasCreadas.length; i++) {
      //Asignar un id a la caja
      cajasCreadas[i].setAttribute('id', i);
      cajasCreadas[i].innerHTML = `<h1>${i + 1}</h1>`;
    }
  }


  /**Función que cambia el color de la caja al pasar con el ratón por encima*/
  function cambiarColor(event) {
    //Forma 1 
    //this.style.background = 'blue';
    //Forma 2
    event.target.style.background = "blue";
  }

  /**Función que vuelve al color original al sacar el ratón.*/
  function volverColor() {
    //Para ello debe comprobar de que clase se trata
    console.log("De que clase se trata " + this.getAttribute("class"));
    if (this.getAttribute('class') == "caja amarillo") {
      this.style.background = "chartreuse";
    } else if (this.getAttribute('class') == "caja naranja") {
      this.style.background = 'orangered';
    } else {
      this.style.background = "blueviolet";
    }
  }
});