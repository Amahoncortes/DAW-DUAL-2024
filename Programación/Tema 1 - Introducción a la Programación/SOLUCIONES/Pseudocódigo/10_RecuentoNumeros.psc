// Pseudocódigo que pida números al usuario por teclado y para cada uno 
// de ellos indique si es positivo o negativo. Además, deberá realizar un recuento 
// de los negativos, mostrando por pantalla cuántos se han introducido en total
// Para salir, emplearemos el -999

Algoritmo RecuentoNumeros
	Definir N Como Entero;
	Definir contNeg Como Entero;
	
	contNeg = 0;
	Hacer
		Escribir "Introduzca número";
		Leer Num;
		Si Num <> -999
			Si Num >= 0
				Escribir "El número ", Num, " es positivo";
			SiNo
				Escribir "El número ", Num, " es negativo";
				contNeg = contNeg + 1;
			FinSi
		FinSi
	Mientras Que Num <> -999;
	
	// CON MIENTRAS
//	Escribir "Introduzca número";
//	Leer Num;
//	Mientras Num <> -999
//		Escribir "Introduzca número";
//		Leer Num;
//		Si Num <> -999
//			Si Num >= 0
//				Escribir "El número ", Num, " es positivo";
//			SiNo
//				Escribir "El número ", Num, " es negativo";
//				contNeg = contNeg + 1;
//			FinSi
//		FinSi
//	FinMientras
	
	Escribir "Se han introducido ", contNeg, " números negativos."
FinAlgoritmo
