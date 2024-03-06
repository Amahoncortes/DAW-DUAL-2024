/**Ejercicio 1:  Mostrar la fecha actual de las siguientes formas utilizando la clase Date 
 *● 01/10/2019 
 ● 01 de octubre  de 2019 
 ● Martes,01 de octubre de 2019 */

//Creamos un objeto fecha y especificamos la fecha
const d = new Date("1 Oct 2019");

//Creamos un array de dias
const dias = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"];

//Creamos un array de meses
const meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];


//Obtener el dia
const dia = d.getDate();
const diaFormateado = (dia < 10) ? '0' + dia : dia;
const indiceDia = d.getDate();
const nombreDia = dias[indiceDia];


//Obtener el mes
const mes = d.getMonth() + 1;
const mesFormateado = (mes < 10) ? '0' + mes : mes;

const indiceMes = d.getMonth(); //Obtiene el indice del mes a buscar en el array
const nombreMes = meses[indiceMes]; //busca en el array el indice del mes especificado y devuelve el nombre de, en este caso, el indice 9, que es Octubre.

//Obtener el año
const anho = d.getFullYear();
console.log(anho);

//cambiar nombre de variables con f2

let fecha1 = diaFormateado + "/" + mesFormateado + "/" + anho;
console.log(fecha1);

let fecha2 = diaFormateado + " de " + nombreMes + " de " + anho;

let fecha3 = nombreDia + ", " + diaFormateado + " de " + nombreMes + " de " + anho;

document.getElementById("date1").innerHTML = fecha1;
document.getElementById("date2").innerHTML = fecha2;
document.getElementById("date3").innerHTML = fecha3;


