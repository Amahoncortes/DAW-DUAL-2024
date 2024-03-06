<?php
require_once 'header.php';
//incluir las clases Circulo y cuadrado
require_once 'Circulo.php';
require_once 'Cuadrado.php';
// $my_class = new MiClase();
// $my_class->foo();
// echo "<p> cte pública " . MiClase::MY_PUBLIC . "</p>";
// //echo "<p> cte private " . MiClase::MY_PRIVATE . "</p>";

$puntoA = new Point(0, 0);
$puntoA->mostrarCoord();

$puntoB = new Point(100, 0);
$puntoB->mostrarCoord();

$cuadrado = new Cuadrado("Cuadrado", 4, $puntoA, 4);

$area_cuadrado = $cuadrado->calcularArea();
echo "<p>El área del cuadrado  es $area_cuadrado</p>";

$circulo = new Circulo("Círculo", 3.5, $puntoB);
$area_circulo = $circulo->calcularArea();
echo "<p>El área del círculo es $area_circulo</p>";


//5- Crea un array de figuras en index.php. Añade en el array  tanto el $circulo como el $cuadrado

$myArr = array($circulo, $cuadrado);


//6- Recorre el array de figuras llamando a sus métodos verInformacion y calcularArea, mostrando el resultado del área calculada.

foreach ($myArr as $figura) {
    $figura->verInformacion();
    $area = $figura->calcularArea();
    echo "\n";
}