//Leer desde el teclado una serie de números hasta obtener uno inferior a 100 y par
Algoritmo Menor10
	Definir Num Como Entero;
	
	// MIENTRAS
	//Num <- 11;
	Escribir "Introduzca menor que 100 y par";
	Leer Num;
	
	Escribir "BUCLE MIENTRAS"
	Mientras Num >= 100 o Num % 2 <> 0 Hacer
		Escribir "Introduzca menor que 100 y par";
		Leer Num;
	FinMientras
	
	// Repetir
	Escribir "BUCLE REPETIR"
	Repetir 
		Escribir "Introduzca menor que 100 y par";
		Leer Num;
	Hasta Que Num < 100 y Num % 2 = 0;
FinAlgoritmo
