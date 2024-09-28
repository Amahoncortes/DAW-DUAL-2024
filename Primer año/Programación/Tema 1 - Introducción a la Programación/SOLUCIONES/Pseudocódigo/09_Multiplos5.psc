// Escribir un Pseudocódigo que cuente cuántos múltiplos de 5 
// existen entre 2 números solicitados al usuario

Algoritmo Multiplos5
	Definir i Como Entero;
	Definir N1 Como Entero;
	Definir N2 Como Entero;
	Definir cont Como Entero;
	
	Escribir "Introduzca N1";
	Leer N1;
	
	Escribir "Introduzca N2";
	Leer N2;
	
	Para i=N1 Hasta N2
		Si i mod 5=0
			cont = cont + 1;
		FinSi
	FinPara
	Escribir "Existen ", cont, " múltiplos de 5 entre ", N1, " y ", N2;
FinAlgoritmo
