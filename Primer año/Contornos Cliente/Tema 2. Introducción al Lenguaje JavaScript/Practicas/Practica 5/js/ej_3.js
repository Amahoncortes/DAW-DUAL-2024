//Calculamos las unidades de tiempo
const segundo = 1000;
const minuto = segundo * 60;
const hora = minuto * 60;
const dia = hora * 24;

let userInput = prompt("Introduce la fecha del evento (en formato YYYY-MM-DD):");
const fechaActual = new Date();
const fechaEvento = new Date(userInput);


//Diferencia en milisegundos
const diferenciaMilisegundos = fechaEvento - fechaActual;


//Calculamos la diferencia entre unidades de tiempo
let dias = Math.floor((diferenciaMilisegundos % (dia * 30.44)) / dia);
let horas = Math.floor((diferenciaMilisegundos % dia) / hora);
let minutos = Math.floor((diferenciaMilisegundos % hora) / minuto);
let segundos = Math.floor((diferenciaMilisegundos % minuto) / segundo);

//Imprimimos el mensaje completo
let mensaje = "Faltan:\n" +
    dias + " días\n" +
    horas + " horas\n" +
    minutos + " minutos\n" +
    segundos + " segundos.";

    document.getElementById("ejercicio3").innerHTML = mensaje;