Algoritmo MayorNumero
	//Escribir Pseudocódigo que lea de entrada 3 números y que indique cuál es el mayor de ellos.
		Definir N1 Como Entero;
		Definir N2 Como Entero;
		Definir N3 Como Entero;
		
		Escribir "Ingrese el número 1: ";
		Leer N1;
		Escribir "Ingrese el número 2: ";
		Leer N2;
		Escribir "Ingrese el número 3: ";
		Leer N3;
		
		Si N1>=N2 y N1>=N3 Entonces
			Escribir "El mayor es: ", N1;
		SiNo
			Si N2>=N1 y N2>=N3 Entonces
				Escribir "El mayor es: ", N2;
			SiNo
					Escribir "El mayor es: ", N3;
			FinSi
		FinSi
		
FinAlgoritmo
