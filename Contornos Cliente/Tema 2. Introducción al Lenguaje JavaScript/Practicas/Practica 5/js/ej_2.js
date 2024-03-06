//Calculamos las unidades de tiempo
const segundo = 1000;
const minuto = segundo * 60;
const hora = minuto * 60;
const dia = hora * 24;
const anho = dia * 365;


let userInput = prompt("Introduce tu fecha de nacimiento (en formato YYYY-MM-DD):");
const fechaActual = new Date();
const fechaNacimiento = new Date(userInput);

//Diferencia en milisegundos
const diferenciaMilisegundos = fechaActual - fechaNacimiento;

//Calculamos la diferencia entre unidades de tiempo
let anhos = Math.floor(diferenciaMilisegundos / anho);
let meses = Math.floor((diferenciaMilisegundos % anho) / (dia * 30.44));
let dias = Math.floor((diferenciaMilisegundos % (dia * 30.44)) / dia);
let horas = Math.floor((diferenciaMilisegundos % dia) / hora);
let minutos = Math.floor((diferenciaMilisegundos % hora) / minuto);
let segundos = Math.floor((diferenciaMilisegundos % minuto) / segundo);

//Imprimimos el mensaje completo
let mensaje = "Tu edad actual es de:\n" +
    anhos + " años\n" +
    meses + " meses\n" +
    dias + " días\n" +
    horas + " horas\n" +
    minutos + " minutos\n" +
    segundos + " segundos.";

document.getElementById("ejercicio2").innerHTML = mensaje;