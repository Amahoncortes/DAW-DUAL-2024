

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


//Conseguir todos los divs de la pagina
var todosLosDiv=document.getElementsByTagName('div');
console.log(todosLosDiv);

//Crea nuevos elementos y los añade a la sección
var seccion=document.querySelector("#nuevaSeccion");
var hr= document.createElement("hr");

seccion.append(hr);

console.log(todosLosDiv);

//Bucle para visualizar el contenido
for (let valor in todosLosDiv)
    console.log(todosLosDiv[valor].innerHTML);

//Creo una lista de elementos con todos los valores de tipo div que tengo en mi pagina
for (let valor in todosLosDiv) {

    if (typeof todosLosDiv[valor].textContent=='string'){

        var parrafo=document.createElement("p");
        var texto=document.createTextNode(todosLosDiv[valor].textContent);
        parrafo.append(texto);
        document.querySelector("#nuevaSeccion").append(parrafo);

        //Otra forma
        //parrafo.append(texto);
        //document.querySelector("#nuevaSeccion").prepend(parrafo);
    }
    
}

//Seleccionar elementos por su clase css
/*var divsRojos=document.getElementsByClassName('rojo');
console.log(divsRojos);

for (let clase in divsRojos){
    if (divsRojos[clase].className == "rojo")
        divsRojos[clase].style.background="red";
}*/
