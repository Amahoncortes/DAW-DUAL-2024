Algoritmo sin_titulo
	Definir N Como Entero;
	Definir cont Como Entero;
	Definir aux Como Entero;
	
	Escribir "Introduzca número";
	Leer N;
	
	Escribir "MIENTRAS"
	cont = 0;
	Mientras cont<=N Hacer
		Escribir cont;
		cont = cont + 1;
	FinMientras
	
	Escribir "REPETIR";
	cont = 0;
	Repetir 
		Escribir cont;
		cont = cont + 1;
	Hasta Que cont > N;
	
	Escribir "PARA"
	Para aux <- 0 Hasta N Con Paso 1 Hacer
		Escribir aux;
	FinPara
FinAlgoritmo
