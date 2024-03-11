<?php
class Circulo extends Figura
{
    public const PI = 3.1416;
    private float $radio;

    private Point $centro;





    public function calcularArea()
    {
        //return $this->radio * $this->radio * self::PI;
        return pow($this->radio, 2) * self::PI;
    }





}