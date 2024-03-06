// Pseudoc�digo que pida n�meros al usuario por teclado y para cada uno 
// de ellos indique si es positivo o negativo. Adem�s, deber� realizar un recuento 
// de los negativos, mostrando por pantalla cu�ntos se han introducido en total
// Para salir, emplearemos el -999

Algoritmo RecuentoNumeros
	Definir N Como Entero;
	Definir contNeg Como Entero;
	
	contNeg = 0;
	Hacer
		Escribir "Introduzca n�mero";
		Leer Num;
		Si Num <> -999
			Si Num >= 0
				Escribir "El n�mero ", Num, " es positivo";
			SiNo
				Escribir "El n�mero ", Num, " es negativo";
				contNeg = contNeg + 1;
			FinSi
		FinSi
	Mientras Que Num <> -999;
	
	// CON MIENTRAS
//	Escribir "Introduzca n�mero";
//	Leer Num;
//	Mientras Num <> -999
//		Escribir "Introduzca n�mero";
//		Leer Num;
//		Si Num <> -999
//			Si Num >= 0
//				Escribir "El n�mero ", Num, " es positivo";
//			SiNo
//				Escribir "El n�mero ", Num, " es negativo";
//				contNeg = contNeg + 1;
//			FinSi
//		FinSi
//	FinMientras
	
	Escribir "Se han introducido ", contNeg, " n�meros negativos."
FinAlgoritmo
