<?php
class Figura
{
    protected int $num_lados;
    protected string $nombre;

    

    public function calcularArea()
    {
    
    }

    public function __construct(string $nombre, int $num_lados = 0)
    {
        $this->nombre = $nombre;
        $this->num_lados = $num_lados;
    }



}