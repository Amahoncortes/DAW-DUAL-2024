<?php
class Circulo extends Figura
{
    public const PI = 3.1416;
    private float $radio;

    private Point $centro;


    function __construct(string $nombre, float $radio, Point $centro) {
        parent::__construct($nombre);
        $this->radio = $radio;
        $this->centro = $centro;
    }


    public function calcularArea()
    {
        //Calculamos el area de la figura
        parent::calcularArea();

        //return $this->radio * $this->radio * self::PI;
        return pow($this->radio, 2) * self::PI; 
    }

    
}