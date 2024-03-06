//Escribir un Pseudocódigo que calcule la suma 
//de los N primeros números enteros positivos
Algoritmo sumaEnteros
	Definir N Como Entero;
	Definir aux Como Entero;
	Definir suma Como Entero;
	
	Escribir "Introduzca un número:";
	Leer N;
	
	// MIENTRAS
	aux<-N;
	suma<-0;
	Mientras aux>0 Hacer
		suma <- suma + aux;
		aux <- aux-1;
	FinMientras
	
	// REPETIR DECREMENTAL
	aux<-N;
	suma<-0;
	Repetir
		suma <- suma + aux;
		aux <- aux - 1;
	Hasta Que aux = 0;
	
	// REPETIR INCREMENTAL
	aux <- 0;
	suma <- 0;
	Repetir
		suma <- suma + aux;
		aux <- aux + 1;
	Hasta Que aux > N;
	
	// PARA
	suma <- 0;
	Para aux <- 1 Hasta N Con Paso 1 Hacer
		suma <- suma + aux;
	FinPara
	Escribir suma;
FinAlgoritmo
