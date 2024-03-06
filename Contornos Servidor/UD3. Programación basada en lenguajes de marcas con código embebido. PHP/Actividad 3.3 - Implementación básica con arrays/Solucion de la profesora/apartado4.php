<?php
$n = 2;
const TOPE_MAX= 10;


$tabla= [];

for ($i=0; $i <=TOPE_MAX ; $i++) { 
   $tabla["{$n}x{$i}"]=$n*$i;
}
echo "<pre>";
print_r($tabla);
echo "</pre>";

?>