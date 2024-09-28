var sum = 0;
var num = 1;
while(num >=0) {
    var num = parseInt(prompt('Introduce un numero'));
    if (num > 0)
        sum = num + sum;
}

document.write("La suma de los numeros es: " + sum);