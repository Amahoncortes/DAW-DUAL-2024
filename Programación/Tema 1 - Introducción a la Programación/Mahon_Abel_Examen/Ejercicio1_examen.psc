Algoritmo Ejercicio1_examen
	Definir numeroIntroducido como Entero;
	Definir diasValidos Como Entero;
	
	diasValidos = 0;
	
	Escribir "Dame un dia(del 1 al 31)";
	Leer numeroIntroducido;
	
	Mientras (numeroIntroducido <> -1)
		Si (numeroIntroducido > 31 o  numeroIntroducido < 1)
			Escribir "Error. Dia invalido.";
		SiNo
			diasValidos <- diasValidos +1;
		FinSi
		
		Escribir "Dame un dia(del 1 al 31)";
		Leer numeroIntroducido;
	FinMientras
	
	Escribir "Se han introducido un total de " diasValidos " dias.";
FinAlgoritmo
