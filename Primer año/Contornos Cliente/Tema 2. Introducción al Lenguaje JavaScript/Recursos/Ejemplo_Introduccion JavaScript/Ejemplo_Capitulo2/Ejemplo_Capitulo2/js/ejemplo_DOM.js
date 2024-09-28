

//Función que cambia el color
function cambiaCol(color){
    caja.style.background=color;
}

var caja=document.getElementById("micaja");




console.log("El valor original " +caja.innerHTML);
//Llamada a la función
cambiaCol("blue");

//devuelve o establece la sintaxis HTML 
caja.innerHTML="TEXTO QUE CAMBIA";
//caja.style.background="red";
caja.style.padding="20px";

console.log("El valor ya modificado "+caja.innerHTML);

// Crear nodo de tipo Element
var parrafo = document.createElement("p");
// Crear nodo de tipo Text
var contenido = document.createTextNode("Hola Mundo!");
// Añadir el nodo Text como hijo del nodo Element
parrafo.appendChild(contenido);
// Añadir el nodo Element como hijo de la pagina
document.body.appendChild(parrafo);