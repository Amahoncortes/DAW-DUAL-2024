/**Utilizando todas las formas de asignación de eventos,
 *crea un botón que esconda un texto*/

 //Forma 3: Añadimos un escuchador de eventos al botón
 document.getElementById("esconder").addEventListener('click', () => {
    document.getElementById("texto").style.display = 'none';
});