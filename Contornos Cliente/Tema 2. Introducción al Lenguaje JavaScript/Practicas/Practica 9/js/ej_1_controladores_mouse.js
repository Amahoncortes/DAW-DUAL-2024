 //Forma 5: con una función controller y eventos mouse
 let boton; // Declare boton in the global scope

 function esconderTexto() {
     // Oculta el texto con la propiedad display de CSS
     console.log("Subo");
     texto.style.visibility = "hidden";
     boton.value = "Mostrar";
 }

 function mostrarTexto() {
     console.log("Bajo");
     // Muestra otra vez el texto oculto
     texto.style.visibility = "visible";
     boton.value = "Esconder";
 }

 const cargar = function () {
     // Obtiene los objetos de la página, el párrafo y el botón
     boton = document.querySelector("input");
     const texto = document.getElementById("texto");
     console.log(texto);
     console.log(boton);
     boton.addEventListener("mouseover", esconderTexto);
     boton.addEventListener("mouseout", mostrarTexto);
 };

 // Asegurarse de que no ejecuta hasta que está cargada toda la estructura DOM,
 // similar a window.onload
 document.addEventListener("DOMContentLoaded", cargar);