//Escribir un Pseudocódigo que calcule el factorial de un número
Algoritmo Factorial
	Definir Num Como Entero;
	Definir aux Como Entero;
	Definir facto Como Entero;
	
	Escribir "Ingrese el número: ";
	Leer Num;
	
	aux <- Num-1;
	facto <- Num;
	Hacer
		facto <- facto * aux;
		aux <- aux -1;
	Mientras Que aux > 1
	Escribir "El factorial de ", Num, " es: ", facto;
FinAlgoritmo
