// Implementar un programa que reciba del usuario un número y devuelva el nombre del mes del año asociado. 
// En caso de que el número sea incorrecto, devolver un mensaje de error.

Algoritmo ComprobarMes
	Definir mes Como Entero;
	Escribir "Introduzca un número de mes";
	Leer mes;
	
	Segun mes Hacer
		Caso 1:
			Escribir "Enero";
		Caso 2:
			Escribir "Febrero";
		Caso 3:
			Escribir "Marzo";
		Caso 4:
			Escribir "Abril";
		Caso 5:
			Escribir "Mayo";
		Caso 6:
			Escribir "Junio";
		Caso 7:
			Escribir "Julio";
		Caso 8:
			Escribir "Agosto";
		Caso 9:
			Escribir "Septiembre";
		Caso 10:
			Escribir "Octubre";
		Caso 11:
			Escribir "Noviembre";
		Caso 12:
			Escribir "Diciembre";
		De Otro Modo:
			Escribir "Mes no válido";
	FinSegun
FinAlgoritmo
