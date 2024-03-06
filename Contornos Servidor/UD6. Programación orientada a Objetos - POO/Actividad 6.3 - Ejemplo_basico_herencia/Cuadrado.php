<?php
class Cuadrado extends Figura
{
    private float $lado;

    private Point $bottonLeft;



    public function __construct(string $nombre, float $lado, Point $bottomLeft, int $num_lados = 0)
    {

        parent::__construct($nombre, $num_lados);
        $this->bottonLeft = $bottomLeft;
        $this->lado = $lado;

    }


    public function calcularArea()
    {
         //Calculamos el area de la figura
         parent::calcularArea();
         
        // return $this->lado * $this->lado;
        return pow($this->lado, 2);
    }

    
}