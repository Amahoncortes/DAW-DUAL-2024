// Escribir un Pseudoc�digo que cuente cu�ntos m�ltiplos de 5 
// existen entre 2 n�meros solicitados al usuario

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
	Escribir "Existen ", cont, " m�ltiplos de 5 entre ", N1, " y ", N2;
FinAlgoritmo
