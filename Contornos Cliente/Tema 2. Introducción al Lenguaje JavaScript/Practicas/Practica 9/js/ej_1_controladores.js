//Forma 4 :con una funcion controller
function esconderTexto() {
    document.getElementById("texto").style.display = 'none';
}

//Hacemos el controlador
const cargar = function () {
    //Obtener todos los objetos del parrafo y el boton
    const boton = document.querySelector("input");
    const texto = document.getElementById("texto");
    boton.addEventListener('click', esconderTexto);
}

//Nos aseguramos de que no se ejecuta hasta que esté cargada toda la estructura DOM
document.addEventListener("DOMContentLoaded", cargar);