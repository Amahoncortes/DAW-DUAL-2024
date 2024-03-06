/**Utilizando todas las formas de asignación de eventos,
 *crea un botón que esconda un texto*/

//Forma 2: Hacemos una referencia a la propiedad
document.getElementById("esconder").onclick = function () {
    document.getElementById("texto").style.display = 'none';
}